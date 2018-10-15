package ee.elisa.service.impl; 

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.validation.ConstraintViolationException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ee.elisa.model.Customer;
import ee.elisa.model.Order;
import ee.elisa.model.Price;
import ee.elisa.model.Product;
import ee.elisa.model.Product_;
import ee.elisa.service.RestDataService;

@Service
public class RestDataServiceImpl implements RestDataService{

	@Autowired
	private SessionFactory factory;
	
	// Get All Products Criteria
	@Override
	public List<Product> getAllProducts(){
		EntityManager em = factory.createEntityManager();
		CriteriaBuilder cb = factory.getCriteriaBuilder();
		// Select
		CriteriaQuery<Product> cq = cb.createQuery(Product.class);
		// From
		Root<Product> rProduct = cq.from(Product.class);
		// Join 
		Join<Product, Price> rJoin = rProduct.join(Product_.price);
		// Where
		cq.where(cb.gt(rJoin.get(Product_.ID), 0));
		TypedQuery<Product> q = em.createQuery(cq);
		return q.getResultList();	
	}
	
	@Override
	public List<Price> getAllPrices() {
		EntityManager em = factory.createEntityManager();
		CriteriaBuilder cb = factory.getCriteriaBuilder();
		// Select
		CriteriaQuery<Price> cq = cb.createQuery(Price.class);
		// From
		Root<Price> rPrice = cq.from(Price.class);
		// Where
		cq.select(rPrice);
		TypedQuery<Price> q = em.createQuery(cq);
		return q.getResultList();	
	}
	@Override
	public String postOrder(Customer cust, long productId) {
		if (cust != null && productId > 0) {
			Session session = null;
			try {
				session = factory.openSession();
				// Saving new customer
				session.save(cust);
				// Saving new order 
				Order order = new Order();
				order.setCustomer(cust);
				order.setProduct(this.getProductById(productId));
				session.save(order);
				// If record already exists.
			} catch (ConstraintViolationException e) {
				return "Record already exists";
			} finally {
				if (session != null) {
					session.close();
				}
			}
		}
		return "Success";
	}

	@Override
	public Product getProductById(long productId) {
		try {
			EntityManager em = factory.createEntityManager();
			CriteriaBuilder cb = factory.getCriteriaBuilder();
			// Select
			CriteriaQuery<Product> cq = cb.createQuery(Product.class);
			// From
			Root<Product> rProduct = cq.from(Product.class);
			// Where id = productId
			cq.where(cb.equal(rProduct.get(Product_.id), cb.parameter(Long.class, Product_.ID)));
			TypedQuery<Product> q = em.createQuery(cq);
			// Set id to product id
			q.setParameter(Product_.ID, productId);
			return q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
}
