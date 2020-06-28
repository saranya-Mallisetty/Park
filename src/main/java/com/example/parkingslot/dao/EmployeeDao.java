package com.example.parkingslot.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.parkingslot.model.SlotDetails;
@Repository
public interface EmployeeDao extends CrudRepository<SlotDetails, Integer>{


	Optional<SlotDetails> findByEmployeeId(int employeeId);

	
	
	

}
