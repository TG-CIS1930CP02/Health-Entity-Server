package co.edu.javeriana.healthentityserver.model;

import java.util.Date;
import java.util.List;

public class Timing {
	private List<Date> event;
	private Element repeat; 
	private CodeableConcept code;
	
	public Timing(List<Date> event, Element repeat, CodeableConcept code) {
		super();
		this.event = event;
		this.repeat = repeat;
		this.code = code;
	}

	public List<Date> getEvent() {
		return event;
	}

	public void setEvent(List<Date> event) {
		this.event = event;
	}

	public Element getRepeat() {
		return repeat;
	}

	public void setRepeat(Element repeat) {
		this.repeat = repeat;
	}

	public CodeableConcept getCode() {
		return code;
	}

	public void setCode(CodeableConcept code) {
		this.code = code;
	}
}
