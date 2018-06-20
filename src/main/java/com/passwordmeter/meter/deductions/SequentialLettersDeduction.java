package com.passwordmeter.meter.deductions;

import com.passwordmeter.meter.Calculator;

public class SequentialLettersDeduction extends AbstractSequentialChecker implements Calculator {

	@Override
	public Integer calculate(String password) {
		return calculate(password, "abcdefghijklmnopqrstuvwxyz");
	}
	
	

}
