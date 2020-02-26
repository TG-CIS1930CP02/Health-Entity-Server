package co.edu.javeriana.healthentityserver.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;

@Data
@Document(collection = "observation")
public class Observation {
	@Id
	private String id;
	private List<Identifier> identifier;
	private List<String> basedOn; // Reference(CarePlan | ImmunizationRecommendation | MedicationRequest | NutritionOrder | ServiceRequest)
	private List<String> partOf; // Reference(MedicationAdministration | MedicationDispense | MedicationStatement | Procedure | Immunization | ImagingStudy)
	@NonNull
	private String status; // registered | partial | preliminary | final +
	private List<CodeableConcept> category;
	@NonNull
	private CodeableConcept code;
	private Patient subject;
	private String focus; // reference any
	private String encounter; // reference encounter
	private Date effectiveDateTime;
	private Period effectivePeriod;
	private Timing effectiveTiming;
	private Date effectiveInstant;
	private Date issued;
	private List<Practitioner> performer; // Reference(Practitioner | PractitionerRole | Organization | CareTeam)
	private Quantity valueQuantity;
	private CodeableConcept valueCodeableConcept;
	private String valueString;
	private boolean valueBoolean;
	private int valueInteger;
	private Range valueRange;
	private Ratio valueRatio;
	private Date valueTime;
	private Date valueDateTime;
	private Period period;
	private SampledData valueSampledData;
	private CodeableConcept dataAbsentReason;
	private List<CodeableConcept> interpretation;
	private List<Annotation> note;
	private CodeableConcept bodySite;
	private CodeableConcept method;
	private String specimen; // reference specimen
	private String device; // reference device|deviceMetric 
	private List<ReferenceRange> referenceRange;
	private List<Observation> hasMember; //	Reference(Observation | QuestionnaireResponse | MolecularSequence)
	private List<Observation> derivedFrom; // Reference(DocumentReference | ImagingStudy | Media | QuestionnaireResponse | Observation | MolecularSequence)
	private List<Component> component;
	
	public Observation(String id, List<Identifier> identifier, List<String> basedOn, List<String> partOf, String status,
			List<CodeableConcept> category, CodeableConcept code, Patient subject, String focus, String encounter,
			Date effectiveDateTime, Period effectivePeriod, Timing effectiveTiming, Date effectiveInstant, Date issued,
			List<Practitioner> performer, Quantity valueQuantity, CodeableConcept valueCodeableConcept,
			String valueString, boolean valueBoolean, int valueInteger, Range valueRange, Ratio valueRatio,
			Date valueTime, Date valueDateTime, Period period, SampledData valueSampledData,
			CodeableConcept dataAbsentReason, List<CodeableConcept> interpretation, List<Annotation> note,
			CodeableConcept bodySite, CodeableConcept method, String specimen, String device,
			List<ReferenceRange> referenceRange, List<Observation> hasMember, List<Observation> derivedFrom,
			List<Component> component) {
		super();
		this.id = id;
		this.identifier = identifier;
		this.basedOn = basedOn;
		this.partOf = partOf;
		this.status = status;
		this.category = category;
		this.code = code;
		this.subject = subject;
		this.focus = focus;
		this.encounter = encounter;
		this.effectiveDateTime = effectiveDateTime;
		this.effectivePeriod = effectivePeriod;
		this.effectiveTiming = effectiveTiming;
		this.effectiveInstant = effectiveInstant;
		this.issued = issued;
		this.performer = performer;
		this.valueQuantity = valueQuantity;
		this.valueCodeableConcept = valueCodeableConcept;
		this.valueString = valueString;
		this.valueBoolean = valueBoolean;
		this.valueInteger = valueInteger;
		this.valueRange = valueRange;
		this.valueRatio = valueRatio;
		this.valueTime = valueTime;
		this.valueDateTime = valueDateTime;
		this.period = period;
		this.valueSampledData = valueSampledData;
		this.dataAbsentReason = dataAbsentReason;
		this.interpretation = interpretation;
		this.note = note;
		this.bodySite = bodySite;
		this.method = method;
		this.specimen = specimen;
		this.device = device;
		this.referenceRange = referenceRange;
		this.hasMember = hasMember;
		this.derivedFrom = derivedFrom;
		this.component = component;
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

	public String getFocus() {
		return focus;
	}

	public void setFocus(String focus) {
		this.focus = focus;
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

	public Timing getEffectiveTiming() {
		return effectiveTiming;
	}

	public void setEffectiveTiming(Timing effectiveTiming) {
		this.effectiveTiming = effectiveTiming;
	}

	public Date getEffectiveInstant() {
		return effectiveInstant;
	}

	public void setEffectiveInstant(Date effectiveInstant) {
		this.effectiveInstant = effectiveInstant;
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

	public Quantity getValueQuantity() {
		return valueQuantity;
	}

	public void setValueQuantity(Quantity valueQuantity) {
		this.valueQuantity = valueQuantity;
	}

	public CodeableConcept getValueCodeableConcept() {
		return valueCodeableConcept;
	}

	public void setValueCodeableConcept(CodeableConcept valueCodeableConcept) {
		this.valueCodeableConcept = valueCodeableConcept;
	}

	public String getValueString() {
		return valueString;
	}

	public void setValueString(String valueString) {
		this.valueString = valueString;
	}

	public boolean isValueBoolean() {
		return valueBoolean;
	}

	public void setValueBoolean(boolean valueBoolean) {
		this.valueBoolean = valueBoolean;
	}

	public int getValueInteger() {
		return valueInteger;
	}

	public void setValueInteger(int valueInteger) {
		this.valueInteger = valueInteger;
	}

	public Range getValueRange() {
		return valueRange;
	}

	public void setValueRange(Range valueRange) {
		this.valueRange = valueRange;
	}

	public Ratio getValueRatio() {
		return valueRatio;
	}

	public void setValueRatio(Ratio valueRatio) {
		this.valueRatio = valueRatio;
	}

	public Date getValueTime() {
		return valueTime;
	}

	public void setValueTime(Date valueTime) {
		this.valueTime = valueTime;
	}

	public Date getValueDateTime() {
		return valueDateTime;
	}

	public void setValueDateTime(Date valueDateTime) {
		this.valueDateTime = valueDateTime;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public SampledData getValueSampledData() {
		return valueSampledData;
	}

	public void setValueSampledData(SampledData valueSampledData) {
		this.valueSampledData = valueSampledData;
	}

	public CodeableConcept getDataAbsentReason() {
		return dataAbsentReason;
	}

	public void setDataAbsentReason(CodeableConcept dataAbsentReason) {
		this.dataAbsentReason = dataAbsentReason;
	}

	public List<CodeableConcept> getInterpretation() {
		return interpretation;
	}

	public void setInterpretation(List<CodeableConcept> interpretation) {
		this.interpretation = interpretation;
	}

	public List<Annotation> getNote() {
		return note;
	}

	public void setNote(List<Annotation> note) {
		this.note = note;
	}

	public CodeableConcept getBodySite() {
		return bodySite;
	}

	public void setBodySite(CodeableConcept bodySite) {
		this.bodySite = bodySite;
	}

	public CodeableConcept getMethod() {
		return method;
	}

	public void setMethod(CodeableConcept method) {
		this.method = method;
	}

	public String getSpecimen() {
		return specimen;
	}

	public void setSpecimen(String specimen) {
		this.specimen = specimen;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public List<ReferenceRange> getReferenceRange() {
		return referenceRange;
	}

	public void setReferenceRange(List<ReferenceRange> referenceRange) {
		this.referenceRange = referenceRange;
	}

	public List<Observation> getHasMember() {
		return hasMember;
	}

	public void setHasMember(List<Observation> hasMember) {
		this.hasMember = hasMember;
	}

	public List<Observation> getDerivedFrom() {
		return derivedFrom;
	}

	public void setDerivedFrom(List<Observation> derivedFrom) {
		this.derivedFrom = derivedFrom;
	}

	public List<Component> getComponent() {
		return component;
	}

	public void setComponent(List<Component> component) {
		this.component = component;
	}
}
