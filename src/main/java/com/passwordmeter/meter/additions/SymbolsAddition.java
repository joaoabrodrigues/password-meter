package com.passwordmeter.meter.additions;

import com.passwordmeter.meter.Calculator;

public class SymbolsAddition implements Calculator {

	@Override
	public Integer calculate(String password) {
		Long occurrences = password.chars().filter(c -> !Character.isLetterOrDigit(c) && !Character.isSpaceChar(c)).count();
		
		return (occurrences.intValue() * 6);
	}
}
