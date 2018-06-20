package com.passwordmeter.meter.additions;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.passwordmeter.meter.Calculator;

public class NumberOfCharactersAdditionTest {
	
	private Calculator numberOfCharactersAdd = new NumberOfCharactersAddition();
	
	@Test
	public void shouldReturnScore8() {
		Integer score = numberOfCharactersAdd.calculate("12");
		assertEquals(8, score.intValue());
	}
	
	@Test
	public void shouldReturnScore16() {
		Integer score = numberOfCharactersAdd.calculate("1234");
		assertEquals(16, score.intValue());
	}
	
	@Test
	public void shouldReturnScore40() {
		Integer score = numberOfCharactersAdd.calculate("1234567890");
		assertEquals(40, score.intValue());
	}
	
	@Test
	public void shouldReturnScore64() {
		Integer score = numberOfCharactersAdd.calculate("1234567890123456");
		assertEquals(64, score.intValue());
	}
}
