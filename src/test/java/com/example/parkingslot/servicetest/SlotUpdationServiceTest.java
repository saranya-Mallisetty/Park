package com.example.parkingslot.servicetest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.parkingslot.dao.EmployeeDao;
import com.example.parkingslot.dao.SlotDao;
import com.example.parkingslot.dto.SlotRequestDto;
import com.example.parkingslot.exceptions.InvalidCredentialsException;
import com.example.parkingslot.model.SlotDetails;
import com.example.parkingslot.model.SlotUpdation;
import com.example.parkingslot.serviceimpl.SlotServiceImpl;


@ExtendWith(MockitoExtension.class)

public class SlotUpdationServiceTest {
SlotUpdation slotUpdation;
	
	@Mock
	SlotDao slotDao;
	@Mock
	EmployeeDao employeeDao;
	
	@InjectMocks
	SlotServiceImpl slotServiceImpl;
	
	SlotRequestDto slotRequestDto;
	
	@BeforeEach
	public void setUp()
	{
		
		slotRequestDto=new SlotRequestDto();
		slotRequestDto.setEmployeeId(1);
		slotRequestDto.setSlotNumber(101);
		slotRequestDto.setFromDate("2020-06-27");
		slotRequestDto.setToDate("2020-06-28");
		
	
		
	}

	/*
	 * @Test public void slotUpdationDetails() {
	 * 
	 * //given when(slotDao.save(any(SlotUpdation.class))).thenReturn(any(
	 * InvalidCredentialsException.class));
	 * 
	 * //when slotServiceImpl.slotUpdation(slotRequestDto);
	 * 
	 * //then verify(slotDao).save(any(SlotUpdation.class));
	 * 
	 * 
	 * }
	 */
	@Test
	public void slotUpdationDetails1()  
	{
		SlotDetails slot=new SlotDetails();
		slot.setEmployeeId(1);
		
		
		when(employeeDao.findByEmployeeId(1)).thenReturn(Optional.of(slot));
		
		slotServiceImpl.slotUpdation(slotRequestDto);
		
		verify(employeeDao).findByEmployeeId(1);
	}


}
