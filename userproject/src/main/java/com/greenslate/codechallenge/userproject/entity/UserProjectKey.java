package com.greenslate.codechallenge.userproject.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserProjectKey  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4785461573745508741L;

	@Column(name = "userId")
    private Long userId;
	
	@Column(name = "projectId")
    private Long projectId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public UserProjectKey(Long userId, Long projectId) {
		super();
		this.userId = userId;
		this.projectId = projectId;
	}
	
	public UserProjectKey() {}
}
