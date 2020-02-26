package co.edu.javeriana.healthentityserver.model;

import java.net.URI;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;

@Data
@Document(collection = "procedure")
public class Procedure {
	@Id
	private String id;
	private List<Identifier> identifier;
	private List<String> instantiatesCanonical; // canonical(PlanDefinition | ActivityDefinition | Measure | OperationDefinition | Questionnaire)
	private List<URI> instantiatesUri;
	private List<String> basedOn; // Reference(CarePlan | ServiceRequest)mmunizationRecommendation  | ServiceRequest)
	private List<String> partOf; // Reference(Procedure | Observation | MedicationAdministration)	Part of referenced event
	@NonNull
	private String status; // preparation | in-progress | not-done | on-hold | stopped | completed | entered-in-error | unknown
	private CodeableConcept statusReason;
	private CodeableConcept category;
	private CodeableConcept code;
	@NonNull
	private Patient subject;
	private String encounter; // reference encounter
	private Date performedDateTime;	
	private Period performedPeriod;	
	private String performedString;	
	private int performedAge;	
	private Range performedRange;
	private Practitioner recorder; // Reference(Patient | RelatedPerson | Practitioner | PractitionerRole)
	private Practitioner asserter; // Reference(Patient | RelatedPerson | Practitioner | PractitionerRole)
	private List<Performer> performer;
	private String location; // Reference(Location)
	private List<CodeableConcept> reasonCode;
	private List<Observation> reasonReference; // Reference(Condition | Observation | Procedure | DiagnosticReport | DocumentReference)
	private List<CodeableConcept> bodySite;
	private CodeableConcept outcome;
	private List<DiagnosticReport> report; // Reference(DiagnosticReport | DocumentReference | Composition)
	private List<CodeableConcept> complication;
	private List<Condition> complicationDetail;
	private List<CodeableConcept> followUp;
	private List<Annotation> node;
	private List<FocalDevice> focalDevice;
	private List<String> usedReference; // Reference(Device | Medication | Substance)
	private List<CodeableConcept> usedCode;
	
	public Procedure(String id, List<Identifier> identifier, List<String> instantiatesCanonical,
			List<URI> instantiatesUri, List<String> basedOn, List<String> partOf, String status,
			CodeableConcept statusReason, CodeableConcept category, CodeableConcept code, Patient subject,
			String encounter, Date performedDateTime, Period performedPeriod, String performedString, int performedAge,
			Range performedRange, Practitioner recorder, Practitioner asserter, List<Performer> performer,
			String location, List<CodeableConcept> reasonCode, List<Observation> reasonReference,
			List<CodeableConcept> bodySite, CodeableConcept outcome, List<DiagnosticReport> report,
			List<CodeableConcept> complication, List<Condition> complicationDetail, List<CodeableConcept> followUp,
			List<Annotation> node, List<FocalDevice> focalDevice, List<String> usedReference,
			List<CodeableConcept> usedCode) {
		super();
		this.id = id;
		this.identifier = identifier;
		this.instantiatesCanonical = instantiatesCanonical;
		this.instantiatesUri = instantiatesUri;
		this.basedOn = basedOn;
		this.partOf = partOf;
		this.status = status;
		this.statusReason = statusReason;
		this.category = category;
		this.code = code;
		this.subject = subject;
		this.encounter = encounter;
		this.performedDateTime = performedDateTime;
		this.performedPeriod = performedPeriod;
		this.performedString = performedString;
		this.performedAge = performedAge;
		this.performedRange = performedRange;
		this.recorder = recorder;
		this.asserter = asserter;
		this.performer = performer;
		this.location = location;
		this.reasonCode = reasonCode;
		this.reasonReference = reasonReference;
		this.bodySite = bodySite;
		this.outcome = outcome;
		this.report = report;
		this.complication = complication;
		this.complicationDetail = complicationDetail;
		this.followUp = followUp;
		this.node = node;
		this.focalDevice = focalDevice;
		this.usedReference = usedReference;
		this.usedCode = usedCode;
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

	public List<String> getInstantiatesCanonical() {
		return instantiatesCanonical;
	}

	public void setInstantiatesCanonical(List<String> instantiatesCanonical) {
		this.instantiatesCanonical = instantiatesCanonical;
	}

	public List<URI> getInstantiatesUri() {
		return instantiatesUri;
	}

	public void setInstantiatesUri(List<URI> instantiatesUri) {
		this.instantiatesUri = instantiatesUri;
	}

	public List<String> getBasedOn() {
		return basedOn;
	}

	public void setBasedOn(List<String> basedOn) {
		this.basedOn = basedOn;
	}

	public List<String> getPartOf() {
		return partOf;
	}

	public void setPartOf(List<String> partOf) {
		this.partOf = partOf;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CodeableConcept getStatusReason() {
		return statusReason;
	}

	public void setStatusReason(CodeableConcept statusReason) {
		this.statusReason = statusReason;
	}

	public CodeableConcept getCategory() {
		return category;
	}

	public void setCategory(CodeableConcept category) {
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

	public Date getPerformedDateTime() {
		return performedDateTime;
	}

	public void setPerformedDateTime(Date performedDateTime) {
		this.performedDateTime = performedDateTime;
	}

	public Period getPerformedPeriod() {
		return performedPeriod;
	}

	public void setPerformedPeriod(Period performedPeriod) {
		this.performedPeriod = performedPeriod;
	}

	public String getPerformedString() {
		return performedString;
	}

	public void setPerformedString(String performedString) {
		this.performedString = performedString;
	}

	public int getPerformedAge() {
		return performedAge;
	}

	public void setPerformedAge(int performedAge) {
		this.performedAge = performedAge;
	}

	public Range getPerformedRange() {
		return performedRange;
	}

	public void setPerformedRange(Range performedRange) {
		this.performedRange = performedRange;
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

	public List<Performer> getPerformer() {
		return performer;
	}

	public void setPerformer(List<Performer> performer) {
		this.performer = performer;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<CodeableConcept> getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(List<CodeableConcept> reasonCode) {
		this.reasonCode = reasonCode;
	}

	public List<Observation> getReasonReference() {
		return reasonReference;
	}

	public void setReasonReference(List<Observation> reasonReference) {
		this.reasonReference = reasonReference;
	}

	public List<CodeableConcept> getBodySite() {
		return bodySite;
	}

	public void setBodySite(List<CodeableConcept> bodySite) {
		this.bodySite = bodySite;
	}

	public CodeableConcept getOutcome() {
		return outcome;
	}

	public void setOutcome(CodeableConcept outcome) {
		this.outcome = outcome;
	}

	public List<DiagnosticReport> getReport() {
		return report;
	}

	public void setReport(List<DiagnosticReport> report) {
		this.report = report;
	}

	public List<CodeableConcept> getComplication() {
		return complication;
	}

	public void setComplication(List<CodeableConcept> complication) {
		this.complication = complication;
	}

	public List<Condition> getComplicationDetail() {
		return complicationDetail;
	}

	public void setComplicationDetail(List<Condition> complicationDetail) {
		this.complicationDetail = complicationDetail;
	}

	public List<CodeableConcept> getFollowUp() {
		return followUp;
	}

	public void setFollowUp(List<CodeableConcept> followUp) {
		this.followUp = followUp;
	}

	public List<Annotation> getNode() {
		return node;
	}

	public void setNode(List<Annotation> node) {
		this.node = node;
	}

	public List<FocalDevice> getFocalDevice() {
		return focalDevice;
	}

	public void setFocalDevice(List<FocalDevice> focalDevice) {
		this.focalDevice = focalDevice;
	}

	public List<String> getUsedReference() {
		return usedReference;
	}

	public void setUsedReference(List<String> usedReference) {
		this.usedReference = usedReference;
	}

	public List<CodeableConcept> getUsedCode() {
		return usedCode;
	}

	public void setUsedCode(List<CodeableConcept> usedCode) {
		this.usedCode = usedCode;
	}
}
