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
/**
 * UserProject is the class in charge of the Project-User Many-to-Many relationship, it has both references to User and Project
 * it also has important data about the state of this relationship, so it needs to have its own persistence strategy
 * @author Mario Segura
 *
 */
@Entity
public class UserProject {
	/**
	 * The table user_project doesn't have any specified id so i need to create a composite key in order to persists this entity
	 * I did in a very simple fashion for this exercise creating a class representing this key
	 * Also as i don need this key in order to perform operations i decided to ignore it in order to avoid confusion
	 */
	 @EmbeddedId
	 @JsonIgnore
	 private UserProjectKey id;
	 /**
	  * Many-to-One tells JPA/Hibernate that this object represents a User in a Users-Projects relationship, i also tell what
	  * field of the composite key to use for this relationship.
	  * We also make explicit that we are going to use userId as join column in this relationship
	  * Finally we tell the Spring JSON serializer that we want to show this side of the relationship as we are interested in showing the user
	  * when we return this object
	  */
	 @ManyToOne
	 @MapsId("userId")
	 @JoinColumn(name = "userId")
	 @JsonManagedReference
	 private @NonNull User user;
	 /**
	  * This works pretty much the same as the user field but for Project side of the Many-to-Many relationship
	  */
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

	public UserProject(User user, Project project, boolean isActive, Date assignedDate) {
		super();
		this.user = user;
		this.project = project;
		this.isActive = isActive;
		this.assignedDate = assignedDate;
	}
	 
	public UserProject() {} 
}
