//: org.springframework.samples.petclinic.web.OwnerControllerTest.java


package org.springframework.samples.petclinic.web;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


/*
 * @SpringJUnitWebConfig is a composed annotation that combines 
 *   @ExtendWith(SpringExtension.class) from JUnit Jupiter with 
 *   @ContextConfiguration and 
 *   @WebAppConfiguration from the Spring TestContext Framework.
 */
@SpringJUnitWebConfig(locations = {
		"classpath:spring/mvc-test-config.xml", 
		"classpath:spring/mvc-core-config.xml"})
@ExtendWith(MockitoExtension.class)
class OwnerControllerXmlConfigTest {
	
	@Autowired
	private ClinicService service;
	
	@Autowired
	private OwnerController controller;

	private MockMvc mockMvc;
	
	@BeforeEach
	void setUp() throws Exception {
		/*
		 * Build a MockMvc instance by registering one or more @Controller 
		 * instances and configuring Spring MVC infrastructure programmatically.
		 * 
		 * This allows full control over the instantiation and initialization 
		 * of controllers and their dependencies.
		 * 
		 * MockMvcBuilders::standaloneSetup return StandaloneMockMvcBuilder
		 */
		this.mockMvc = MockMvcBuilders.standaloneSetup(this.controller).build();
	}

	@DisplayName("Able to initialize a creation form view with a default Owner ")
	@Test
	void testInitCreationForm() throws Exception {

		// When
		this.mockMvc.perform(get("/owners/new"))
				.andExpect(model().attributeExists("owner"))
				.andExpect(view().name(
						OwnerController.VIEWS_OWNER_CREATE_OR_UPDATE_FORM))
				.andExpect(status().isOk());
		
	}

}///:~