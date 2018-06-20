package com.passwordmeter.meter.additions;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.passwordmeter.meter.Calculator;

public class NumbersAdditionTest {

	private Calculator numbersAdd = new NumbersAddition();
	
	@Test
	public void shouldReturnScoreZeroWithEmptyString() {
		Integer score = numbersAdd.calculate("");
		assertEquals(0, score.intValue());
	}
	
	@Test
	public void shouldReturnScoreZeroWithLetters() {
		Integer score = numbersAdd.calculate("aecasdasdaqwer");
		assertEquals(0, score.intValue());
	}
	
	@Test
	public void shouldReturnScoreWithOnlyNumbers() {
		Integer score = numbersAdd.calculate("412");
		assertEquals(0, score.intValue());
	}
	
	@Test
	public void shouldReturnScore8() {
		Integer score = numbersAdd.calculate("a12");
		assertEquals(8, score.intValue());
	}
	
	@Test
	public void shouldReturnScore16() {
		Integer score = numbersAdd.calculate("1234d");
		assertEquals(16, score.intValue());
	}
	
	@Test
	public void shouldReturnScore40() {
		Integer score = numbersAdd.calculate("1234567890dqdwijmn");
		assertEquals(40, score.intValue());
	}
	
	@Test
	public void shouldReturnScore64() {
		Integer score = numbersAdd.calculate("dioasjd1234567890123456oiajsoci");
		assertEquals(64, score.intValue());
	}
}
