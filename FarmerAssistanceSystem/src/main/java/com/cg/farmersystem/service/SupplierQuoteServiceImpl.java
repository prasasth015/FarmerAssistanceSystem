package com.cg.farmersystem.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.farmersystem.model.Product;
import com.cg.farmersystem.model.SupplierQuote;
import com.cg.farmersystem.repository.SupplierQuoteJpaRepository;

@Service
@Transactional
public class SupplierQuoteServiceImpl implements SupplierQuoteService {
	@Autowired
	private SupplierQuoteJpaRepository supplierQuoteJpaRepository;

	@Override
	public List<SupplierQuote> getAllQuote() {
	
		return supplierQuoteJpaRepository.findAll();
	}

	@Override
	public List<SupplierQuote> saveQuote(SupplierQuote quote) {
		supplierQuoteJpaRepository.save(quote);

		return supplierQuoteJpaRepository.findAll();
	}

	@Override
	public void deleteQuote(SupplierQuote quote) {
		supplierQuoteJpaRepository.delete(quote);

	}

	@Override
	public Optional<SupplierQuote> getQuoteById(Integer quoteId) {

		return supplierQuoteJpaRepository.findById(quoteId);
	}

	@Override
	public SupplierQuote updateQuote(SupplierQuote quote) {
		
		return supplierQuoteJpaRepository.save(quote);
	}

	@Override
	public List<SupplierQuote> getProduct(String productName) {
		// TODO Auto-generated method stub
		return supplierQuoteJpaRepository.findAll();
	}
}


