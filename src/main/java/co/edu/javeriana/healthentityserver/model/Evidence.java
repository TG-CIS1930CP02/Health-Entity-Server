package co.edu.javeriana.healthentityserver.model;

public class Evidence {
	private CodeableConcept code;
	private String detail; // Supporting information found elsewhere
	
	public Evidence(CodeableConcept code, String detail) {
		super();
		this.code = code;
		this.detail = detail;
	}

	public CodeableConcept getCode() {
		return code;
	}

	public void setCode(CodeableConcept code) {
		this.code = code;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
}
