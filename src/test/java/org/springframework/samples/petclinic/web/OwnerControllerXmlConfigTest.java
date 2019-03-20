//: org.springframework.samples.petclinic.web.OwnerControllerTest.java


package org.springframework.samples.petclinic.web;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Owner;
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

	@DisplayName("Able to initialize a creation form view with a default Owner - ")
	@Test
	void testInitCreationForm() throws Exception {

		// When
		this.mockMvc.perform(get("/owners/new"))
				.andExpect(model().attributeExists("owner"))
				.andExpect(view().name(
						OwnerController.VIEWS_OWNER_CREATE_OR_UPDATE_FORM))
				.andExpect(status().isOk());
		
	}

	@Nested
	@DisplayName("Test how Find-Form is processed - ")
	@SpringJUnitWebConfig(locations = {
			"classpath:spring/mvc-test-config.xml", 
			"classpath:spring/mvc-core-config.xml"})
	class FindFormProcessingTest {
		
		@Captor
		private ArgumentCaptor<String> strArgCaptor;
		
		@AfterEach
		void tearDown() {
			reset(service);
		}
		
		@DisplayName("Should go back to findOwners view if owner's name is not found - ")
		@Test
		void testOwnerNameNotFound() throws Exception {
			
			// Given
			final String lastName = "Do not find ME!";
			Collection<Owner> owners = new ArrayList<>();
			given(service.findOwnerByLastName(lastName)).willReturn(owners);
			
			// When
			/*
			 * MockHttpServletRequestBuilder::param(String, String...)
			 *   Return MockHttpServletRequestBuilder
			 *   Add a request parameter to the MockHttpServletRequest.
			 *   If called more than once, new values get added to existing ones.
			 */
			mockMvc.perform(get("/owners").param("lastName", lastName))
					.andExpect(status().isOk())
					.andExpect(view().name("owners/findOwners"));
			
			// Then
			then(service).should().findOwnerByLastName(this.strArgCaptor.capture());
			assertThat(this.strArgCaptor.getValue()).as("Should search '%s'.", lastName)
					.isEqualTo(lastName);
		}
		
		@DisplayName("Null lastName will be converted to empty String - ")
		@Test
		void testOwnerNameIsNull() throws Exception {
			
			// Given
			Collection<Owner> owners = new ArrayList<>();
			
			given(service.findOwnerByLastName("")).willReturn(owners);
			
			// When
			mockMvc.perform(get("/owners"))
					.andExpect(status().isOk())
					.andExpect(view().name("owners/findOwners"));
			
			then(service).should().findOwnerByLastName(this.strArgCaptor.capture());
			assertThat(this.strArgCaptor.getValue()).as("Should search empty string.")
					.isEqualTo("");
		}
		
		@DisplayName("Go to single owner view if one owner found - ")
		@Test
		void testOneOwnerFound() throws Exception {
			
			// Given
			final String lastName = "Gates";
			Owner owner = new Owner();
			int id = 1;
			owner.setLastName(lastName);
			owner.setId(id);
			Collection<Owner> owners = List.of(owner);
			
			given(service.findOwnerByLastName(lastName)).willReturn(owners);
			
			// When
			mockMvc.perform(get("/owners").param("lastName", lastName))
					.andExpect(redirectedUrl("/owners/1"))
					.andExpect(status().is3xxRedirection());
			
			// Then
			then(service).should().findOwnerByLastName(this.strArgCaptor.capture());
			assertThat(this.strArgCaptor.getValue()).as("Should search '%s'.", lastName)
					.isEqualTo(lastName);
		}
		
		@DisplayName("Go to owner list view if more than one owner found - ")
		@Test
		void testMoreThanOneOwnerFound() throws Exception {
			
			// Given
			final String lastName = "Jobs";
			Collection<Owner> owners = List.of(new Owner(), new Owner());
			
			given(service.findOwnerByLastName(lastName)).willReturn(owners);
			
			// When
			mockMvc.perform(get("/owners").param("lastName", lastName))
					.andExpect(view().name("owners/ownersList"))
					.andExpect(status().isOk());
			
			// Then
			then(service).should().findOwnerByLastName(this.strArgCaptor.capture());
			assertThat(this.strArgCaptor.getValue()).as("Should search '%s'.", lastName)
					.isEqualTo(lastName);
		}
		
	}//: End of FindFormProcessingTest
	
}///:~