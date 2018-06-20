package com.passwordmeter.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.passwordmeter.dto.PasswordResponseDTO;
import com.passwordmeter.dto.PasswordResponseDTO.PasswordResponseBuilder;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {PasswordServiceBean.class})
public class PasswordServiceBeanTest {

	@Autowired
	private PasswordServiceBean service;
	
	@Test
	public void shouldReturnVeryWeakPassword() {
		PasswordResponseDTO result = service.meter("1234");
		PasswordResponseDTO expected = new PasswordResponseBuilder().withComplexity("Muito fraca").withScore(4).build();
		assertEquals(expected, result);
	}
	
	@Test
	public void shouldReturnGoodPassword() {
		PasswordResponseDTO result = service.meter("1234Ac");
		PasswordResponseDTO expected = new PasswordResponseBuilder().withComplexity("Boa").withScore(56).build();
		assertEquals(expected, result);
	}
	
	@Test
	public void shouldReturnVeryStrongPassword() {
		PasswordResponseDTO result = service.meter("1234AcDasd9&!3128Nsdi");
		PasswordResponseDTO expected = new PasswordResponseBuilder().withComplexity("Muito forte").withScore(100).build();
		assertEquals(expected, result);
	}
}