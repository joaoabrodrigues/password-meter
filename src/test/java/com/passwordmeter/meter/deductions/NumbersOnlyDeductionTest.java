package com.passwordmeter.meter.deductions;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.passwordmeter.meter.Calculator;

public class NumbersOnlyDeductionTest {

	private Calculator numbersOnly = new NumbersOnlyDeduction();
	
	@Test
	public void shouldReturnZeroScore() {
		Integer score = numbersOnly.calculate("");
		assertEquals(0, score.intValue());
	}
	
	@Test
	public void shouldReturnZeroScoreWithLetters() {
		Integer score = numbersOnly.calculate("asdasd");
		assertEquals(0, score.intValue());
	}
	
	@Test
	public void shouldReturnScore4() {
		Integer score = numbersOnly.calculate("1234");
		assertEquals(-4, score.intValue());
	}
	
	@Test
	public void shouldReturnScore8() {
		Integer score = numbersOnly.calculate("12341234");
		assertEquals(-8, score.intValue());
	}
	
	@Test
	public void shouldReturnScore16() {
		Integer score = numbersOnly.calculate("1234123456781234");
		assertEquals(-16, score.intValue());
	}

}
