//: org.springframework.samples.petclinic.sfg.PropertiesWordProducer.java


package org.springframework.samples.petclinic.sfg;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@External
@Component
public class PropertiesWordProducer implements IWordProducer {

	private String word;
	
	@Value("${say.word}")
	public void setWord(String word) {
		this.word = word;
	}

	@Override
	public String getWord() {
		return this.word;
	}

}///:~