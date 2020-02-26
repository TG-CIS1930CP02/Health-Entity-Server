package co.edu.javeriana.healthentityserver.model;

import java.net.URI;

public class Quantity {
	private float value;
	private String compatator;
	private String unit;
	private URI system;
	private String code;
	
	public Quantity(float value, String compatator, String unit, URI system, String code) {
		super();
		this.value = value;
		this.compatator = compatator;
		this.unit = unit;
		this.system = system;
		this.code = code;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public String getCompatator() {
		return compatator;
	}

	public void setCompatator(String compatator) {
		this.compatator = compatator;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public URI getSystem() {
		return system;
	}

	public void setSystem(URI system) {
		this.system = system;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
