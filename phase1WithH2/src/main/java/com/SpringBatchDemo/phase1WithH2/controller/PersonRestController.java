package com.SpringBatchDemo.phase1WithH2.controller;

import java.util.List;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBatchDemo.phase1WithH2.model.Person;
import com.SpringBatchDemo.phase1WithH2.repos.AddressRepo;
import com.SpringBatchDemo.phase1WithH2.repos.personRepository;
@RestController
@RequestMapping("/person1")
public class PersonRestController {

	@Autowired
	personRepository pr;
	
	@GetMapping
	public List<Person> getAllPerson(){
	 
		return pr.findAll();
	}
	
	@PostMapping
	public Person createPerson(@RequestBody Person p){
		return this.pr.save(p);
	}
	
}
