package co.edu.javeriana.healthentityserver.model;

public class Performer {
	private CodeableConcept function;
	private Practitioner actor; // Reference(Practitioner | PractitionerRole | Organization | Patient | RelatedPerson | Device)
	private String onBehalfOf; // reference organization
	
	public Performer(CodeableConcept function, Practitioner actor, String onBehalfOf) {
		super();
		this.function = function;
		this.actor = actor;
		this.onBehalfOf = onBehalfOf;
	}

	public CodeableConcept getFunction() {
		return function;
	}

	public void setFunction(CodeableConcept function) {
		this.function = function;
	}

	public Practitioner getActor() {
		return actor;
	}

	public void setActor(Practitioner actor) {
		this.actor = actor;
	}

	public String getOnBehalfOf() {
		return onBehalfOf;
	}

	public void setOnBehalfOf(String onBehalfOf) {
		this.onBehalfOf = onBehalfOf;
	}
}
