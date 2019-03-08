package com.greenslate.codechallenge.userproject.exception;
/**
 * This class represents the situation when there are no users to be found, i throw exception in the service  so the controller can catch it
 * and return a useful error message
 * @author Mario Segura
 *
 */
public class UserNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5729065331375518024L;
	
	public UserNotFoundException() {
		super("Requested user couldn't be found in the repository");
	}

}
