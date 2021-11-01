package com.revature.exceptions;
import lombok.NoArgsConstructor;
@NoArgsConstructor
public class TechnologyNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 5526290251533749665L;

	public TechnologyNotFoundException(final String message) {
		super(message);
	}
}
