package com.softeam.converttoarab;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RomanToNumeralConverterTest {
	private RomanToNumeralConverter c = null;
	
	@Before
	public void init() {
		c = new RomanToNumeralConverter();
	}

	@Test
	public void testConvertI() {
		int result = c.convert("I");
		assertEquals(1, result);
	}
	
	@Test
	public void testConvertII() {
		int result = c.convert("II");
		assertEquals(2, result);
	}
	
	@Test
	public void testConvertIII() {
		int result = c.convert("III");
		assertEquals(3, result);
	}
	
	@Test
	public void testConvertV() {
		int result = c.convert("V");
		assertEquals(5, result);
	}
	
	@Test
	public void testConvertX() {
		int result = c.convert("X");
		assertEquals(10, result);
	}
	
	@Test
	public void testConvertL() {
		int result = c.convert("L");
		assertEquals(50, result);
	}
	
	@Test
	public void testConvertXVI() {
		int result = c.convert("XVI");
		assertEquals(16, result);
	}
	
	@Test
	public void testConvertXIV() {
		int result = c.convert("XIV");
		assertEquals(14, result);
	}
	
	@Test
	public void testConvertLXXXIV() {
		int result = c.convert("LXXXIV");
		assertEquals(84, result);
	}
	
	@Test
	public void testConvertMCMLIV() {
		int result = c.convert("MCMLIV");
		assertEquals(1954, result);
	}
	
}
