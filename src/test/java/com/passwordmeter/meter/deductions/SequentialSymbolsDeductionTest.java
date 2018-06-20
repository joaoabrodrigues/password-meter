package com.passwordmeter.meter.deductions;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.passwordmeter.meter.Calculator;

public class SequentialSymbolsDeductionTest {
	
	private Calculator seqSymbols = new SequentialSymbolsDeduction();

	@Test
	public void shouldReturnZeroWithEmptyString() {
		Integer score = seqSymbols.calculate("");
		assertEquals(0, score.intValue());
	}
	
	@Test
	public void shouldReturnZeroWithNumbers() {
		Integer score = seqSymbols.calculate("123456");
		assertEquals(0, score.intValue());
	}
	
	@Test
	public void shouldReturnZeroWithLetters() {
		Integer score = seqSymbols.calculate("abcdef");
		assertEquals(0, score.intValue());
	}
	
	@Test
	public void shouldReturnMinus3() {
		Integer score = seqSymbols.calculate("!@#");
		assertEquals(-3, score.intValue());
	}
	
	@Test
	public void shouldReturnMinus6() {
		Integer score = seqSymbols.calculate("!@#$");
		assertEquals(-6, score.intValue());
	}
	
	@Test
	public void shouldReturnMinus24() {
		Integer score = seqSymbols.calculate(")!@#$%^&*()");
		assertEquals(-24, score.intValue());
	}
	
	@Test
	public void shouldReturnMinus15() {
		Integer score = seqSymbols.calculate("!@#e!@#$%^&");
		assertEquals(-15, score.intValue());
	}
}