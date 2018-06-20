package com.passwordmeter.meter.deductions;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.passwordmeter.meter.Calculator;

public class ConsecutiveLowercaseLettersDeductionTest {

	private Calculator consecutiveLower = new ConsecutiveLowercaseLettersDeduction();
	
	@Test
	public void shouldReturnScore0WithEmptyPassword() {
		Integer score = consecutiveLower.calculate("");
		assertEquals(0, score.intValue());
	}
	
	@Test
	public void shouldReturnScore0WithUppercase() {
		Integer score = consecutiveLower.calculate("ABCDEF");
		assertEquals(0, score.intValue());
	}
	
	@Test
	public void shouldReturnScoreMinus10() {
		Integer score = consecutiveLower.calculate("abcdef");
		assertEquals(-10, score.intValue());
	}
	
	@Test
	public void shouldReturnScoreMinus12() {
		Integer score = consecutiveLower.calculate("abcdefEab");
		assertEquals(-12, score.intValue());
	}
	
	@Test
	public void shouldReturnScoreMinus24() {
		Integer score = consecutiveLower.calculate("abcdefEab155jqdiowj");
		assertEquals(-24, score.intValue());
	}
}
