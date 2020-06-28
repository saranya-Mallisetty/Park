package com.example.parkingslot.controllertest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.parkingslot.controller.SlotController;
import com.example.parkingslot.dto.SlotRequestDto;
import com.example.parkingslot.service.SlotService;
import com.fasterxml.jackson.databind.ObjectMapper;



@ExtendWith(MockitoExtension.class)

public class SlotUpdationControllerTest {
	ObjectMapper objectMapper;
	@Mock
	SlotService slotService;
	

	@InjectMocks
	SlotController slotController;

	MockMvc mockMvc;
	SlotRequestDto slotRequestDto;
	
	@BeforeEach
	public void setUp()
	{
		objectMapper=new ObjectMapper();
		mockMvc=MockMvcBuilders.standaloneSetup(slotController).build();
		slotRequestDto  = new SlotRequestDto();
		slotRequestDto.setEmployeeId(1);
		slotRequestDto.setSlotNumber(101);
		slotRequestDto.setFromDate("2020-06-27");
		slotRequestDto.setToDate("2020-06-28");
	}
		
		@Test
		public void slotUpdationDetails() throws Exception {
			mockMvc.perform(post("/employee/slotupdation").contentType(MediaType.APPLICATION_JSON_VALUE)
					.content(objectMapper.writeValueAsString(slotRequestDto)))
			        .andExpect(status().isOk())
			        .andExpect(jsonPath("$", Matchers.is("Slot release request got successfull")));
			        
		}
		



}
