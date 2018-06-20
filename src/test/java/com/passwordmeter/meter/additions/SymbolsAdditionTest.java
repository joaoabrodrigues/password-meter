package com.passwordmeter.meter.additions;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.passwordmeter.meter.Calculator;

public class SymbolsAdditionTest {

	private Calculator symbolsAdd = new SymbolsAddition();
	
	@Test
	public void shouldReturnScoreZeroWithEmptyString() {
		Integer score = symbolsAdd.calculate("");
		assertEquals(0, score.intValue());
	}
	
	@Test
	public void shouldReturnScoreZeroWithLetters() {
		Integer score = symbolsAdd.calculate("aecasdasdaqwer");
		assertEquals(0, score.intValue());
	}
	
	@Test
	public void shouldReturnScoreWithOnlyNumbers() {
		Integer score = symbolsAdd.calculate("4124124124");
		assertEquals(0, score.intValue());
	}
	
	@Test
	public void shouldReturnScoreZeroWithLettersAndNumbers() {
		Integer score = symbolsAdd.calculate("adas786das87d5612");
		assertEquals(0, score.intValue());
	}
	
	@Test
	public void shouldReturnScore24() {
		Integer score = symbolsAdd.calculate("$!@#");
		assertEquals(24, score.intValue());
	}
	
	@Test
	public void shouldReturnScore54() {
		Integer score = symbolsAdd.calculate("!@#(*;;&#");
		assertEquals(54, score.intValue());
	}
	
	@Test
	public void shouldReturnScore36() {
		Integer score = symbolsAdd.calculate("adisjd12873*&&¨#!");
		assertEquals(36, score.intValue());
	}
}
