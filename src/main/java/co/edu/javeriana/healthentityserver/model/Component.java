package co.edu.javeriana.healthentityserver.model;

import java.util.Date;
import java.util.List;

public class Component {
	private CodeableConcept code;
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
	private List<ReferenceRange> referenceRange;
	
	public Component(CodeableConcept code, Quantity valueQuantity, CodeableConcept valueCodeableConcept,
			String valueString, boolean valueBoolean, int valueInteger, Range valueRange, Ratio valueRatio,
			Date valueTime, Date valueDateTime, Period period, SampledData valueSampledData,
			CodeableConcept dataAbsentReason, List<CodeableConcept> interpretation,
			List<ReferenceRange> referenceRange) {
		super();
		this.code = code;
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
		this.referenceRange = referenceRange;
	}

	public CodeableConcept getCode() {
		return code;
	}

	public void setCode(CodeableConcept code) {
		this.code = code;
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

	public List<ReferenceRange> getReferenceRange() {
		return referenceRange;
	}

	public void setReferenceRange(List<ReferenceRange> referenceRange) {
		this.referenceRange = referenceRange;
	}
}
