package com.passwordmeter.meter.deductions;

import com.passwordmeter.meter.Calculator;

public class ConsecutiveLowercaseLettersDeduction extends AbstractConsecutiveChecker implements Calculator {
	
	@Override
	public Integer calculate(String password) {
		return calculate(password, "[a-z]+");
	}
}
