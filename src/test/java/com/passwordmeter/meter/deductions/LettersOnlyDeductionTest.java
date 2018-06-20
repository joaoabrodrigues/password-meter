package com.passwordmeter.meter.deductions;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.passwordmeter.meter.Calculator;

public class LettersOnlyDeductionTest {

	private Calculator lettersOnly = new LettersOnlyDeduction();
	
	@Test
	public void shouldReturnZeroScore() {
		Integer score = lettersOnly.calculate("");
		assertEquals(0, score.intValue());
	}
	
	@Test
	public void shouldReturnZeroScoreWithLetters() {
		Integer score = lettersOnly.calculate("123123");
		assertEquals(0, score.intValue());
	}
	
	@Test
	public void shouldReturnScore4() {
		Integer score = lettersOnly.calculate("ABCD");
		assertEquals(-4, score.intValue());
	}
	
	@Test
	public void shouldReturnScore8() {
		Integer score = lettersOnly.calculate("afQokDmu");
		assertEquals(-8, score.intValue());
	}
	
	@Test
	public void shouldReturnScore16() {
		Integer score = lettersOnly.calculate("qwepOIyutdghadbc");
		assertEquals(-16, score.intValue());
	}
}
