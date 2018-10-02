package com.prs.business.purchaserequest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PurchaseRequestLineItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int purchaseRequestId;
	private int productId;
	private int quantity;

public PurchaseRequestLineItem(int id, int purchaseRequestId, 
		int productId, int quantity) {
	this.id = id;
	this.purchaseRequestId = purchaseRequestId;
	this.productId = productId;
	this.quantity = quantity;
	}

public PurchaseRequestLineItem() {
	super();
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getPurchaseRequestId() {
	return purchaseRequestId;
}

public void setPurchaseRequestId(int purchaseRequestId) {
	this.purchaseRequestId = purchaseRequestId;
}

public int getProductId() {
	return productId;
}

public void setProductId(int productId) {
	this.productId = productId;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

@Override
public String toString() {
	return "PurchaseRequestLineItem [id=" + id + ", purchaseRequestId=" + purchaseRequestId + ", productId=" + productId
			+ ", quantity=" + quantity + "]";
}
	

	}

