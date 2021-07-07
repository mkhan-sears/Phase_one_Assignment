package com.SpringBatchDemo.phase1WithH2.process;

import java.util.Arrays;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.SpringBatchDemo.phase1WithH2.model.Person;

public class RestpersonReader implements ItemReader<Person> {

	  private final String apiUrl;
	    private final RestTemplate restTemplate;
	 
	    private int nextStudentIndex;
	    private List<Person> studentData;
	 
	    RestpersonReader(String apiUrl, RestTemplate restTemplate) {
	        this.apiUrl = apiUrl;
	        this.restTemplate = restTemplate;
	        nextStudentIndex = 0;
	    }
	 
	    @Override
	    public Person read() throws Exception {
	        if (studentDataIsNotInitialized()) {
	            studentData = fetchStudentDataFromAPI();
	        }
	 
	        Person nextStudent = null;
	 
	        if (nextStudentIndex < studentData.size()) {
	            nextStudent = studentData.get(nextStudentIndex);
	            nextStudentIndex++;
	        }
	        else {
	            nextStudentIndex = 0;
	            studentData = null;
	        }
	 
	        return nextStudent;
	    }
	 
	    private boolean studentDataIsNotInitialized() {
	        return this.studentData == null;
	    }
	 
	    private List<Person> fetchStudentDataFromAPI() {
	        ResponseEntity<Person[]> response = restTemplate.getForEntity(apiUrl,
	                Person[].class
	        );
	        Person[] studentData = response.getBody();
	        return Arrays.asList(studentData);
	    }

}
