package com.greenslate.codechallenge.userproject.entity;
/**
 * A Plain Object i use to map save user requests
 * @author Mario Segura
 *
 */
public class UserSaveRequest {
	private String firstName;
	private String lastName;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
