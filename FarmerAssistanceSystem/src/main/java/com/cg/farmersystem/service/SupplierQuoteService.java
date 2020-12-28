package com.cg.farmersystem.service;

import java.util.List;
import java.util.Optional;

import com.cg.farmersystem.model.SupplierQuote;

public interface SupplierQuoteService {
	List<SupplierQuote> getAllQuote();

	public List<SupplierQuote> saveQuote(SupplierQuote quote);

	public void deleteQuote(SupplierQuote quote);

	public Optional<SupplierQuote> getQuoteById(Integer quoteId);

	public SupplierQuote updateQuote(SupplierQuote quote);

	List<SupplierQuote> getProduct(String productName );
}
























//public SupplierQuoteEntity addSupplierQuote(SupplierQuoteEntity sq) ;