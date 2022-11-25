package org.qritrim.qivrtrack.model;

import lombok.Data;

@Data
public class KeycloakUser {
	private String id;
	private String email;
	private String firstName;
	private String username;
	private Boolean enabled;
	private KeycloakCredentials credentials;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public KeycloakCredentials getCredentials() {
		return credentials;
	}
	public void setCredentials(KeycloakCredentials credentials) {
		this.credentials = credentials;
	}
	
}
