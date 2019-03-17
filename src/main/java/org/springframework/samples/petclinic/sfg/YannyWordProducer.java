//: org.springframework.samples.petclinic.sfg.YannyWordProducer.java


package org.springframework.samples.petclinic.sfg;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component
@Primary
public class YannyWordProducer implements IWordProducer {

	@Override
	public String getWord() {
		return AuditoryIllusion.YANNY.getWord();
	}

}///:~