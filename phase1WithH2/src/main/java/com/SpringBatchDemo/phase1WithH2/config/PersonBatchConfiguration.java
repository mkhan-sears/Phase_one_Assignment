package com.SpringBatchDemo.phase1WithH2.config;



import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.FixedLengthTokenizer;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.SpringBatchDemo.phase1WithH2.model.Address;
import com.SpringBatchDemo.phase1WithH2.model.Person;


@Configuration
@EnableBatchProcessing
public class PersonBatchConfiguration {

	 
	 @Bean
	 public Job job(JobBuilderFactory jobBuilderFactory,
			 StepBuilderFactory stepBuilderFactory,
				ItemReader<Person> itemReader,
				ItemProcessor<Person, Person> itemProcessor,
				ItemWriter<Person> itemWriter,
				ItemReader< Address> itemReader2,
				ItemProcessor< Address, Address> itemProcessor2,
				ItemWriter<Address> itemWriter2
				){
		 
		 Step step1=stepBuilderFactory.get("Contacts-File-Load")
			 	.<Person,Person>chunk(100)
			    .reader(itemReader)
			    .processor(itemProcessor)
			    .writer(itemWriter)
			    .build();
		
		 Step step2=stepBuilderFactory.get("Address-File-Load")
				 .<Address,Address>chunk(100)
				 .reader(itemReader2)
				 .processor(itemProcessor2)
				 .writer(itemWriter2)
				 .build();

		return jobBuilderFactory.get("File")
						.incrementer(new RunIdIncrementer())
						.start(step1)
					.next(step2)
						.build();
			 
		 }

	
	    @Bean
		public FlatFileItemReader<Person> itemReader(@Value("${input}")Resource resource){
		
			FlatFileItemReader<Person> flatfileItemReader = new FlatFileItemReader<>();
			flatfileItemReader.setResource(resource);
			flatfileItemReader.setName("CSV-Reader");
			flatfileItemReader.setLinesToSkip(1);
			flatfileItemReader.setLineMapper(lineMapper());
			return flatfileItemReader;
			
		}
	 
	 @Bean
	public LineMapper<Person> lineMapper(){
			DefaultLineMapper<Person> defaultLineMapper = new DefaultLineMapper<>();
			DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
			
			lineTokenizer.setDelimiter(",");
			lineTokenizer.setStrict(false);
			
			lineTokenizer.setNames(new String[] {"id","Last_name", "First_name", "phone","email", "title", "designation"});
			
			BeanWrapperFieldSetMapper<Person> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
			fieldSetMapper.setTargetType(Person.class);
			
			defaultLineMapper.setLineTokenizer(lineTokenizer);
			defaultLineMapper.setFieldSetMapper(fieldSetMapper);
			
			return defaultLineMapper;
	 

	
}
	 
	
	 
	    @Bean
		public FlatFileItemReader<Address> itemReader2(@Value("${input2}")Resource resource){
		
			FlatFileItemReader<Address> flatfileItemReader = new FlatFileItemReader<>();
			flatfileItemReader.setResource(resource);
			flatfileItemReader.setName("Address-Reader");
			flatfileItemReader.setLineMapper(fixedLength());
			return flatfileItemReader;
}
	 
	 
	 @Bean
	 public LineMapper<Address> fixedLength(){
		 DefaultLineMapper<Address> defaultLineMapper = new DefaultLineMapper<>();
		 FixedLengthTokenizer fixedLengthTokenizer = new FixedLengthTokenizer();
		
		 fixedLengthTokenizer.setStrict(false);
		 
		 fixedLengthTokenizer.setNames("customerPhone","addressType","addressLine1","addressLine2","city","stateCode","zipcode","zipplus4","addressType2","addressLine12","addressLine22","city2","stateCode2","zipcode2","zipplus42");
		 fixedLengthTokenizer.setColumns(new Range(1,10),new Range(11,11),new Range(12,41),new Range(42,71),new Range(72,86),new Range(87,88),new Range(89,93),new Range(94,97),new Range(98,98),new Range(99,128),new Range(129,158),new Range(159,173),new Range(174,175),new Range(176,180),new Range(181,184));
		 
		 BeanWrapperFieldSetMapper<Address> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
			fieldSetMapper.setTargetType(Address.class);
		 
		 defaultLineMapper.setLineTokenizer(fixedLengthTokenizer);
		 defaultLineMapper.setFieldSetMapper(fieldSetMapper);
		return defaultLineMapper;
		 
	 }
	 
}
