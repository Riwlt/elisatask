package ee.elisa.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ee.elisa.model.Customer;
import ee.elisa.model.Product;
import ee.elisa.service.RestDataService;
import ee.elisa.utility.Mapper;

@RestController
@RequestMapping("/api")
public class RestDataController {

	@Autowired
	private RestDataService service;
	
	@RequestMapping("/products")
	public List<Product> getAllProductData() {
		return service.getAllProducts();
	}
	
	@RequestMapping(value = "/post/order")
	public String postOrder(
			@RequestParam(value = "customerData", required = true) String customerData,
			@RequestParam(value = "productId", required = true) long productId) throws IOException {
		// Mapping received JSON to Customer class with Mapper in Utility class
		Customer cust = (Customer) Mapper.mapFromJsonToClass(Customer.class, customerData);
		return this.service.postOrder(cust, productId);
	}

}
