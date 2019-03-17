//: org.springframework.samples.petclinic.sfg.HearingInterpreterTest.java


package org.springframework.samples.petclinic.sfg;


import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class HearingInterpreterTest {

	private HearingInterpreter hearingInterpreter;

	@Before
	public void setUp() throws Exception {
		this.hearingInterpreter = new HearingInterpreter(new LaurelWordProducer());
	}

	@Test
	public void testWhatIHeard() {
		// When
		String heard = this.hearingInterpreter.whatIHeard();

		// Then
		assertThat(heard).as("I should hear '%s'.", heard)
				.isEqualTo(AuditoryIllusion.LAUREL.getWord());
	}

}///:~