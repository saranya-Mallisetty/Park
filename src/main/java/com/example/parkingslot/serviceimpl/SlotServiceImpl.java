package com.example.parkingslot.serviceimpl;

import java.time.LocalDate;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parkingslot.dao.EmployeeDao;
import com.example.parkingslot.dao.SlotDao;
import com.example.parkingslot.dto.SlotRequestDto;
import com.example.parkingslot.exceptions.InvalidCredentialsException;
import com.example.parkingslot.model.SlotDetails;
import com.example.parkingslot.model.SlotUpdation;
import com.example.parkingslot.service.SlotService;
@Service
public class SlotServiceImpl implements SlotService {
	
	private static Log logger = LogFactory.getLog(SlotServiceImpl.class);
	@Autowired
	SlotDao slotDao;
	@Autowired
	EmployeeDao employeeDao;


	@Override
	public void slotUpdation(SlotRequestDto slotRequestDto)   {
		logger.info("implementation of slotUpdation");
		SlotUpdation slotUpdation = new SlotUpdation();
		LocalDate date = LocalDate.parse(slotRequestDto.getFromDate());
		slotUpdation.setFromDate(date);
		LocalDate date1 = LocalDate.parse(slotRequestDto.getToDate());
		slotUpdation.setToDate(date1);
		slotUpdation.setEmployeeId(slotRequestDto.getEmployeeId());
		slotUpdation.setSlotNumber(slotRequestDto.getSlotNumber());
		Optional<SlotDetails> slotUpdation1 =employeeDao.findByEmployeeId(slotRequestDto.getEmployeeId());
		if(slotUpdation1.isPresent())
		{
			slotDao.save(slotUpdation);

			
		}
		else
		{
			throw new InvalidCredentialsException("empId is not present");
		}
		

        		
		
		

		
		
	}

}
