package co.edu.javeriana.healthentityserver.model;

public class SampledData {
	private int origin;
	private float period;
	private float factor;
	private float lowerLimit;
	private float upperLimit;
	private int dimensions;
	private String data;
	
	public SampledData(int origin, float period, float factor, float lowerLimit, float upperLimit, int dimensions,
			String data) {
		super();
		this.origin = origin;
		this.period = period;
		this.factor = factor;
		this.lowerLimit = lowerLimit;
		this.upperLimit = upperLimit;
		this.dimensions = dimensions;
		this.data = data;
	}

	public int getOrigin() {
		return origin;
	}

	public void setOrigin(int origin) {
		this.origin = origin;
	}

	public float getPeriod() {
		return period;
	}

	public void setPeriod(float period) {
		this.period = period;
	}

	public float getFactor() {
		return factor;
	}

	public void setFactor(float factor) {
		this.factor = factor;
	}

	public float getLowerLimit() {
		return lowerLimit;
	}

	public void setLowerLimit(float lowerLimit) {
		this.lowerLimit = lowerLimit;
	}

	public float getUpperLimit() {
		return upperLimit;
	}

	public void setUpperLimit(float upperLimit) {
		this.upperLimit = upperLimit;
	}

	public int getDimensions() {
		return dimensions;
	}

	public void setDimensions(int dimensions) {
		this.dimensions = dimensions;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
