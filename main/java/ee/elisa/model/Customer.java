package ee.elisa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_data")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "customer_name")
	private String customerName;
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "postal_code")
	private String postalCode;
	
	@Column(name = "city")
	private String city;

	public Customer(long id, String customerName, String companyName, String street, String country, String postalCode,
			String city) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.companyName = companyName;
		this.street = street;
		this.country = country;
		this.postalCode = postalCode;
		this.city = city;
	}

	public Customer() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
