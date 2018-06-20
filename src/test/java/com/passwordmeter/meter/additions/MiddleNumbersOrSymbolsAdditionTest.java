package com.passwordmeter.meter.additions;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.passwordmeter.meter.Calculator;

public class MiddleNumbersOrSymbolsAdditionTest {

	private Calculator middleAdd = new MiddleNumbersOrSymbolsAddition();
	
	@Test
	public void shouldReturnScoreZero() {
		Integer score = middleAdd.calculate("");
		assertEquals(0, score.intValue());
	}
	
	@Test
	public void shouldReturnScoreZeroWithSingleDigit() {
		Integer score = middleAdd.calculate("1");
		assertEquals(0, score.intValue());
	}
	
	@Test
	public void shouldReturnScore4WithDigits() {
		Integer score = middleAdd.calculate("1223");
		assertEquals(4, score.intValue());
	}
	
	@Test
	public void shouldReturnScore8WithSymbols() {
		Integer score = middleAdd.calculate("1!@#$3");
		assertEquals(8, score.intValue());
	}
	
	@Test
	public void shouldReturnScore16() {
		Integer score = middleAdd.calculate("1123!@#4$3");
		assertEquals(16, score.intValue());
	}
}
