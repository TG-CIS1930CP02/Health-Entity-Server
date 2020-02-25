package co.edu.javeriana.healthentityserver.model;

import java.net.URI;

public class Identifier {
	private String use;
	private CodeableConcept type; 
	private URI system;
	private String value;
	private Period period;
	private Organization assigner;
	
	public Identifier(String use, CodeableConcept type, URI system, String value, Period period,
			Organization assigner) {
		super();
		this.use = use;
		this.type = type;
		this.system = system;
		this.value = value;
		this.period = period;
		this.assigner = assigner;
	}

	public String getUse() {
		return use;
	}

	public void setUse(String use) {
		this.use = use;
	}

	public CodeableConcept getType() {
		return type;
	}

	public void setType(CodeableConcept type) {
		this.type = type;
	}

	public URI getSystem() {
		return system;
	}

	public void setSystem(URI system) {
		this.system = system;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public Organization getAssigner() {
		return assigner;
	}

	public void setAssigner(Organization assigner) {
		this.assigner = assigner;
	}	
}
