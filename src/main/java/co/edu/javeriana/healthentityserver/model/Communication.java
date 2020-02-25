package co.edu.javeriana.healthentityserver.model;

public class Communication {
	private CodeableConcept language;
	private boolean prefered;
	
	public Communication(CodeableConcept language, boolean prefered) {
		super();
		this.language = language;
		this.prefered = prefered;
	}

	public CodeableConcept getLanguage() {
		return language;
	}

	public void setLanguage(CodeableConcept language) {
		this.language = language;
	}

	public boolean isPrefered() {
		return prefered;
	}

	public void setPrefered(boolean prefered) {
		this.prefered = prefered;
	}
}
