package com.SpringBatchDemo.phase1WithH2.process;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.SpringBatchDemo.phase1WithH2.model.Person;

@Component
public class DBprocessor implements ItemProcessor<Person, Person>{
 
    int count=0;
     private static final Logger LOGGER = LoggerFactory.getLogger(DBprocessor.class);
    @Override
    public Person process(Person p) throws Exception {
        count+=1;
        if(check(p)){
        return p;
    }
        return null;
    }

 

    private boolean check(Person p) {
        if((p.getPhone().length()==10) && checkFirstName(p) && checkLastName(p) && checkEmail(p) && checkPhone(p))
        {
        return true;
        }
        else{
            
            if(!(p.getPhone().length()==10)){
                String s ="Phone number must be 10 digits "+ p.getPhone();
                writ(s);
                LOGGER.error("Phone number must be 10 digits");
            }
        return false;
    }
    

 

}

 

    private  boolean checkLastName(Person p) {
        if(!p.getLast_name().isEmpty()){
            return true;
        }
        else{
            String s="Last Name is Empty";
            writ(s);
            LOGGER.error("Last Name is Empty");
            return false;
            
        }
    }
    private boolean checkPhone(Person p) {        try{
            Long  l = Long.parseLong(p.getPhone());    
        }
        catch(NumberFormatException nfe){
            String s="Number must be Integer";
            writ(s);
            LOGGER.error("Number must be Integer");
            return false;
        }
        return true;
        
    }
    private boolean checkEmail(Person p) {
        if(!p.getEmail().isEmpty()){
        return true;
    }
    else{
        LOGGER.error("Last Email is Empty");
        String s="Last Email is Empty";
        writ(s);
        return false;
    }
}
    private boolean checkFirstName(Person p) {
        if(!p.getFirst_name().isEmpty()){
            return true;
        }
        else{
            LOGGER.error("Last First Name is Empty");
            String s="Last First Name is Empty";
            writ(s);
            return false;
        }
    }
    
    private void writ(String s) {
        try{
        File file = new File("Error.csv");
        if(!file.exists())
        {file.createNewFile();
        }
        
        FileWriter fw = new FileWriter(file,true);
        
        fw.append("Contacts.csv"+","+count+","+s);
        fw.append('\n');
        fw.flush();
         
        fw.close();
        }
        catch(Exception e){
            System.out.println(e.toString());
        }

 

        
    }
}



