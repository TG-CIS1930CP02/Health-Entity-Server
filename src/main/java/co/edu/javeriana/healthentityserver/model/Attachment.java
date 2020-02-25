package co.edu.javeriana.healthentityserver.model;

import java.net.URL;
import java.util.Date;

public class Attachment {
	private String contentType; // code
	private String language; // code
	private byte[] data;
	private URL url;
	private int size;
	private byte[] hash;
	private String title;
	private Date creation;
	
	public Attachment(String contentType, String language, byte[] data, URL url, int size, byte[] hash, String title,
			Date creation) {
		super();
		this.contentType = contentType;
		this.language = language;
		this.data = data;
		this.url = url;
		this.size = size;
		this.hash = hash;
		this.title = title;
		this.creation = creation;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public byte[] getHash() {
		return hash;
	}

	public void setHash(byte[] hash) {
		this.hash = hash;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreation() {
		return creation;
	}

	public void setCreation(Date creation) {
		this.creation = creation;
	}
}
