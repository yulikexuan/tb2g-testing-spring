//: org.springframework.samples.petclinic.sfg.HearingInterpreterIT.java


package org.springframework.samples.petclinic.sfg;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {BaseConfig.class, LaurelConfig.class})
public class HearingInterpreterIT {

	@Autowired
	private HearingInterpreter hearingInterpreter;

	@Test
	public void testWhatIHeard() throws Exception {
		// When
		String heard = this.hearingInterpreter.whatIHeard();

		// Then
		assertThat(heard).as("I should hear '%s'.", heard)
				.isEqualTo(AuditoryIllusion.LAUREL.getWord());
	}

}///:~