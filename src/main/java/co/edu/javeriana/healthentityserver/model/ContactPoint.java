package co.edu.javeriana.healthentityserver.model;

public class ContactPoint {
	private String system; // phone | fax | email | pager | url | sms | other
	private String value;
	private String use; //home | work | temp | old | mobile - purpose of this contact point
	private int rank;
	private Period period;
	
	public ContactPoint(String system, String value, String use, int rank, Period period) {
		super();
		this.system = system;
		this.value = value;
		this.use = use;
		this.rank = rank;
		this.period = period;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getUse() {
		return use;
	}

	public void setUse(String use) {
		this.use = use;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}
}
