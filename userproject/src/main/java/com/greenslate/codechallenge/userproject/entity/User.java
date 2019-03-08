package com.greenslate.codechallenge.userproject.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
/**
 * User is also an entity i need to persists so it works pretty much like Project
 * @author Mario Segura
 *
 */
@Entity
public class User {
	@Id @GeneratedValue
    private Long id;
    private @NonNull String firstName;
    private @NonNull String lastName;
    
    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private Set<UserProject> userProjects;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public Set<UserProject> getUserProjects() {
		return userProjects;
	}
	public void setUserProjects(Set<UserProject> userProjects) {
		this.userProjects = userProjects;
	}
	public User(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
    
    public User() {
    	
    }
    
    public boolean equals(Object o) {
    	if(o==null)
    		return false;
    	else {
    		User other = (User)o;
    		return other.getId().equals(this.getId());
    	}
    }
}
