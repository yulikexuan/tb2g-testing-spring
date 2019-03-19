//: org.springframework.samples.petclinic.web.VetControllerTest.java


package org.springframework.samples.petclinic.web;


import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@ExtendWith(MockitoExtension.class)
class VetControllerTest {

	@Mock
	private ClinicService service;
	
	@Mock
	private Map<String, Object> model;
	
	@InjectMocks
	private VetController controller;

	private Vet vet1;
	private Vet vet2;
	
	private List<Vet> vetList;
	
	private MockMvc mockMvc;
	
	@BeforeEach
	void setUp() {
		this.vet1 = new Vet();
		this.vet2 = new Vet();
		this.vetList = List.of(this.vet1, this.vet2);
		given(this.service.findVets()).willReturn(this.vetList);
		
		/*
		 * Build a MockMvc instance by registering one or more @Controller 
		 * instances and configuring Spring MVC infrastructure programmatically.
		 * 
		 * This allows full control over the instantiation and initialization 
		 * of controllers and their dependencies.
		 */
		this.mockMvc = MockMvcBuilders.standaloneSetup(this.controller).build();
	}
	
	@Test
	void testShowVetList() throws Exception {
		/*
		 * MockMvcRequestBuilders::get(String)
		 *   Create a MockHttpServletRequestBuilder for a GET request.
		 */
		mockMvc.perform(get("/vets.html"));
	}

}///:~