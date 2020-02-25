package co.edu.javeriana.healthentityserver.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;

@Data
@Document(collection = "conditions")
public class Condition {
	@Id
	private String id;
	private List<Identifier> identifier;
	private CodeableConcept clinicalStatus;
	private CodeableConcept verificationStatus;
	private List<CodeableConcept> category;
	private CodeableConcept severity;
	private CodeableConcept code;
	private List<CodeableConcept> bodySite;
	//@ManyToOne(fetch = FetchType.LAZY)
	@NonNull
	private Patient subject;
	private String encounter; // reference encounter?? 
	private Date onsetDateTime;
	private int onsetAge;
	private Period onsetPeriod;
	private Range onsetRange;
	private String onsetString;
	private Date abatementDateTime;
	private int abatementAge;
	private Period abatementPeriod;
	private Range abatementRange;
	private String abatementString;
	private Date recordedDate;
	private Practitioner recorder; // Reference(Practitioner | PractitionerRole | Patient | RelatedPerson)
	private Practitioner asserter; // Reference(Practitioner | PractitionerRole | Patient | RelatedPerson)
	private Stage stage;
	private Evidence evidence;
	private Annotation note;
	
	public Condition(String id, List<Identifier> identifier, CodeableConcept clinicalStatus,
			CodeableConcept verificationStatus, List<CodeableConcept> category, CodeableConcept severity,
			CodeableConcept code, List<CodeableConcept> bodySite, Patient subject, String encounter, Date onsetDateTime,
			int onsetAge, Period onsetPeriod, Range onsetRange, String onsetString, Date abatementDateTime,
			int abatementAge, Period abatementPeriod, Range abatementRange, String abatementString, Date recordedDate,
			Practitioner recorder, Practitioner asserter, Stage stage, Evidence evidence, Annotation note) {
		super();
		this.id = id;
		this.identifier = identifier;
		this.clinicalStatus = clinicalStatus;
		this.verificationStatus = verificationStatus;
		this.category = category;
		this.severity = severity;
		this.code = code;
		this.bodySite = bodySite;
		this.subject = subject;
		this.encounter = encounter;
		this.onsetDateTime = onsetDateTime;
		this.onsetAge = onsetAge;
		this.onsetPeriod = onsetPeriod;
		this.onsetRange = onsetRange;
		this.onsetString = onsetString;
		this.abatementDateTime = abatementDateTime;
		this.abatementAge = abatementAge;
		this.abatementPeriod = abatementPeriod;
		this.abatementRange = abatementRange;
		this.abatementString = abatementString;
		this.recordedDate = recordedDate;
		this.recorder = recorder;
		this.asserter = asserter;
		this.stage = stage;
		this.evidence = evidence;
		this.note = note;
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

	public CodeableConcept getClinicalStatus() {
		return clinicalStatus;
	}

	public void setClinicalStatus(CodeableConcept clinicalStatus) {
		this.clinicalStatus = clinicalStatus;
	}

	public CodeableConcept getVerificationStatus() {
		return verificationStatus;
	}

	public void setVerificationStatus(CodeableConcept verificationStatus) {
		this.verificationStatus = verificationStatus;
	}

	public List<CodeableConcept> getCategory() {
		return category;
	}

	public void setCategory(List<CodeableConcept> category) {
		this.category = category;
	}

	public CodeableConcept getSeverity() {
		return severity;
	}

	public void setSeverity(CodeableConcept severity) {
		this.severity = severity;
	}

	public CodeableConcept getCode() {
		return code;
	}

	public void setCode(CodeableConcept code) {
		this.code = code;
	}

	public List<CodeableConcept> getBodySite() {
		return bodySite;
	}

	public void setBodySite(List<CodeableConcept> bodySite) {
		this.bodySite = bodySite;
	}

	public Patient getSubject() {
		return subject;
	}

	public void setSubject(Patient subject) {
		this.subject = subject;
	}

	public String getEncounter() {
		return encounter;
	}

	public void setEncounter(String encounter) {
		this.encounter = encounter;
	}

	public Date getOnsetDateTime() {
		return onsetDateTime;
	}

	public void setOnsetDateTime(Date onsetDateTime) {
		this.onsetDateTime = onsetDateTime;
	}

	public int getOnsetAge() {
		return onsetAge;
	}

	public void setOnsetAge(int onsetAge) {
		this.onsetAge = onsetAge;
	}

	public Period getOnsetPeriod() {
		return onsetPeriod;
	}

	public void setOnsetPeriod(Period onsetPeriod) {
		this.onsetPeriod = onsetPeriod;
	}

	public Range getOnsetRange() {
		return onsetRange;
	}

	public void setOnsetRange(Range onsetRange) {
		this.onsetRange = onsetRange;
	}

	public String getOnsetString() {
		return onsetString;
	}

	public void setOnsetString(String onsetString) {
		this.onsetString = onsetString;
	}

	public Date getAbatementDateTime() {
		return abatementDateTime;
	}

	public void setAbatementDateTime(Date abatementDateTime) {
		this.abatementDateTime = abatementDateTime;
	}

	public int getAbatementAge() {
		return abatementAge;
	}

	public void setAbatementAge(int abatementAge) {
		this.abatementAge = abatementAge;
	}

	public Period getAbatementPeriod() {
		return abatementPeriod;
	}

	public void setAbatementPeriod(Period abatementPeriod) {
		this.abatementPeriod = abatementPeriod;
	}

	public Range getAbatementRange() {
		return abatementRange;
	}

	public void setAbatementRange(Range abatementRange) {
		this.abatementRange = abatementRange;
	}

	public String getAbatementString() {
		return abatementString;
	}

	public void setAbatementString(String abatementString) {
		this.abatementString = abatementString;
	}

	public Date getRecordedDate() {
		return recordedDate;
	}

	public void setRecordedDate(Date recordedDate) {
		this.recordedDate = recordedDate;
	}

	public Practitioner getRecorder() {
		return recorder;
	}

	public void setRecorder(Practitioner recorder) {
		this.recorder = recorder;
	}

	public Practitioner getAsserter() {
		return asserter;
	}

	public void setAsserter(Practitioner asserter) {
		this.asserter = asserter;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public Evidence getEvidence() {
		return evidence;
	}

	public void setEvidence(Evidence evidence) {
		this.evidence = evidence;
	}

	public Annotation getNote() {
		return note;
	}

	public void setNote(Annotation note) {
		this.note = note;
	}
}
