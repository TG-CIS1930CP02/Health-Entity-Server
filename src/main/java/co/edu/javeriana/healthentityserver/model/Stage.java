package co.edu.javeriana.healthentityserver.model;

public class Stage {
	private CodeableConcept summary;
	private DiagnosticReport assessment; // Reference(ClinicalImpression | DiagnosticReport | Observation)
	private CodeableConcept type;
	
	public Stage(CodeableConcept summary, DiagnosticReport assessment, CodeableConcept type) {
		super();
		this.summary = summary;
		this.assessment = assessment;
		this.type = type;
	}

	public CodeableConcept getSummary() {
		return summary;
	}

	public void setSummary(CodeableConcept summary) {
		this.summary = summary;
	}

	public DiagnosticReport getAssessment() {
		return assessment;
	}

	public void setAssessment(DiagnosticReport assessment) {
		this.assessment = assessment;
	}

	public CodeableConcept getType() {
		return type;
	}

	public void setType(CodeableConcept type) {
		this.type = type;
	}
}
