package org.qritrim.qivrtrack.model;

import java.util.ArrayList;

public class keyCloakUserinfo {
	String sub;
	String email_verified;
	String preferred_username;
	String[] Groups;
	String email;
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public String getEmail_verified() {
		return email_verified;
	}
	public void setEmail_verified(String email_verified) {
		this.email_verified = email_verified;
	}
	public String getPreferred_username() {
		return preferred_username;
	}
	public void setPreferred_username(String preferred_username) {
		this.preferred_username = preferred_username;
	}	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String[] getGroups() {
		return Groups;
	}
	public void setGroups(String[] groups) {
		Groups = groups;
	}
	
	

    
}
