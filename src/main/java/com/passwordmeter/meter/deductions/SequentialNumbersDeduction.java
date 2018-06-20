package com.passwordmeter.meter.deductions;

import com.passwordmeter.meter.Calculator;

public class SequentialNumbersDeduction extends AbstractSequentialChecker implements Calculator {

	@Override
	public Integer calculate(String password) {
		return calculate(password, "0123456789");
	}
	
	

}
