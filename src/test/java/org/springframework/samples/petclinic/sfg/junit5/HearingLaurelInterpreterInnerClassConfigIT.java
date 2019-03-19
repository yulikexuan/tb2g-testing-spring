//:org.springframework.samples.petclinic.sfg.junit5.HearingLaurelInterpreterInnerClassConfigIT.java

package org.springframework.samples.petclinic.sfg.junit5;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.samples.petclinic.sfg.AuditoryIllusion;
import org.springframework.samples.petclinic.sfg.HearingLaurelInterpreter;
import org.springframework.samples.petclinic.sfg.IHearingInterpreter;
import org.springframework.samples.petclinic.sfg.LaurelWordProducer;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


@ActiveProfiles("innerLaurel")
@SpringJUnitConfig(classes = {HearingLaurelInterpreterInnerClassConfigIT.InnerConfig.class})
class HearingLaurelInterpreterInnerClassConfigIT {

	@Autowired
	private IHearingInterpreter interpreter;

	@Profile("innerLaurel")
	@Configuration
	static class InnerConfig {
		@Bean
		IHearingInterpreter laurelInterpreter() {
			return new HearingLaurelInterpreter(new LaurelWordProducer());
		}
	}

	@Test
	void whatIHeard() {
		assertThat(this.interpreter.whatIHeard()).as("Should be Laurel.")
				.isEqualTo(AuditoryIllusion.LAUREL.getWord());
	}
}