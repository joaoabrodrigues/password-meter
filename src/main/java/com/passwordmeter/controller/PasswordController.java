package com.passwordmeter.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.passwordmeter.dto.PasswordRequestDTO;
import com.passwordmeter.dto.PasswordResponseDTO;
import com.passwordmeter.service.PasswordService;

@RestController
public class PasswordController {
	
	@Autowired
	private PasswordService passwordService;
	
	@PostMapping(path = "/api/v1/password/meter", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
	public PasswordResponseDTO meter(@RequestBody PasswordRequestDTO dto) {
		return passwordService.meter(dto.getPassword());
	}

}