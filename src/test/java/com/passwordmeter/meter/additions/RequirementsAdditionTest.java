package com.passwordmeter.meter.additions;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.passwordmeter.meter.Calculator;

public class RequirementsAdditionTest {
	
	private Calculator minimumRequirementsAdd = new RequirementsAddition();

	@Test
	public void shouldReturnZeroWithEmptyPassword() {
		Integer score = minimumRequirementsAdd.calculate("");
		assertEquals(0, score.intValue());
	}
	
	@Test
	public void shouldReturnZeroWithoutMinimumLength() {
		Integer score = minimumRequirementsAdd.calculate("1234567");
		assertEquals(0, score.intValue());
	}
	
	@Test
	public void shouldReturnZeroWithoutMinimumItemsOnlyDigits() {
		Integer score = minimumRequirementsAdd.calculate("12345678");
		assertEquals(0, score.intValue());
	}
	
	@Test
	public void shouldReturnZeroWithoutMinimumItemsOnlyLetters() {
		Integer score = minimumRequirementsAdd.calculate("dhsbnaisdjquydw");
		assertEquals(0, score.intValue());
	}
	
	@Test
	public void shouldReturnZeroWithoutMinimumItemsOnlySymbols() {
		Integer score = minimumRequirementsAdd.calculate("*&!@*#&*@!&#*&");
		assertEquals(0, score.intValue());
	}
	
	@Test
	public void shouldReturnScore8() {
		Integer score = minimumRequirementsAdd.calculate("Aa123456");
		assertEquals(8, score.intValue());
	}
	
	@Test
	public void shouldReturnScore10() {
		Integer score = minimumRequirementsAdd.calculate("AbC12345#");
		assertEquals(10, score.intValue());
	}
}
