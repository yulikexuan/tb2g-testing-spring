//: org.springframework.samples.petclinic.sfg.YannyWordProducer.java


package org.springframework.samples.petclinic.sfg;


import org.springframework.stereotype.Component;


@Yanny
@Component
public class YannyWordProducer implements IWordProducer {

	@Override
	public String getWord() {
		return AuditoryIllusion.YANNY.getWord();
	}

}///:~