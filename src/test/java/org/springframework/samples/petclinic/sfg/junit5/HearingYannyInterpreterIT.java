//: org.springframework.samples.petclinic.sfg.junit5.HearingYannyInterpreterIT.java



package org.springframework.samples.petclinic.sfg.junit5;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.sfg.AuditoryIllusion;
import org.springframework.samples.petclinic.sfg.BaseConfig;
import org.springframework.samples.petclinic.sfg.HearingYannyInterpreter;
import org.springframework.samples.petclinic.sfg.IHearingInterpreter;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringJUnitConfig(classes = {BaseConfig.class})
class HearingYannyInterpreterIT {

	@Autowired
	private HearingYannyInterpreter interpreter;

	@Test
	void whatIHeard() {
		assertThat(this.interpreter.whatIHeard()).as("Should be Yanny.")
				.isEqualTo(AuditoryIllusion.YANNY.getWord());
	}
}