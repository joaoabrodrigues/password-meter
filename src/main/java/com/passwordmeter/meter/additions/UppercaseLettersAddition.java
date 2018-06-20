package com.passwordmeter.meter.additions;

import com.passwordmeter.meter.Calculator;

public class UppercaseLettersAddition implements Calculator {

	@Override
	public Integer calculate(String password) {
		Long occurrences = password.chars().filter(c -> Character.isUpperCase(c)).count();
		Integer length = password.length();
		
		if (occurrences == 0l) {
			return 0;
		}
		
		return ((length - occurrences.intValue()) * 2);
	}
}
