//:org.springframework.samples.petclinic.sfg.junit5.HearingYannyInterpreterInnerClassConfigIT.java


package org.springframework.samples.petclinic.sfg.junit5;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.samples.petclinic.sfg.AuditoryIllusion;
import org.springframework.samples.petclinic.sfg.HearingYannyInterpreter;
import org.springframework.samples.petclinic.sfg.IHearingInterpreter;
import org.springframework.samples.petclinic.sfg.YannyWordProducer;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


@ActiveProfiles("innerYanny")
@SpringJUnitConfig(classes = {HearingYannyInterpreterInnerClassConfigIT.InnerConfig.class})
class HearingYannyInterpreterInnerClassConfigIT {

	@Profile("innerYanny")
	@Configuration
	static class InnerConfig {
		@Bean
		IHearingInterpreter yannyInterpreter() {
			return new HearingYannyInterpreter(new YannyWordProducer());
		}
	}

	@Autowired
	private IHearingInterpreter interpreter;

	@Test
	void whatIHeard() {
		assertThat(this.interpreter.whatIHeard()).as("Should be Yanny.")
				.isEqualTo(AuditoryIllusion.YANNY.getWord());
	}
}