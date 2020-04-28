package co.edu.javeriana.healthentityserver.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("serverIdentification")
public class ServerIdentification {	
	@Value("${server.protocol}")
	private String serverProtocol;
	
	@Value("${role.health.entity}")
	private String roleHealthEntity;
	
	@Value("${server.address}")
	private String serverAddress;
	
	@Value("${server.port}")
	private String serverPort;

	public String getRoleHealthEntity() {
		return roleHealthEntity;
	}

	public String getServerAddress() {
		return serverAddress;
	}

	public String getServerPort() {
		return serverPort;
	}
	
	public String getServerProtocol() {
		return serverProtocol;
	}

	public String getServerUrl() {
		return serverProtocol + "://" + serverAddress + ":" + serverPort + "/";
	}
}
