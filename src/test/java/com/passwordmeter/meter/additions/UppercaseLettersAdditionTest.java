package com.passwordmeter.meter.additions;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.passwordmeter.meter.Calculator;

public class UppercaseLettersAdditionTest {
	
	private Calculator uppercaseAdd = new UppercaseLettersAddition();

	@Test
	public void shouldReturnZeroWithUppercase() {
		Integer score = uppercaseAdd.calculate("ABCDEF");
		assertEquals(0, score.intValue());
	}
	
	@Test
	public void shouldReturnZero() {
		Integer score = uppercaseAdd.calculate("abcdef");
		assertEquals(0, score.intValue());
	}
	
	@Test
	public void shouldReturn12() {
		Integer score = uppercaseAdd.calculate("abcdefG");
		assertEquals(12, score.intValue());
	}
	
	@Test
	public void shouldReturn16() {
		Integer score = uppercaseAdd.calculate("abcdefG21");
		assertEquals(16, score.intValue());
	}
	
	@Test
	public void shouldReturn24() {
		Integer score = uppercaseAdd.calculate("Avasdd1827DscaC");
		assertEquals(24, score.intValue());
	}
}
