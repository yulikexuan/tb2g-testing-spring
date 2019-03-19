//: org.springframework.samples.petclinic.sfg.BaseConfig.java


package org.springframework.samples.petclinic.sfg;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Profile("baseConfig")
@Configuration
@ComponentScan(basePackages="org.springframework.samples.petclinic.sfg")
public class BaseConfig {
}///:~