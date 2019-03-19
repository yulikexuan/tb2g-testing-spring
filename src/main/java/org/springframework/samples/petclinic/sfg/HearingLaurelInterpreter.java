//: org.springframework.samples.petclinic.sfg.HearingLaurelInterpreter.java


package org.springframework.samples.petclinic.sfg;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Laurel
@Service
public class HearingLaurelInterpreter implements IHearingInterpreter {
	
	private final IWordProducer wordProducer;

	@Autowired
	public HearingLaurelInterpreter(@Laurel IWordProducer wordProducer) {
		this.wordProducer = wordProducer;
	}

	@Override
	public String whatIHeard() {

		String word = this.wordProducer.getWord();
		System.out.printf("%n>>>>>>> I heard '%s'.%n", word);

		return word;
	}

}///:~