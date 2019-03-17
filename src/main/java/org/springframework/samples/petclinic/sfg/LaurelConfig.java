//: org.springframework.samples.petclinic.sfg.LaurelConfig.java


package org.springframework.samples.petclinic.sfg;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class LaurelConfig {

	@Bean
	LaurelWordProducer getLaurelWordProducer() {
		return new LaurelWordProducer();
	}

}///:~