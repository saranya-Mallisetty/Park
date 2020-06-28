package com.example.parkingslot.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.parkingslot.dto.SlotRequestDto;
import com.example.parkingslot.exceptions.InvalidCredentialsException;
import com.example.parkingslot.service.SlotService;



@RestController
public class SlotController {
	private static Log logger = LogFactory.getLog(SlotController.class);

	@Autowired
	
	SlotService slotService;

	/**
	 * This method is used to register the user
	 * @param slotRequestDto
	 * @return String
	 * @throws InvalidCredentialsException 
	 */
	@PostMapping("/employee/slotupdation")
	public  String slotUpdationDetails(@RequestBody SlotRequestDto slotRequestDto)   {
		logger.info("executing the slotUpdationDetails  Method");
	slotService.slotUpdation(slotRequestDto);
		return "Slot release request got successfull";
	}

	

}
