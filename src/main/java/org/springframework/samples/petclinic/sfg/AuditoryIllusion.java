//: org.springframework.samples.petclinic.sfg.AuditoryIllusion.java


package org.springframework.samples.petclinic.sfg;


public enum AuditoryIllusion {

	YANNY("Yanny"),
	LAUREL("Laurel");

	private final String word;

	AuditoryIllusion(String word) {
		this.word = word;
	}

	public String getWord() {
		return this.word;
	}

}///:~