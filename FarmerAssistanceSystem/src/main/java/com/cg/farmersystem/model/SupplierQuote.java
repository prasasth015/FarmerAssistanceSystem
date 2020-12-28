package com.cg.farmersystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "quote")
public class SupplierQuote {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int quoteId;

	private String quotedProduct;
	private int quantity;
	private int quote_Price;

	@ManyToOne
	//@JoinColumn(name = "productName")
	private Product product;

	public SupplierQuote() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SupplierQuote(int quoteId, String quotedProduct, int quote_Price, int quantity) {
		super();
		this.quoteId = quoteId;

		this.quotedProduct = quotedProduct;
		this.quote_Price = quote_Price;
		this.quantity = quantity;
	}

	// getters and setters for private variables
	public int getQuoteId() {
		return quoteId;
	}

	public void setQuoteId(int quoteId) {
		this.quoteId = quoteId;
	}

	public String getQuotedProduct() {
		return quotedProduct;
	}

	public void setQuotedProduct(String quotedProduct) {
		this.quotedProduct = quotedProduct;
	}
	

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuote_Price() {
		return quote_Price;
	}

	public void setQuote_Price(int quote_Price) {
		this.quote_Price = quote_Price;
	}


}
