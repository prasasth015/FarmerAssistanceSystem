package com.cg.farmersystem.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.farmersystem.model.Supplier;
import com.cg.farmersystem.repository.SupplierJpaRepository;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {
	@Autowired
	private SupplierJpaRepository supplierJpaRepository;

	@Override
	public List<Supplier> getAllSupplier() {

		return supplierJpaRepository.findAll();
	}

	public Supplier createSupplier(Supplier supplier) {
		
		return supplierJpaRepository.save(supplier);
	}

	@Override
	public Optional<Supplier> getSupplierById(String supplierUserName) {
	
		return supplierJpaRepository.findById(supplierUserName);
	}

	@Override
	public Supplier findBySupplierUserNameAndPassword(String supplierUserName, String password) {
		
		return supplierJpaRepository.findBySupplierUserNameAndPassword(supplierUserName, password);
	}


}
