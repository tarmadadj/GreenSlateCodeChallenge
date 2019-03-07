package com.greenslate.codechallenge.userproject.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
public class Project {
	@Id @GeneratedValue
    private Long id;
    private @NonNull Date startDate;
    private @NonNull Date endDate;
    private @NonNull int credits;
    
    @OneToMany(mappedBy = "project")
    @JsonBackReference
    private Set<UserProject> userProjects;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public Set<UserProject> getUserProjects() {
		return userProjects;
	}
	public void setUserProjects(Set<UserProject> userProjects) {
		this.userProjects = userProjects;
	}
	public Project( Date startDate, Date endDate, int credits) {
		super();
		
		this.startDate = startDate;
		this.endDate = endDate;
		this.credits = credits;
	}
	public Project() {
		
	}
    
	 public boolean equals(Object o) {
	    	if(o==null)
	    		return false;
	    	else {
	    		Project other = (Project)o;
	    		return other.getId().equals(this.getId());
	    	}
	    }
}
