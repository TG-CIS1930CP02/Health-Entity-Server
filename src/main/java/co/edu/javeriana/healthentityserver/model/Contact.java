package co.edu.javeriana.healthentityserver.model;

import java.util.List;

public class Contact {
	private CodeableConcept relationship;
	private HumanName name;
	private List<ContactPoint> telecom;
	private Address address;
	private String gender;
	private Organization organization;
	private Period period;
	
	public Contact(CodeableConcept relationship, HumanName name, List<ContactPoint> telecom, Address address,
			String gender, Organization organization, Period period) {
		super();
		this.relationship = relationship;
		this.name = name;
		this.telecom = telecom;
		this.address = address;
		this.gender = gender;
		this.organization = organization;
		this.period = period;
	}

	public CodeableConcept getRelationship() {
		return relationship;
	}

	public void setRelationship(CodeableConcept relationship) {
		this.relationship = relationship;
	}

	public HumanName getName() {
		return name;
	}

	public void setName(HumanName name) {
		this.name = name;
	}

	public List<ContactPoint> getTelecom() {
		return telecom;
	}

	public void setTelecom(List<ContactPoint> telecom) {
		this.telecom = telecom;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}
}
