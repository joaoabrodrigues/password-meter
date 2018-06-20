package com.passwordmeter.meter.additions;

import com.passwordmeter.meter.Calculator;

public class NumberOfCharactersAddition implements Calculator {

	@Override
	public Integer calculate(String password) {
		Integer length = password.length();
		return length * 4;
	}
}
