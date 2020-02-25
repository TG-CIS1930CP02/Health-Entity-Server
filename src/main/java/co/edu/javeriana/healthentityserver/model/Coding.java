package co.edu.javeriana.healthentityserver.model;

import java.net.URI;

public class Coding{
	private URI uri;
	private String version;
	private String code;
	private String display;
	private boolean userSelected;
	
	public Coding(URI uri, String version, String code, String display, boolean userSelected) {
		super();
		this.uri = uri;
		this.version = version;
		this.code = code;
		this.display = display;
		this.userSelected = userSelected;
	}

	public URI getUri() {
		return uri;
	}

	public void setUri(URI uri) {
		this.uri = uri;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public boolean isUserSelected() {
		return userSelected;
	}

	public void setUserSelected(boolean userSelected) {
		this.userSelected = userSelected;
	}
}
