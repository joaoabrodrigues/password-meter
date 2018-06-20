package com.passwordmeter.service;

import com.passwordmeter.dto.PasswordResponseDTO;

@FunctionalInterface
public interface PasswordService {
	
	PasswordResponseDTO meter(String password);
	
}
