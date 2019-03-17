//: org.springframework.samples.petclinic.sfg.BaseConfig.java


package org.springframework.samples.petclinic.sfg;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BaseConfig {

	@Bean
	HearingInterpreter getHearingInterpreter(IWordProducer wordProducer) {
		return new HearingInterpreter(wordProducer);
	}

}///:~