package com.cg.farmersystem.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
	private int productId;
	@Column(length = 50)
	private String productName;
	@Column(length = 150)
	private String productDescription;

	@Override
	public String toString() {
		return "Products [productId=" + productId + ", proName=" + productName + "]";
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProName() {
		return productName;
	}

	public void setProductName(String proName) {
		this.productName = proName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductdescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int productId, String productName, String productDescription) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;

	}

	public static List<Product> viewProducts() {
		// TODO Auto-generated method stub
		return null;
	}

}































//@Override
//public String toString() {
//	return "adminEntity [serviceId=" + productname+"]";
//
//}
