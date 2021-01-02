package com.cg.farmersystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
	private Integer productId;
	@Column(length = 50)
	private String productName;
	@Column(length = 150)
	private String productDescription;

	@Override
	public String toString() {
		return "Products [productId=" + productId + ", proName=" + productName + "]";
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductdescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Product() {
		super();
	}

	public Product(Integer productId, String productName, String productDescription) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;

	}
}



