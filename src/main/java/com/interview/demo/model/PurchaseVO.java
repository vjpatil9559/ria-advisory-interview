package com.interview.demo.model;

import java.util.Date;

import com.interview.demo.entity.Purchase;

public class PurchaseVO {

	private String custName;

	private String custAddr;

	private String prodName;

	private Date prodMfgDate;

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustAddr() {
		return custAddr;
	}

	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
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

	public static PurchaseVO toPurchaseVO(Purchase purchase) {
		PurchaseVO purchaseVO = new PurchaseVO();
		purchaseVO.custName = purchase.getCustomer().getCustomerName();
		purchaseVO.custAddr = purchase.getCustomer().getCustomerAddr();
		purchaseVO.prodName = purchase.getProduct().getProdName();
		purchaseVO.prodMfgDate = purchase.getProduct().getProdMfgDate();
		return purchaseVO;
	}

}
