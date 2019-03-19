//: org.springframework.samples.petclinic.sfg.junit5.HearingInterpreterActiveProfileIT.java



package org.springframework.samples.petclinic.sfg.junit5;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.sfg.AuditoryIllusion;
import org.springframework.samples.petclinic.sfg.BaseConfig;
import org.springframework.samples.petclinic.sfg.IHearingInterpreter;
import org.springframework.samples.petclinic.sfg.Laurel;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


@ActiveProfiles("baseConfig")
@SpringJUnitConfig(classes = {BaseConfig.class})
class HearingInterpreterActiveProfileIT {

	@Laurel
	@Autowired
	private IHearingInterpreter interpreter;

	@Test
	void whatIHeard() {
		assertThat(this.interpreter.whatIHeard()).as("Should be Laurel.")
				.isEqualTo(AuditoryIllusion.LAUREL.getWord());
	}
}