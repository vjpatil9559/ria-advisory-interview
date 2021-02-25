package com.interview.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "purchase")
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "purch_id")
	private Long purchId;

	@OneToOne
	@JoinColumn(name = "prod_id")
	private Product product;

	@OneToOne()
	@JoinColumn(name = "cust_id")
	private Customer customer;

	@Column(name = "purch_date")
	private Date purchDate;

	public Purchase() {
		super();
	}

	public Long getPurchId() {
		return purchId;
	}

	public void setPurchId(Long purchId) {
		this.purchId = purchId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getPurchDate() {
		return purchDate;
	}

	public void setPurchDate(Date purchDate) {
		this.purchDate = purchDate;
	}

	@Override
	public String toString() {
		return "Purchase [purchId=" + purchId + ", product=" + product + ", customer=" + customer + ", purchDate="
				+ purchDate + "]";
	}

}
