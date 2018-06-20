package com.passwordmeter.meter.additions;

import com.passwordmeter.meter.Calculator;

public class RequirementsAddition implements Calculator {
	
	private static final Integer MINIMUM_LENGTH = 8;

	@Override
	public Integer calculate(String password) {
		Integer length = password.length();
		
		if (length >= MINIMUM_LENGTH) {
			Integer lower = password.chars().filter(c -> Character.isLowerCase(c)).count() > 0l ? 1 : 0;
			Integer upper = password.chars().filter(c -> Character.isUpperCase(c)).count() > 0l ? 1 : 0;
			Integer numbers = password.chars().filter(c -> Character.isDigit(c)).count() > 0l ? 1 : 0;
			Integer symbols = password.chars().filter(c -> !Character.isLetterOrDigit(c) && !Character.isSpaceChar(c)).count() > 0l ? 1 : 0;
			
			Integer total = lower + upper + numbers + symbols;
			
			if (total > 2) {
				return (total + 1) * 2;
			}
		}
		
		return 0;
	}
}
