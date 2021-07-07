package com.SpringBatchDemo.phase1WithH2.process;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.SpringBatchDemo.phase1WithH2.model.Person;
import com.SpringBatchDemo.phase1WithH2.repos.personRepository;

@Component
public class DBWriter implements ItemWriter<Person>{

	@Autowired
	 private personRepository PR;
//	  
//	    public DBWriter (personRepository PR) {
//	        this.PR=PR;
//	  }
	@Override
	public void write(List<? extends Person> p) throws Exception {
		System.out.println("Data Saved for Users: " + p);
        PR.saveAll(p);
		
	}

	
}
