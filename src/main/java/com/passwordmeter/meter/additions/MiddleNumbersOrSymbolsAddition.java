package com.passwordmeter.meter.additions;

import com.passwordmeter.meter.Calculator;

public class MiddleNumbersOrSymbolsAddition implements Calculator {
	
	@Override
	public Integer calculate(String password) {
		Integer length = password.length();
		if (length < 3) {
			return 0;
		}
		
		String middlePassword = password.substring(1, length - 1);
		
		Long symbolOccurrences = middlePassword.chars().filter(c -> !Character.isLetterOrDigit(c) && !Character.isSpaceChar(c)).count();
		Long numbersOccurrences = middlePassword.chars().filter(c -> Character.isDigit(c)).count();
		
		return ((symbolOccurrences.intValue() + numbersOccurrences.intValue()) * 2);
	}

}
