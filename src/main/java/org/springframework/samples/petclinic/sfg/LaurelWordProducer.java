//: org.springframework.samples.petclinic.sfg.LaurelWordProducer.java


package org.springframework.samples.petclinic.sfg;


import org.springframework.stereotype.Component;


@Component
public class LaurelWordProducer implements IWordProducer {

	@Override
	public String getWord() {
		return AuditoryIllusion.LAUREL.getWord();
	}

}///:~