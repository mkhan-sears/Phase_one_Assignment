package com.SpringBatchDemo.phase1WithH2.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBatchDemo.phase1WithH2.model.Person;

public interface personRepository extends JpaRepository<Person, String> {

}
