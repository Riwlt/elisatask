package ee.elisa.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Customer.class)
public abstract class Customer_ {

	public static volatile SingularAttribute<Customer, String> country;
	public static volatile SingularAttribute<Customer, String> city;
	public static volatile SingularAttribute<Customer, String> street;
	public static volatile SingularAttribute<Customer, String> companyName;
	public static volatile SingularAttribute<Customer, String> postalCode;
	public static volatile SingularAttribute<Customer, Long> id;
	public static volatile SingularAttribute<Customer, String> customerName;

	public static final String COUNTRY = "country";
	public static final String CITY = "city";
	public static final String STREET = "street";
	public static final String COMPANY_NAME = "companyName";
	public static final String POSTAL_CODE = "postalCode";
	public static final String ID = "id";
	public static final String CUSTOMER_NAME = "customerName";

}

