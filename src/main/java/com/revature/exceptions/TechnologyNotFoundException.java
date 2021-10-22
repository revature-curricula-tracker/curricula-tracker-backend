package com.revature.exceptions;
import lombok.NoArgsConstructor;
@NoArgsConstructor
public class TechnologyNotFoundException extends RuntimeException{
	public TechnologyNotFoundException(String message) {
		super(message);
	}

	public TechnologyNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public TechnologyNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public TechnologyNotFoundException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
}
