package com.passwordmeter.meter.deductions;

import com.passwordmeter.meter.Calculator;

public class LettersOnlyDeduction extends AbstractCharsOnlyChecker implements Calculator {
	
	@Override
	public Integer calculate(String password) {
		return calculate(password, "[a-zA-Z]+");
	}
}
