package com.SpringBatchDemo.phase1WithH2.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.SpringBatchDemo.phase1WithH2.model.Address;

public class AddressRestClient {
private static final String GET_ALL_ADDRESS_API="http://localhost:8080/addresses";
	
	private static final String GET_ADDRESS_BY_ID_API="http://localhost:8080/addresses/{id}";
	
	private static final String CREATE_ADDRESS_BY_API="http://localhost:8080/addresses";
	
	private static final String UPDATE_ADDRESS_BY_API="http://localhost:8080/addresses/{id}";
	
	private static final String DELETE_ADDRESS_API="http://localhost:8080/addresses/{id}";

	static RestTemplate restTemplate = new RestTemplate();
	
	private  void callGetAllAddressAPI(){
//		try {
//			wait(100);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		HttpHeaders headers = new HttpHeaders();
//		
//		headers.setAccept( Arrays.asList(MediaType.APPLICATION_JSON));
//		
//		HttpEntity<String> entity = new HttpEntity<>("parameters",headers);
//		
//	ResponseEntity<String> result = restTemplate.exchange(GET_ALL_ADDRESS_API, HttpMethod.GET, entity, String.class);
//	
//	System.out.println(result);
	
	
	}
	
	
	public static void callCreateAddressAPI(List<? extends Address> items){
	
		for(Address i :items){
		
			ResponseEntity<Address> address2= restTemplate.postForEntity(CREATE_ADDRESS_BY_API, i,Address.class);
		
			System.out.println(address2.getBody());
		}
		
		
		
	}
	
	
}
