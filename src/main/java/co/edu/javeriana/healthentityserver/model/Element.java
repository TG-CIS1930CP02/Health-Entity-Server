package co.edu.javeriana.healthentityserver.model;

import java.util.Date;
import java.util.List;

public class Element {
	private float boundsDuration;
	private Range boundsRange;
	private Period boundsPeriod;
	private int count;
	private int countMax;
	private float duration;
	private float durationMax;
	private String durationUnit;
	private int frequency;
	private int frequencyMax;
	private float period;
	private float periodMax;
	private String periodUnit;
	private List<String> dayOfWeek;
	private List<Date> timeOfDay;
	private List<String> when;
	private int offset;
	
	public Element(float boundsDuration, Range boundsRange, Period boundsPeriod, int count, int countMax,
			float duration, float durationMax, String durationUnit, int frequency, int frequencyMax, float period,
			float periodMax, String periodUnit, List<String> dayOfWeek, List<Date> timeOfDay, List<String> when,
			int offset) {
		super();
		this.boundsDuration = boundsDuration;
		this.boundsRange = boundsRange;
		this.boundsPeriod = boundsPeriod;
		this.count = count;
		this.countMax = countMax;
		this.duration = duration;
		this.durationMax = durationMax;
		this.durationUnit = durationUnit;
		this.frequency = frequency;
		this.frequencyMax = frequencyMax;
		this.period = period;
		this.periodMax = periodMax;
		this.periodUnit = periodUnit;
		this.dayOfWeek = dayOfWeek;
		this.timeOfDay = timeOfDay;
		this.when = when;
		this.offset = offset;
	}

	public float getBoundsDuration() {
		return boundsDuration;
	}

	public void setBoundsDuration(float boundsDuration) {
		this.boundsDuration = boundsDuration;
	}

	public Range getBoundsRange() {
		return boundsRange;
	}

	public void setBoundsRange(Range boundsRange) {
		this.boundsRange = boundsRange;
	}

	public Period getBoundsPeriod() {
		return boundsPeriod;
	}

	public void setBoundsPeriod(Period boundsPeriod) {
		this.boundsPeriod = boundsPeriod;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCountMax() {
		return countMax;
	}

	public void setCountMax(int countMax) {
		this.countMax = countMax;
	}

	public float getDuration() {
		return duration;
	}

	public void setDuration(float duration) {
		this.duration = duration;
	}

	public float getDurationMax() {
		return durationMax;
	}

	public void setDurationMax(float durationMax) {
		this.durationMax = durationMax;
	}

	public String getDurationUnit() {
		return durationUnit;
	}

	public void setDurationUnit(String durationUnit) {
		this.durationUnit = durationUnit;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public int getFrequencyMax() {
		return frequencyMax;
	}

	public void setFrequencyMax(int frequencyMax) {
		this.frequencyMax = frequencyMax;
	}

	public float getPeriod() {
		return period;
	}

	public void setPeriod(float period) {
		this.period = period;
	}

	public float getPeriodMax() {
		return periodMax;
	}

	public void setPeriodMax(float periodMax) {
		this.periodMax = periodMax;
	}

	public String getPeriodUnit() {
		return periodUnit;
	}

	public void setPeriodUnit(String periodUnit) {
		this.periodUnit = periodUnit;
	}

	public List<String> getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(List<String> dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public List<Date> getTimeOfDay() {
		return timeOfDay;
	}

	public void setTimeOfDay(List<Date> timeOfDay) {
		this.timeOfDay = timeOfDay;
	}

	public List<String> getWhen() {
		return when;
	}

	public void setWhen(List<String> when) {
		this.when = when;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}
}
