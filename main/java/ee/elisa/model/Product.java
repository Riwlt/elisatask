package ee.elisa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "product_entity")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product implements Serializable{

	private static final long serialVersionUID = -6111678506699745838L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name")
	private String productName;

	// Join with Price table's id
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "price_id")
	private Price price;

	@Column(name = "description")
	private String description;

	public Product(long id, String productName, String description) {
		super();
		this.id = id;
		this.productName = productName;
		this.description = description;
	}

	public Product() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}
	
}
