package com.passwordmeter.service;

import org.springframework.stereotype.Service;

import com.passwordmeter.dto.PasswordResponseDTO;
import com.passwordmeter.dto.PasswordResponseDTO.PasswordResponseBuilder;
import com.passwordmeter.meter.Meter;

@Service
public class PasswordServiceBean implements PasswordService {

	@Override
	public PasswordResponseDTO meter(String password) {
		Integer score = Meter.getScore(password);
		String complexity = Meter.getComplexity(score);
		
		return new PasswordResponseBuilder()
					.withComplexity(complexity)
					.withScore(score)
					.build();
	}

}
