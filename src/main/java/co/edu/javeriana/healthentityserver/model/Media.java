package co.edu.javeriana.healthentityserver.model;

public class Media {
	private String comment;
	private String link; // reference media
	
	public Media(String comment, String link) {
		super();
		this.comment = comment;
		this.link = link;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
}
