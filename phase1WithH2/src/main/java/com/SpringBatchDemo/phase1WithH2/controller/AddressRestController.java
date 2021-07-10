package com.SpringBatchDemo.phase1WithH2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBatchDemo.phase1WithH2.model.Address;
import com.SpringBatchDemo.phase1WithH2.repos.AddressRepo;



@RestController
@RequestMapping("/addresses")
public class AddressRestController {

	@Autowired
	AddressRepo adresRepo;
	
	
	@GetMapping
	public List<Address> getAllAddress(){
	 
		return adresRepo.findAll();
		
	}
	
	
	@PostMapping
	public Address createAddress(@RequestBody Address address){
		return this.adresRepo.save(address);
	}
	
}
