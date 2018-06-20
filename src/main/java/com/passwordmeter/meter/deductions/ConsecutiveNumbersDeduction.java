package com.passwordmeter.meter.deductions;

import com.passwordmeter.meter.Calculator;

public class ConsecutiveNumbersDeduction extends AbstractConsecutiveChecker implements Calculator {
	
	@Override
	public Integer calculate(String password) {
		return calculate(password, "[0-9]+");
	}
}
