package com.cg.farmersystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.farmersystem.model.SupplierQuote;

@Repository
public interface SupplierQuoteJpaRepository extends JpaRepository<SupplierQuote, Integer> {

	//List<SupplierQuote> findByName();

	//List<SupplierQuote> findByName( String productName);
}
