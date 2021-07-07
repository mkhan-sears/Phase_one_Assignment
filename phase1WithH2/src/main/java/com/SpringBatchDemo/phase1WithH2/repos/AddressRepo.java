package com.SpringBatchDemo.phase1WithH2.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBatchDemo.phase1WithH2.model.Address;

public interface AddressRepo extends JpaRepository<Address, String> {

}
