package com.interview.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prod_id")
	private Long productId;

	@Column(name = "prod_name")
	private String prodName;

	@Column(name = "prod_mfg_date")
	private Date prodMfgDate;

	public Product() {
		super();
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public Date getProdMfgDate() {
		return prodMfgDate;
	}

	public void setProdMfgDate(Date prodMfgDate) {
		this.prodMfgDate = prodMfgDate;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", prodName=" + prodName + ", prodMfgDate=" + prodMfgDate + "]";
	}

}
