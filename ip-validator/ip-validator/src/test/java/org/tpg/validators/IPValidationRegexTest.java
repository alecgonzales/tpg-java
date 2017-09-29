package org.tpg.validators;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IPValidationRegexTest {
	IPValidationRegex ipValidator;

	@Before
	public void setup() throws Exception {
		ipValidator = new IPValidationRegex();
	}
	
	@Test
	public void testValidate_WhenNull() throws Exception {
		boolean result = ipValidator.validate(null);
		
		assertFalse(result);
	}
	
	@Test
	public void testValidate_WhenInvalid() throws Exception {
		boolean result = ipValidator.validate("A.B.C.D");
		
		assertFalse(result);		
	}
	
	@Test
	public void testValidate_WhenValid() throws Exception {
		boolean result = ipValidator.validate("127.0.0.1");
		
		assertTrue(result);		
	}
	
	@Test
	public void testValidate_WhenAbove255() throws Exception {
		boolean result = ipValidator.validate("256.0.0.1");
		
		assertFalse(result);		
	}
	
	@Test
	public void testValidate_WhenNot4Values() throws Exception {
		boolean result = ipValidator.validate("1");
		
		assertFalse(result);		
	}
	
	@Test
	public void testValidate_WhenMixedNumberAndChar() throws Exception {
		boolean result = ipValidator.validate("127.0.0.A");
		
		assertFalse(result);		
	}
	
	@Test
	public void testValidate_WhenNegative() throws Exception {
		boolean result = ipValidator.validate("127.-1.0.1");
		
		assertFalse(result);		
	}
	
	@Test
	public void testValidate_WhenTrailingZeroes() throws Exception {
		boolean result = ipValidator.validate("127.001.0.1");
		
		assertTrue(result);		
	}
}
