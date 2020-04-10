package co.edu.javeriana.healthentityserver.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("serverIdentification")
public class ServerIdentification {
	@Value("${role.health.entity}")
	private String roleHealthEntity;

	public String getRoleHealthEntity() {
		return roleHealthEntity;
	}
}
