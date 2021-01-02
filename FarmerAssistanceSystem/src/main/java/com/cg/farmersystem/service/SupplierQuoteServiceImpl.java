package com.cg.farmersystem.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.farmersystem.model.SupplierQuote;
import com.cg.farmersystem.repository.SupplierQuoteJpaRepository;

@Service
@Transactional
public class SupplierQuoteServiceImpl implements SupplierQuoteService {

	private static final Logger logger = LogManager.getLogger(SupplierQuoteServiceImpl.class);

	@Autowired
	private SupplierQuoteJpaRepository supplierQuoteJpaRepository;

	@Override
	public List<SupplierQuote> getAllQuote() {
		logger.info("in supplier quote service getAllQuote");
		return supplierQuoteJpaRepository.findAll();
	}

	@Override
	public SupplierQuote saveQuote(SupplierQuote supplierquote) {
		logger.info("in supplier quote service saveQuote");
		return supplierQuoteJpaRepository.save(supplierquote);
	}

	@Override
	public SupplierQuote deleteQuote(SupplierQuote quote) {
		logger.info("in supplier quote service deleteQuote");
		supplierQuoteJpaRepository.delete(quote);

		return quote;
	}

	@Override
	public Optional<SupplierQuote> getQuoteById(Integer quoteId) {
		logger.info("in supplier Quote service getQuoteById");
		return supplierQuoteJpaRepository.findById(quoteId);
	}

	@Override
	public SupplierQuote updateQuote(SupplierQuote quote) {
		logger.info("in supplier quote service updateQuote");
		return supplierQuoteJpaRepository.save(quote);
	}

}
