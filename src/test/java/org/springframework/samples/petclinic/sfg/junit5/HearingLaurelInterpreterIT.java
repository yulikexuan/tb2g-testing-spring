//: org.springframework.samples.petclinic.sfg.junit5.HearingLaurelInterpreterIT.java


package org.springframework.samples.petclinic.sfg.junit5;


import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.sfg.AuditoryIllusion;
import org.springframework.samples.petclinic.sfg.BaseConfig;
import org.springframework.samples.petclinic.sfg.HearingLaurelInterpreter;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.Assertions.assertThat;


@SpringJUnitConfig(classes = {BaseConfig.class})
class HearingLaurelInterpreterIT {

	@Autowired
	private HearingLaurelInterpreter interpreter;

	@Test
	void whatIHeard() {
		assertThat(this.interpreter.whatIHeard()).as("Should be Laurel.")
				.isEqualTo(AuditoryIllusion.LAUREL.getWord());
	}

}///:~