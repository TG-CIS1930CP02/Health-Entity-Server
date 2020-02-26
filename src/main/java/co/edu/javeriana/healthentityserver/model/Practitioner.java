package co.edu.javeriana.healthentityserver.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "practitioner")
public class Practitioner {
	@Id
	private String id;
	private List<Identifier> identifier;
	private boolean active;
	private List<HumanName> name;
	private List<ContactPoint> telecom;
	private List<Address> address;
	private String gender;
	private Date birthDate;
	private List<Attachment> photo;
	private List<Qualification> qualification;
	private List<CodeableConcept> communication;
	
	public Practitioner(String id, List<Identifier> identifier, boolean active, List<HumanName> name,
			List<ContactPoint> telecom, List<Address> address, String gender, Date birthDate, List<Attachment> photo,
			List<Qualification> qualification, List<CodeableConcept> communication) {
		super();
		this.id = id;
		this.identifier = identifier;
		this.active = active;
		this.name = name;
		this.telecom = telecom;
		this.address = address;
		this.gender = gender;
		this.birthDate = birthDate;
		this.photo = photo;
		this.qualification = qualification;
		this.communication = communication;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Identifier> getIdentifier() {
		return identifier;
	}

	public void setIdentifier(List<Identifier> identifier) {
		this.identifier = identifier;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<HumanName> getName() {
		return name;
	}

	public void setName(List<HumanName> name) {
		this.name = name;
	}

	public List<ContactPoint> getTelecom() {
		return telecom;
	}

	public void setTelecom(List<ContactPoint> telecom) {
		this.telecom = telecom;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public List<Attachment> getPhoto() {
		return photo;
	}

	public void setPhoto(List<Attachment> photo) {
		this.photo = photo;
	}

	public List<Qualification> getQualification() {
		return qualification;
	}

	public void setQualification(List<Qualification> qualification) {
		this.qualification = qualification;
	}

	public List<CodeableConcept> getCommunication() {
		return communication;
	}

	public void setCommunication(List<CodeableConcept> communication) {
		this.communication = communication;
	}
}
