package com.passwordmeter.meter.deductions;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.passwordmeter.meter.Calculator;

public class SequentialNumbersDeductionTest {
	
	private Calculator seqNumbers = new SequentialNumbersDeduction();
	
	@Test
	public void shouldReturnZeroWithEmptyString() {
		Integer score = seqNumbers.calculate("");
		assertEquals(0, score.intValue());
	}
	
	@Test
	public void shouldReturnZeroWithLetters() {
		Integer score = seqNumbers.calculate("abcdef");
		assertEquals(0, score.intValue());
	}
	
	@Test
	public void shouldReturnMinus3() {
		Integer score = seqNumbers.calculate("123");
		assertEquals(-3, score.intValue());
	}
	
	@Test
	public void shouldReturnMinus6() {
		Integer score = seqNumbers.calculate("1234");
		assertEquals(-6, score.intValue());
	}
	
	@Test
	public void shouldReturnMinus12() {
		Integer score = seqNumbers.calculate("123456");
		assertEquals(-12, score.intValue());
	}
	
	@Test
	public void shouldReturnScoreMinus12() {
		Integer score = seqNumbers.calculate("123456E12");
		assertEquals(-12, score.intValue());
	}
	
	@Test
	public void shouldReturnMinus15() {
		Integer score = seqNumbers.calculate("1234e1234567");
		assertEquals(-15, score.intValue());
	}
}
