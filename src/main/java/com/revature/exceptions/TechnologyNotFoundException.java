package com.revature.exceptions;
import lombok.NoArgsConstructor;
@NoArgsConstructor
public class TechnologyNotFoundException extends RuntimeException{
	public TechnologyNotFoundException(String message) {
		super(message);
	}
}
