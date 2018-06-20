package com.passwordmeter.meter.deductions;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.passwordmeter.meter.Calculator;

public class ConsecutiveNumbersDeductionTest {

	private Calculator consecutiveNumber = new ConsecutiveNumbersDeduction();
	
	@Test
	public void shouldReturnScore0WithEmptyPassword() {
		Integer score = consecutiveNumber.calculate("");
		assertEquals(0, score.intValue());
	}
	
	@Test
	public void shouldReturnScore0WithUppercase() {
		Integer score = consecutiveNumber.calculate("ABCDEF");
		assertEquals(0, score.intValue());
	}
	
	@Test
	public void shouldReturnScore0WithLowercase() {
		Integer score = consecutiveNumber.calculate("abcdef");
		assertEquals(0, score.intValue());
	}
	
	@Test
	public void shouldReturnScoreMinus10() {
		Integer score = consecutiveNumber.calculate("123456");
		assertEquals(-10, score.intValue());
	}
	
	@Test
	public void shouldReturnScoreMinus12() {
		Integer score = consecutiveNumber.calculate("123456E12");
		assertEquals(-12, score.intValue());
	}
	
	@Test
	public void shouldReturnScoreMinus24() {
		Integer score = consecutiveNumber.calculate("123456e12qdE1234567");
		assertEquals(-24, score.intValue());
	}
}
