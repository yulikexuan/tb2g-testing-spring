//: org.springframework.samples.petclinic.web.VetControllerTest.java


package org.springframework.samples.petclinic.web;


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

import java.util.List;
import java.util.Map;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(MockitoExtension.class)
class VetControllerTest {

	@Mock
	private ClinicService service;
	
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

		// When

		/*
		 * MockMvcRequestBuilders::get(String)
		 *   Static factory methods for RequestBuilders: create
		 *   a MockHttpServletRequestBuilder for a GET request.
		 *
		 * MovkMvc::perform(RequestBuilder) return ResultActions
		 *   Perform a request and return a type that allows chaining further
		 *   actions, such as asserting expectations, on the result.
		 *
		 * ResultActions::andExpect(ResultMatcher) return ResultActions
		 *   Perform an expectation.
		 *
		 * MockMvcResultMatchers
		 *   Static factory methods for ResultMatcher-based result actions.
		 *
		 * MockMvcResultMatchers::status() return StatusResultMatchers
		 *
		 * StatusResultMatchers::isOk()
		 *   Assert the response status code is HttpStatus.OK (200).
		 *
		 * MockMvcResultMatchers::model() return ModelResultMatchers
		 *   Access to model-related assertions.
		 *
		 * ModelResultMatchers::attributeExists(String)
		 *   Assert the given model attributes exist.
		 *
		 * MockMvcResultMatchers::view() return ViewResultMatchers
		 *   Access to assertions on the selected view.
		 *
		 * ViewResultMatchers::name(String)
		 *   Assert the selected view name.
		 *
		 */
		mockMvc.perform(get("/vets.html"))
				.andExpect(model().attributeExists("vets"))
				.andExpect(view().name("vets/vetList"))
				.andExpect(status().isOk());

		// Then
		then(this.service).should(times(1)).findVets();
	}

}///:~