package com.passwordmeter.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotBlank;

public class PasswordRequestDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof PasswordRequestDTO)) {
			return false;
		}
		PasswordRequestDTO castOther = (PasswordRequestDTO) other;
		return Objects.equals(password, castOther.password);
	}

	@Override
	public int hashCode() {
		return Objects.hash(password);
	}
	
	
}
