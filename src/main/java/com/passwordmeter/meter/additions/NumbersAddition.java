package com.passwordmeter.meter.additions;

import com.passwordmeter.meter.Calculator;

public class NumbersAddition implements Calculator {
	
	@Override
	public Integer calculate(String password) {
		Long occurrences = password.chars().filter(c -> Character.isDigit(c)).count();
		
		if (occurrences == 0l || occurrences == password.length()) {
			return 0;
		}
		
		return (occurrences.intValue() * 4);
	}
}