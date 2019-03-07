package com.greenslate.codechallenge.userproject.entity;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class UserProject {
	
	 @EmbeddedId
	 @JsonIgnore
	 private UserProjectKey id;
	 @ManyToOne
	 @MapsId("userId")
	 @JoinColumn(name = "userId")
	 @JsonManagedReference
	 private @NonNull User user;
	 
	 @ManyToOne
	 @MapsId("projectId")
	 @JsonManagedReference
	 @JoinColumn(name = "projectId")
	 private @NonNull Project project;
	 
	 private @NonNull boolean isActive;
	 
	 private @NonNull Date assignedDate;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(Date assignedDate) {
		this.assignedDate = assignedDate;
	}

	public UserProjectKey getId() {
		return id;
	}

	public void setId(UserProjectKey id) {
		this.id = id;
	}
	 
	 
}
