package com.passwordmeter.meter.additions;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.passwordmeter.meter.Calculator;

public class LowercaseLettersAdditionTest {
	
	private Calculator lowercaseAddition = new LowercaseLettersAddition();

	@Test
	public void shouldReturnZero() {
		Integer score = lowercaseAddition.calculate("abcdef");
		assertEquals(0, score.intValue());
	}
	
	@Test
	public void shouldReturn2() {
		Integer score = lowercaseAddition.calculate("abcdefG");
		assertEquals(2, score.intValue());
	}
	
	@Test
	public void shouldReturn6() {
		Integer score = lowercaseAddition.calculate("abcdefG21");
		assertEquals(6, score.intValue());
	}
	
	@Test
	public void shouldReturn14() {
		Integer score = lowercaseAddition.calculate("Avasdd1827DscaC");
		assertEquals(14, score.intValue());
	}
}
