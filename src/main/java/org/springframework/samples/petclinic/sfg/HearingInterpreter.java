//: org.springframework.samples.petclinic.sfg.HearingInterpreter.java


package org.springframework.samples.petclinic.sfg;


import org.springframework.stereotype.Service;


@Service
public class HearingInterpreter {

	private final IWordProducer wordProducer;

	public HearingInterpreter(IWordProducer wordProducer) {
		this.wordProducer = wordProducer;
	}

	public String whatIHeard() {

		String word = this.wordProducer.getWord();
		System.out.printf("%n>>>>>>> I heard '%s'.%n", word);

		return word;
	}

}///:~