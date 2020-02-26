package co.edu.javeriana.healthentityserver.model;

import java.util.List;

public class ReferenceRange {
	private int low;
	private int high;
	private CodeableConcept type;
	private List<CodeableConcept> appliesTo;
	private Range age;
	private String text;
	
	public ReferenceRange(int low, int high, CodeableConcept type, List<CodeableConcept> appliesTo, Range age,
			String text) {
		super();
		this.low = low;
		this.high = high;
		this.type = type;
		this.appliesTo = appliesTo;
		this.age = age;
		this.text = text;
	}

	public int getLow() {
		return low;
	}

	public void setLow(int low) {
		this.low = low;
	}

	public int getHigh() {
		return high;
	}

	public void setHigh(int high) {
		this.high = high;
	}

	public CodeableConcept getType() {
		return type;
	}

	public void setType(CodeableConcept type) {
		this.type = type;
	}

	public List<CodeableConcept> getAppliesTo() {
		return appliesTo;
	}

	public void setAppliesTo(List<CodeableConcept> appliesTo) {
		this.appliesTo = appliesTo;
	}

	public Range getAge() {
		return age;
	}

	public void setAge(Range age) {
		this.age = age;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
