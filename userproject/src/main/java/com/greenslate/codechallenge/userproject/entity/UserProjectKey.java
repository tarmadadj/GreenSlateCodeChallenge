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
}
