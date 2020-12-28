
package com.cg.farmersystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.farmersystem.exception.QuoteNotFoundException;
import com.cg.farmersystem.model.Product;
import com.cg.farmersystem.model.SupplierQuote;
import com.cg.farmersystem.service.SupplierQuoteService;

@RestController

@RequestMapping(path = "/api/v1")
public class SupplierQuoteController {

	@Autowired
	private SupplierQuoteService supplierQuoteService;

	@GetMapping("/getallproduct/{productName}")
	public List<SupplierQuote> getProduct( String productName)
	{
		return supplierQuoteService.getProduct(productName);
	}
	
	// Method to fetch the supplier quote from the database
	@GetMapping("/getquote")
	public List<SupplierQuote> getAllQuote() {
		return supplierQuoteService.getAllQuote();
	}

	// Method to create a supplier quote
	@PostMapping("/addquote")
	public ResponseEntity<List<SupplierQuote>> insertQuote(@RequestBody SupplierQuote quote) {
		List<SupplierQuote> sq = supplierQuoteService.saveQuote(quote);

		return new ResponseEntity<List<SupplierQuote>>(sq, HttpStatus.OK);
	}

	// Method to fetch the quote using quoteId
	@GetMapping("getbyid/{quoteId}")
	public ResponseEntity<SupplierQuote> getQuoteById(@PathVariable(value = "quoteId") int quoteId)
			throws QuoteNotFoundException {
		SupplierQuote quote = supplierQuoteService.getQuoteById(quoteId)
				.orElseThrow(() -> new QuoteNotFoundException("No Quote found with this Id :" + quoteId));
		return ResponseEntity.ok().body(quote);
	}

	// Method to update the price if quoteId matches with the database
	@PutMapping("/updateprice/{quoteId}")
	public ResponseEntity<SupplierQuote> updatePrice(@PathVariable(value = "quoteId") int quoteId,
			@RequestBody SupplierQuote quote) throws QuoteNotFoundException {
		SupplierQuote sq = supplierQuoteService.getQuoteById(quoteId)
				.orElseThrow(() -> new QuoteNotFoundException("No Quote found with this Id :" + quoteId));
		sq.setQuote_Price(quote.getQuote_Price());
		SupplierQuote updatedPrice = supplierQuoteService.updateQuote(sq);
		System.out.println("price updated");
		return ResponseEntity.ok(updatedPrice);
	}

	// Method to delete quote using quoteId
	@DeleteMapping("/deletequote/{quoteId}")
	public String deleteQuote(@PathVariable(value = "quoteId") int quoteId) throws QuoteNotFoundException {
		SupplierQuote quote = supplierQuoteService.getQuoteById(quoteId)
				.orElseThrow(() -> new QuoteNotFoundException("No quote found with this Id :" + quoteId));
		supplierQuoteService.deleteQuote(quote);
		return "Quote Deleted";
	}
}
