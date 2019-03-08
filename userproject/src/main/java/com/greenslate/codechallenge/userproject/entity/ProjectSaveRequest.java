package com.greenslate.codechallenge.userproject.entity;

import java.util.Date;
/**
 * A little Plain Object class which maps new projects without being connected to the database
 * it helps to have more control of which calls to save are for creating or updating
 * @author Mario Segura 
 *
 */
public class ProjectSaveRequest {
	private Date startDate;
	private Date endDate;
	private int credits;
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
	
	
	
}
