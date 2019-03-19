//: org.springframework.samples.petclinic.sfg.junit5.HearingLaurelInterpreterPropretiesIT.java



package org.springframework.samples.petclinic.sfg.junit5;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.samples.petclinic.sfg.IHearingInterpreter;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


@TestPropertySource("classpath:laurel.properties")
@ActiveProfiles("expernalized")
@SpringJUnitConfig(classes = {HearingInterpreterPropretiesIT.PropertiesConfig.class})
class HearingLaurelInterpreterPropretiesIT {
	
	@Configuration
	@ComponentScan("org.springframework.samples.petclinic.sfg")
	static class PropertiesConfig {
	}
	
	@Autowired
	private IHearingInterpreter interpreter;

	@Test
	void whatIHeard() {
		assertThat(this.interpreter.whatIHeard()).as("Should be YaNNy.")
				.isEqualTo("LaUrEl");
	}
}