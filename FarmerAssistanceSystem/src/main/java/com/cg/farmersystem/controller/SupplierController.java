package com.cg.farmersystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.farmersystem.exception.SupplierExistException;
import com.cg.farmersystem.exception.SupplierNotFoundException;
import com.cg.farmersystem.model.Supplier;
import com.cg.farmersystem.service.SupplierService;

//import net.guides.springboot2.springboot2jpacrudexample.model.Employee;

@RestController
@RequestMapping(path="/api/v1")
public class SupplierController {

	@Autowired
	private SupplierService supplierService;

	@PostMapping("/createSupplier")
	public Supplier createupplier(@RequestBody Supplier supplier) throws SupplierExistException {
		boolean ifExist = supplierService.getSupplierById(supplier.getSupplierUserName()).isPresent();
		if (ifExist) {
			throw new SupplierExistException("Supplier Already present with this :" + supplier.getSupplierUserName());
		}

		return supplierService.createSupplier(supplier);
	}

	// method to fetch supplier details using supplier username
	@GetMapping("/{supplierUserName}")
	public ResponseEntity<Supplier> getSupplierById(@PathVariable(value = "supplierUserName") String supplierUserName)
			throws SupplierNotFoundException {
		Supplier supplier = supplierService.getSupplierById(supplierUserName).orElseThrow(
				() -> new SupplierNotFoundException("No Supplier found with this Id :" + supplierUserName));
		return ResponseEntity.ok().body(supplier);
	}

	// Method to fetch the list of suppliers
	@GetMapping("/supplier")
	public List<Supplier> getAllSupplier() {
		return supplierService.getAllSupplier();
	}

	// method for login
	@GetMapping("/login/{supplierUserName}/{password}")
	public ResponseEntity<Supplier> Login(@PathVariable(value = "supplierUserName") String supplierUserName,
			@PathVariable(value = "password") String password) throws SupplierExistException {
		Supplier supplier = supplierService.findBySupplierUserNameAndPassword(supplierUserName, password);

		if (supplier == null) {
			throw new SupplierExistException(
					"No Supplier found with this UserName: " + supplierUserName + " and Password: " + password);
		}

		return ResponseEntity.ok().body(supplier);
	}
}
































//@PostMapping("/addsupplier")
//public Supplier addSupplier(@RequestBody Supplier supplier) {
//	return supplierService.addSupplier(supplier);
//}
/*
 * @GetMapping("/supplier/{supplierUserName}") public
 * ResponseEntity<SupplierEntity> getSupplierByName String supplierUserName)
 * throws ResourceNotFoundException { //java8 // if employee==null throw new
 * ResourceNotFoundException("Employee not found for this id :: " +
 * employeeId)); SupplierEntity se = supplierRepo.findById(supplierUserName)
 * .orElseThrow(() -> new
 * ResourceNotFoundException("Employee not found for this id :: " +
 * supplierUserName)); return ResponseEntity.ok().body(se); }
 */
