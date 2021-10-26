package com.revature.exceptions;
import lombok.NoArgsConstructor;
@NoArgsConstructor
public class TechnologyNotFoundException extends RuntimeException{
	/*
	 * exception that is called when input Technology cannot be found
	 */
	public TechnologyNotFoundException(String message) {
		super(message);
	}
}
