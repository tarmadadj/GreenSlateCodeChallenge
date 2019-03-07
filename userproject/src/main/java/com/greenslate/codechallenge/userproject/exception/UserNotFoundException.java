package com.greenslate.codechallenge.userproject.exception;

public class UserNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5729065331375518024L;
	
	public UserNotFoundException() {
		super("Requested user couldn't be found in the repository");
	}

}
