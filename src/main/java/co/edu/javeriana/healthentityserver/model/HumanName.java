package co.edu.javeriana.healthentityserver.model;

public class HumanName {
	private String use; // usual | official | temp | nickname | anonymous | old | maiden
	private String text;
	private String family;
	private String given;
	private String prefix;
	private String suffix;
	private Period period;
	
	public HumanName(String use, String text, String family, String given, String prefix, String suffix,
			Period period) {
		super();
		this.use = use;
		this.text = text;
		this.family = family;
		this.given = given;
		this.prefix = prefix;
		this.suffix = suffix;
		this.period = period;
	}

	public String getUse() {
		return use;
	}

	public void setUse(String use) {
		this.use = use;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getGiven() {
		return given;
	}

	public void setGiven(String given) {
		this.given = given;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}
}
