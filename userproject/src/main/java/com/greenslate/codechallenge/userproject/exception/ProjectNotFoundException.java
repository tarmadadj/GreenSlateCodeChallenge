package com.greenslate.codechallenge.userproject.exception;

public class ProjectNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6960092396557434346L;
	
	public ProjectNotFoundException() {
		super("Requested project couldn't be found in the repository");
	}

}
