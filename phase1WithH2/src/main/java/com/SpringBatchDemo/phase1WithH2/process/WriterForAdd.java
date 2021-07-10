package com.SpringBatchDemo.phase1WithH2.process;

import java.util.List;



import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.SpringBatchDemo.phase1WithH2.model.Address;
import com.SpringBatchDemo.phase1WithH2.repos.AddressRepo;

@Component
public class WriterForAdd implements ItemWriter<Address>{

	@Autowired
	private AddressRepo AR;
	
	
	@Override
	public void write(List<? extends Address> add) throws Exception {
		System.out.println("Data Saved for Users: " + add);
        AR.saveAll(add);
		
	}
}
