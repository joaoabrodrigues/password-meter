package com.passwordmeter.meter.deductions;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.passwordmeter.meter.Calculator;

public class ConsecutiveUppercaseLettersDeductionTest {

	private Calculator consecutiveUpper = new ConsecutiveUppercaseLettersDeduction();
	
	@Test
	public void shouldReturnScore0WithEmptyPassword() {
		Integer score = consecutiveUpper.calculate("");
		assertEquals(0, score.intValue());
	}
	
	@Test
	public void shouldReturnScore0WithLowercase() {
		Integer score = consecutiveUpper.calculate("abcdef");
		assertEquals(0, score.intValue());
	}
	
	@Test
	public void shouldReturnScoreMinus10() {
		Integer score = consecutiveUpper.calculate("ABCDEF");
		assertEquals(-10, score.intValue());
	}
	
	@Test
	public void shouldReturnScoreMinus12() {
		Integer score = consecutiveUpper.calculate("ABCDEFeAB");
		assertEquals(-12, score.intValue());
	}
	
	@Test
	public void shouldReturnScoreMinus24() {
		Integer score = consecutiveUpper.calculate("ABCDEFeAB155JQDIOWJ");
		assertEquals(-24, score.intValue());
	}
}
