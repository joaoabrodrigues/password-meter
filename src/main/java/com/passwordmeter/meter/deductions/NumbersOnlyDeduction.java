package com.passwordmeter.meter.deductions;

import com.passwordmeter.meter.Calculator;

public class NumbersOnlyDeduction extends AbstractCharsOnlyChecker implements Calculator {
	
	public Integer calculate(String password) {
		return calculate(password, "[0-9]+");
	}
}
