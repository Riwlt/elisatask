package ee.elisa;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ee.elisa.model.Customer;
import ee.elisa.model.Product;
import ee.elisa.service.RestDataService;
import ee.elisa.utility.Mapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestDataIntegrationTests {
	
	@Autowired
	private RestDataService restDataService;
	
	String jsonString = "{\"customerName\":\"customer customer\",\"companyName\":\"company\",\"street\":\"street\",\"country\":\"country\",\"postalCode\":\"123\",\"city\":123}\r\n";
	
	@Test
	public void afterMappingToObjectIsCorrectValue() {
		try {
			Customer cust = (Customer) Mapper.mapFromJsonToClass(Customer.class, jsonString);
			Assert.assertEquals("customer customer", cust.getCustomerName());
			Assert.assertEquals("company", cust.getCompanyName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getCorrectProductWithCorrectId() {
		Product prod = new Product();
		prod.setProductName("Samsung Galaxy 4");
		Assert.assertEquals(this.restDataService.getProductById(3).getProductName(), prod.getProductName());
	}
	

}
