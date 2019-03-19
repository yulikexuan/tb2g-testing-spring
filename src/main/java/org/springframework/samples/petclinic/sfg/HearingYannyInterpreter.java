//: org.springframework.samples.petclinic.sfg.HearingYannyInterpreter.java


package org.springframework.samples.petclinic.sfg;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Yanny
@Service
public class HearingYannyInterpreter implements IHearingInterpreter {
	
	private final IWordProducer wordProducer;

	@Autowired
	public HearingYannyInterpreter(@Yanny IWordProducer wordProducer) {
		this.wordProducer = wordProducer;
	}

	@Override
	public String whatIHeard() {

		String word = this.wordProducer.getWord();
		System.out.printf("%n>>>>>>> I heard '%s'.%n", word);

		return word;
	}

}///:~