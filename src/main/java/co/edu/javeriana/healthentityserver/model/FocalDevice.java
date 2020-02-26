package co.edu.javeriana.healthentityserver.model;

import java.util.List;

public class FocalDevice {
	private CodeableConcept action;
	private List<String> manipulated; // Reference(Device)
	
	public FocalDevice(CodeableConcept action, List<String> manipulated) {
		super();
		this.action = action;
		this.manipulated = manipulated;
	}

	public CodeableConcept getAction() {
		return action;
	}

	public void setAction(CodeableConcept action) {
		this.action = action;
	}

	public List<String> getManipulated() {
		return manipulated;
	}

	public void setManipulated(List<String> manipulated) {
		this.manipulated = manipulated;
	}
}
