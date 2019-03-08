package com.greenslate.codechallenge.userproject.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
/**
 * This class is used to hold a composite key composed of UserId and ProjectId 
 * It is marked embedable so JPA/Hibernate knows this class isn't supposed to exists in its own right
 * @author mario
 *
 */
@Embeddable
public class UserProjectKey  implements Serializable{
	/**
	 * As this class implements Serializable Interface,  it requires a UUID in order to be serialized, this is made a class level
	 * and isn't need to change for the individual instances
	 */
	private static final long serialVersionUID = 4785461573745508741L;
	/**
	 * User Id of the composite Key, it takes user_id from the user_project table
	 */
	@Column(name = "userId")
    private Long userId;
	/**
	 * Project Id of the composite Key, it takes project_id from the user_project table
	 */
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
