package co.edu.javeriana.healthentityserver.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "patient")
public class Patient {
	@Id
	private String id;
	private List<Identifier> identifier;
	private boolean active;
	private List<HumanName> name;
	private List<ContactPoint> telecom;
	private String gender;
	private Date birthDate;
	private boolean deceasedBoolean; // can be either of this
	private Date deceasedDateTime;
	private List<Address> address;
	private CodeableConcept maritialStatus;
	private boolean multipleBirthBoolean; // can be either of this
	private int multipleBirthInteger;
	private List<Attachment> photo;
	private List<Contact> contact;
	private List<Communication> communication;
	private List<Practitioner> practitioner; // should we use it to support? -> Reference(Organization | Practitioner | PractitionerRole)
	private Organization organization;
	private List<Link> link;
	
	public Patient(String id, List<Identifier> identifier, boolean active, List<HumanName> name,
			List<ContactPoint> telecom, String gender, Date birthDate, boolean deceasedBoolean, Date deceasedDateTime,
			List<Address> address, CodeableConcept maritialStatus, boolean multipleBirthBoolean,
			int multipleBirthInteger, List<Attachment> photo, List<Contact> contact, List<Communication> communication,
			List<Practitioner> practitioner, Organization organization, List<Link> link) {
		super();
		this.id = id;
		this.identifier = identifier;
		this.active = active;
		this.name = name;
		this.telecom = telecom;
		this.gender = gender;
		this.birthDate = birthDate;
		this.deceasedBoolean = deceasedBoolean;
		this.deceasedDateTime = deceasedDateTime;
		this.address = address;
		this.maritialStatus = maritialStatus;
		this.multipleBirthBoolean = multipleBirthBoolean;
		this.multipleBirthInteger = multipleBirthInteger;
		this.photo = photo;
		this.contact = contact;
		this.communication = communication;
		this.practitioner = practitioner;
		this.organization = organization;
		this.link = link;
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

	public boolean isDeceasedBoolean() {
		return deceasedBoolean;
	}

	public void setDeceasedBoolean(boolean deceasedBoolean) {
		this.deceasedBoolean = deceasedBoolean;
	}

	public Date getDeceasedDateTime() {
		return deceasedDateTime;
	}

	public void setDeceasedDateTime(Date deceasedDateTime) {
		this.deceasedDateTime = deceasedDateTime;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public CodeableConcept getMaritialStatus() {
		return maritialStatus;
	}

	public void setMaritialStatus(CodeableConcept maritialStatus) {
		this.maritialStatus = maritialStatus;
	}

	public boolean isMultipleBirthBoolean() {
		return multipleBirthBoolean;
	}

	public void setMultipleBirthBoolean(boolean multipleBirthBoolean) {
		this.multipleBirthBoolean = multipleBirthBoolean;
	}

	public int getMultipleBirthInteger() {
		return multipleBirthInteger;
	}

	public void setMultipleBirthInteger(int multipleBirthInteger) {
		this.multipleBirthInteger = multipleBirthInteger;
	}

	public List<Attachment> getPhoto() {
		return photo;
	}

	public void setPhoto(List<Attachment> photo) {
		this.photo = photo;
	}

	public List<Contact> getContact() {
		return contact;
	}

	public void setContact(List<Contact> contact) {
		this.contact = contact;
	}

	public List<Communication> getCommunication() {
		return communication;
	}

	public void setCommunication(List<Communication> communication) {
		this.communication = communication;
	}

	public List<Practitioner> getPractitioner() {
		return practitioner;
	}

	public void setPractitioner(List<Practitioner> practitioner) {
		this.practitioner = practitioner;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public List<Link> getLink() {
		return link;
	}

	public void setLink(List<Link> link) {
		this.link = link;
	}
}
