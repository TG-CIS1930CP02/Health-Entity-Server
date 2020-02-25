package co.edu.javeriana.healthentityserver.model;

import java.util.Date;

public class Annotation {
	private Practitioner authorReference; // 	Reference(Practitioner | Patient | RelatedPerson | Organization)
	private String authorString;
	private Date time;
	private String text; // markdown
	
	public Annotation(Practitioner authorReference, String authorString, Date time, String text) {
		super();
		this.authorReference = authorReference;
		this.authorString = authorString;
		this.time = time;
		this.text = text;
	}

	public Practitioner getAuthorReference() {
		return authorReference;
	}

	public void setAuthorReference(Practitioner authorReference) {
		this.authorReference = authorReference;
	}

	public String getAuthorString() {
		return authorString;
	}

	public void setAuthorString(String authorString) {
		this.authorString = authorString;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
