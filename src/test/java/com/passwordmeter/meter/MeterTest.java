package com.passwordmeter.meter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class MeterTest {

	@Test
	public void shouldReturnScore4() {
		Integer score = Meter.getScore("1234");
		assertEquals(4, score.intValue());
	}
	
	@Test
	public void shouldReturnScore52() {
		Integer score = Meter.getScore("@d*a&c");
		assertEquals(52, score.intValue());
	}
	
	@Test
	public void shouldReturnScore87() {
		Integer score = Meter.getScore("@X*J&AbCdE");
		assertEquals(87, score.intValue());
	}
	
	@Test
	public void shouldReturnScore100() {
		Integer score = Meter.getScore("@X*J&ACas#E5123765bCdE");
		assertEquals(100, score.intValue());
	}
	
	@Test
	public void shouldReturnComplexityVeryWeak() {
		String complexity = Meter.getComplexity(4);
		assertEquals("Muito fraca", complexity);
	}
	@Test
	public void shouldReturnComplexityGood() {
		String complexity = Meter.getComplexity(52);
		assertEquals("Boa", complexity);
	}
	
	@Test
	public void shouldReturnComplexityVeryStrong() {
		String complexity = Meter.getComplexity(87);
		assertEquals("Muito forte", complexity);
	}
	
	@Test
	public void shouldReturnComplexityVeryStrong100() {
		String complexity = Meter.getComplexity(100);
		assertEquals("Muito forte", complexity);
	}
	
	@Test
	public void shouldReturnNullWithScoreOutOfRange101() {
		String complexity = Meter.getComplexity(101);
		assertNull(complexity);
	}
	
	@Test
	public void shouldReturnNullWithScoreOutOfRangeMinus1() {
		String complexity = Meter.getComplexity(-1);
		assertNull(complexity);
	}
}
