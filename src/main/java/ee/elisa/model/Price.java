package ee.elisa.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "product_price")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Price implements Serializable{

	private static final long serialVersionUID = -7102249608210221715L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "sap_id")
	private String sapId;

	@Column(name = "recurring_price")
	private Double recurringPrice;

	@Column(name = "one_time_price")
	private Double oneTimePrice;

	@Column(name = "time_left")
	private Date timeLeft;

	@Column(name = "product_description")
	private String description;

	@Column(name = "recurring_count")
	private Integer recurringCount;

	public Price(long id, String sapId, Double recurringPrice, Double oneTimePrice, Date timeLeft, String description,
			Integer recurringCount) {
		super();
		this.id = id;
		this.sapId = sapId;
		this.recurringPrice = recurringPrice;
		this.oneTimePrice = oneTimePrice;
		this.timeLeft = timeLeft;
		this.description = description;
		this.recurringCount = recurringCount;
	}

	public Price() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSapId() {
		return sapId;
	}

	public void setSapId(String sapId) {
		this.sapId = sapId;
	}

	public Double getRecurringPrice() {
		return recurringPrice;
	}

	public void setRecurringPrice(Double recurringPrice) {
		this.recurringPrice = recurringPrice;
	}

	public Double getOneTimePrice() {
		return oneTimePrice;
	}

	public void setOneTimePrice(Double oneTimePrice) {
		this.oneTimePrice = oneTimePrice;
	}

	public Date getTimeLeft() {
		return timeLeft;
	}

	public void setTimeLeft(Date timeLeft) {
		this.timeLeft = timeLeft;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getRecurringCount() {
		return recurringCount;
	}

	public void setRecurringCount(Integer recurringCount) {
		this.recurringCount = recurringCount;
	}
}
