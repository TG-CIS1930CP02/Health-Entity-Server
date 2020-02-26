package co.edu.javeriana.healthentityserver.model;

import java.util.List;

public class Qualification {
	private List<Identifier> identifier;
	private CodeableConcept code;
	private Period period;
	private Organization issuer;
	
	public Qualification(List<Identifier> identifier, CodeableConcept code, Period period, Organization issuer) {
		super();
		this.identifier = identifier;
		this.code = code;
		this.period = period;
		this.issuer = issuer;
	}

	public List<Identifier> getIdentifier() {
		return identifier;
	}

	public void setIdentifier(List<Identifier> identifier) {
		this.identifier = identifier;
	}

	public CodeableConcept getCode() {
		return code;
	}

	public void setCode(CodeableConcept code) {
		this.code = code;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public Organization getIssuer() {
		return issuer;
	}

	public void setIssuer(Organization issuer) {
		this.issuer = issuer;
	}
}