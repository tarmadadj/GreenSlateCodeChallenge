package com.greenslate.codechallenge.userproject.exception;
/**
 * This class represents the situation when there are no projects to be found, i throw exception in the service  so the controller can catch it
 * and return a useful error message
 * @author Mario Segura
 *
 */
public class ProjectNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6960092396557434346L;
	
	public ProjectNotFoundException() {
		super("Requested project couldn't be found in the repository");
	}

}
