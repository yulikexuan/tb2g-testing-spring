//: org.springframework.samples.petclinic.sfg.HearingLaurelInterpreterInnerComponentScanIT.java


package org.springframework.samples.petclinic.sfg.junit5;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.samples.petclinic.sfg.AuditoryIllusion;
import org.springframework.samples.petclinic.sfg.IHearingInterpreter;
import org.springframework.samples.petclinic.sfg.Laurel;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.Assertions.assertThat;


@ActiveProfiles("innerScan")
@SpringJUnitConfig(classes = {HearingLaurelInterpreterInnerComponentScanIT.InnerComponentScan.class})
class HearingLaurelInterpreterInnerComponentScanIT {

	@Profile("innerScan")
	@Configuration
	@ComponentScan(basePackages="org.springframework.samples.petclinic.sfg")
	static class InnerComponentScan {
	}

	@Laurel
	@Autowired
	private IHearingInterpreter laurelInterpreter;

	@Test
	void whatIHeard() {
		assertThat(this.laurelInterpreter.whatIHeard()).as("Should be Laurel.")
				.isEqualTo(AuditoryIllusion.LAUREL.getWord());
	}
}