package com.passwordmeter.meter.deductions;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.passwordmeter.meter.Calculator;

public class SequentialLettersDeductionTest {

	private Calculator seqLetter = new SequentialLettersDeduction();
	
	@Test
	public void shouldReturnZeroWithEmptyString() {
		Integer score = seqLetter.calculate("");
		assertEquals(0, score.intValue());
	}
	
	@Test
	public void shouldReturnZeroWithNumbers() {
		Integer score = seqLetter.calculate("123456");
		assertEquals(0, score.intValue());
	}
	
	@Test
	public void shouldReturnMinus3() {
		Integer score = seqLetter.calculate("abc");
		assertEquals(-3, score.intValue());
	}
	
	@Test
	public void shouldReturnMinus6() {
		Integer score = seqLetter.calculate("abcd");
		assertEquals(-6, score.intValue());
	}
	
	@Test
	public void shouldReturnMinus12() {
		Integer score = seqLetter.calculate("abcdef");
		assertEquals(-12, score.intValue());
	}
	
	@Test
	public void shouldReturnMinus15() {
		Integer score = seqLetter.calculate("abcd4abcdefg");
		assertEquals(-15, score.intValue());
	}
}
