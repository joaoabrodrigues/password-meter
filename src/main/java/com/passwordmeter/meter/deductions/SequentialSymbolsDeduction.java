package com.passwordmeter.meter.deductions;

import com.passwordmeter.meter.Calculator;

public class SequentialSymbolsDeduction extends AbstractSequentialChecker implements Calculator {

	@Override
	public Integer calculate(String password) {
		return calculate(password, ")!@#$%^&*()");
	}
	
	

}
