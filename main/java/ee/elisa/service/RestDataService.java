package ee.elisa.service;

import java.util.List;

import ee.elisa.model.Customer;
import ee.elisa.model.Price;
import ee.elisa.model.Product;

public interface RestDataService {
	
	List<Product> getAllProducts();
	List<Price> getAllPrices();
	String postOrder(Customer cust, long productId);
	Product getProductById(long productId);
}
