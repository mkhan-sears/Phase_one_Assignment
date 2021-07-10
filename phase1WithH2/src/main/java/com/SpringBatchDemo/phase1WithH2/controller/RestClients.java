package com.SpringBatchDemo.phase1WithH2.controller;

import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.SpringBatchDemo.phase1WithH2.model.Person;



public class RestClients {
private static final String GET_ALL_PERSON_API="http://localhost:8080/person1";
	
	private static final String GET_PERSON_BY_ID_API="http://localhost:8080/person1/{id}";
	
	private static final String CREATE_PERSON_BY_API="http://localhost:8080/person1";


	static RestTemplate restTemplate = new RestTemplate();
	
	private  void callGetAllPersonAPI(){
	}
	
	
	public static void callCreatePersonAPI(List<? extends Person> p1){
	
		for(Person i :p1){
		
			ResponseEntity<Person> p2= restTemplate.postForEntity(CREATE_PERSON_BY_API, i,Person.class);
		
			System.out.println(p2.getBody());
		}
		
		
		
	}
	
	
}
