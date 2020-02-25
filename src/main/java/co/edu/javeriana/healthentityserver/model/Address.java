package co.edu.javeriana.healthentityserver.model;

import java.util.List;

public class Address {
	private String use; // purpose of this address
	private String type; // postal | physical | both
	private String text;
	private List<String> line;
	private String city;
	private String discrict;
	private String state;
	private String postalCode;
	private String country; // Country (e.g. can be ISO 3166 2 or 3 letter code)
	private Period period;
	
	public Address(String use, String type, String text, List<String> line, String city, String discrict, String state,
			String postalCode, String country, Period period) {
		super();
		this.use = use;
		this.type = type;
		this.text = text;
		this.line = line;
		this.city = city;
		this.discrict = discrict;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
		this.period = period;
	}

	public String getUse() {
		return use;
	}

	public void setUse(String use) {
		this.use = use;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<String> getLine() {
		return line;
	}

	public void setLine(List<String> line) {
		this.line = line;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDiscrict() {
		return discrict;
	}

	public void setDiscrict(String discrict) {
		this.discrict = discrict;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}
}
