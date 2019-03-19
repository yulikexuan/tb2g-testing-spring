//: org.springframework.samples.petclinic.sfg.HearingInterpreter.java


package org.springframework.samples.petclinic.sfg;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


@Profile("expernalized")
@Primary
@Service
public class HearingInterpreter implements IHearingInterpreter {
	
	private IWordProducer wordProducer;

	@Autowired
	public HearingInterpreter(@External IWordProducer wordProducer) {
		super();
		this.wordProducer = wordProducer;
	}



	@Override
	public String whatIHeard() {

		String word = this.wordProducer.getWord();
		System.out.printf("%n>>>>>>> I heard '%s'.%n", word);

		return word;
	}

}///:~