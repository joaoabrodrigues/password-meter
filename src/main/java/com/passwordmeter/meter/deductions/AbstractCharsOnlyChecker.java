package com.passwordmeter.meter.deductions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractCharsOnlyChecker {
	
	protected Integer calculate(String password, String regex) {
		Pattern pattern = Pattern.compile(regex);
		Integer length = password.length();
		
		Matcher m = pattern.matcher(password);
		
		if (m.matches()) {
			return -length;
		}
		
		return 0;
	}
}
