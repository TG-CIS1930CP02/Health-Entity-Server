package co.edu.javeriana.healthentityserver.model;

import java.util.List;

public class CodeableConcept{
	private List<Coding> coding;
	private String text;
	
	public CodeableConcept(List<Coding> coding, String text) {
		super();
		this.coding = coding;
		this.text = text;
	}

	public List<Coding> getCoding() {
		return coding;
	}

	public void setCoding(List<Coding> coding) {
		this.coding = coding;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
