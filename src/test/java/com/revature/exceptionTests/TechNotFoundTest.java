package com.revature.exceptionTests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.exceptions.TechnologyNotFoundException;

@SpringBootTest(classes = TechnologyNotFoundException.class)
public class TechNotFoundTest {

	@Test
	public void whenExceptionThrown_thenAssertionSucceeds() {
	    Exception exception = assertThrows(TechnologyNotFoundException.class, () -> {
	        Integer.parseInt("1a");
	    });

	    String expectedMessage = "For input string";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
	}
}
