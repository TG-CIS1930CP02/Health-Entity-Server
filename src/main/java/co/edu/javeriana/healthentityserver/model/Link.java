package co.edu.javeriana.healthentityserver.model;

public class Link {
	private Patient other;
	private String type; // code replaced-by | replaces | refer | seealso
	
	public Link(Patient other, String type) {
		super();
		this.other = other;
		this.type = type;
	}
	
	public Patient getOther() {
		return other;
	}
	
	public void setOther(Patient other) {
		this.other = other;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
}
