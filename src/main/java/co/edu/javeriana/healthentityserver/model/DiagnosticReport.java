package co.edu.javeriana.healthentityserver.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;

@Data
@Document(collection = "diagnostic_report")
public class DiagnosticReport {
	@Id
	private String id;
	private List<Identifier> identifier;
	private List<String> basedOn; // Reference(CarePlan | ImmunizationRecommendation | MedicationRequest | NutritionOrder | ServiceRequest)
	@NonNull
	private String status; // registered | partial | preliminary | final +
	private List<CodeableConcept> category;
	@NonNull
	private CodeableConcept code;
	private Patient subject;
	private String encounter; // reference encounter
	private Date effectiveDateTime;
	private Period effectivePeriod;
	private Date issued;
	private List<Practitioner> performer; // Reference(Practitioner | PractitionerRole | Organization | CareTeam)
	private List<Practitioner> resultsInterpreter; // Reference(Practitioner | PractitionerRole | Organization | CareTeam)
	private List<String> specimen; // reference specimen
	private List<Observation> result;
	private List<String> imagingStudy; // reference imagingstudy
	private List<Media> media;
	private String conclusion;
	private List<CodeableConcept> conclusionCode;
	private List<Attachment> presentedForm;
	
	public DiagnosticReport(String id, List<Identifier> identifier, List<String> basedOn, String status,
			List<CodeableConcept> category, CodeableConcept code, Patient subject, String encounter,
			Date effectiveDateTime, Period effectivePeriod, Date issued, List<Practitioner> performer,
			List<Practitioner> resultsInterpreter, List<String> specimen, List<Observation> result,
			List<String> imagingStudy, List<Media> media, String conclusion, List<CodeableConcept> conclusionCode,
			List<Attachment> presentedForm) {
		super();
		this.id = id;
		this.identifier = identifier;
		this.basedOn = basedOn;
		this.status = status;
		this.category = category;
		this.code = code;
		this.subject = subject;
		this.encounter = encounter;
		this.effectiveDateTime = effectiveDateTime;
		this.effectivePeriod = effectivePeriod;
		this.issued = issued;
		this.performer = performer;
		this.resultsInterpreter = resultsInterpreter;
		this.specimen = specimen;
		this.result = result;
		this.imagingStudy = imagingStudy;
		this.media = media;
		this.conclusion = conclusion;
		this.conclusionCode = conclusionCode;
		this.presentedForm = presentedForm;
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

	public List<String> getBasedOn() {
		return basedOn;
	}

	public void setBasedOn(List<String> basedOn) {
		this.basedOn = basedOn;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<CodeableConcept> getCategory() {
		return category;
	}

	public void setCategory(List<CodeableConcept> category) {
		this.category = category;
	}

	public CodeableConcept getCode() {
		return code;
	}

	public void setCode(CodeableConcept code) {
		this.code = code;
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

	public Date getEffectiveDateTime() {
		return effectiveDateTime;
	}

	public void setEffectiveDateTime(Date effectiveDateTime) {
		this.effectiveDateTime = effectiveDateTime;
	}

	public Period getEffectivePeriod() {
		return effectivePeriod;
	}

	public void setEffectivePeriod(Period effectivePeriod) {
		this.effectivePeriod = effectivePeriod;
	}

	public Date getIssued() {
		return issued;
	}

	public void setIssued(Date issued) {
		this.issued = issued;
	}

	public List<Practitioner> getPerformer() {
		return performer;
	}

	public void setPerformer(List<Practitioner> performer) {
		this.performer = performer;
	}

	public List<Practitioner> getResultsInterpreter() {
		return resultsInterpreter;
	}

	public void setResultsInterpreter(List<Practitioner> resultsInterpreter) {
		this.resultsInterpreter = resultsInterpreter;
	}

	public List<String> getSpecimen() {
		return specimen;
	}

	public void setSpecimen(List<String> specimen) {
		this.specimen = specimen;
	}

	public List<Observation> getResult() {
		return result;
	}

	public void setResult(List<Observation> result) {
		this.result = result;
	}

	public List<String> getImagingStudy() {
		return imagingStudy;
	}

	public void setImagingStudy(List<String> imagingStudy) {
		this.imagingStudy = imagingStudy;
	}

	public List<Media> getMedia() {
		return media;
	}

	public void setMedia(List<Media> media) {
		this.media = media;
	}

	public String getConclusion() {
		return conclusion;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}

	public List<CodeableConcept> getConclusionCode() {
		return conclusionCode;
	}

	public void setConclusionCode(List<CodeableConcept> conclusionCode) {
		this.conclusionCode = conclusionCode;
	}

	public List<Attachment> getPresentedForm() {
		return presentedForm;
	}

	public void setPresentedForm(List<Attachment> presentedForm) {
		this.presentedForm = presentedForm;
	}	
}
