package com.SpringBatchDemo.phase1WithH2.process;

import java.io.File;
import java.io.FileWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.SpringBatchDemo.phase1WithH2.model.Address;



@Component
public class ProcessorForADD implements ItemProcessor<Address, Address>{
	private static final Logger log =  LoggerFactory.getLogger(ProcessorForADD.class);

	int count=0;
	@Override
	public Address process(Address add) throws Exception {
		count++;
        if(check(add))
        {
            return add;
        }
        else
        {
        return null;
    }}

 

    private boolean check(Address add) {
        String s = "S";
        if(  ((add.getAddressType().contains(s)) && (!add.getAddressType2().contains(s))) ||
                ((add.getAddressType2().contains(s)) && (!add.getAddressType().contains(s)))
                ){
            return true;
        }

 

        else{
        	if(  ((add.getAddressType().contains(s)) && (add.getAddressType2().contains(s))) ){
        		String msg ="Address should not be same type"+add.getAddressType() + " ,"+add.getAddressType2();
                write(msg);
                log.error("Address is same");
        	}
            return false;
        }
    }
	private void write(String msg) {
		try{
	        File file = new File("Error.csv");
	        if(!file.exists())
	        {file.createNewFile();
	        }
	        
	        FileWriter writer = new FileWriter(file,true);
	        
	        writer.append("Addresses.dat"+"," +count+ ", "+msg);
	        writer.append('\n');
	        writer.flush();
	         
	        writer.close();
	        }
	        catch(Exception e){
	            System.out.println(e.toString());
	        }
}
}
