package com.passwordmeter.meter.deductions;

public abstract class AbstractSequentialChecker {

	public Integer calculate(String password, String sequence) {
		Integer until = (sequence.length() > 11) ? 23 : 8;
		Integer count = 0;
		
		for (Integer i = 0; i < until; i++) {
			String fwd = sequence.substring(i, i+3);
			String rev = new StringBuilder(fwd).reverse().toString();
			if (password.toLowerCase().indexOf(fwd) != -1 || 
				password.toLowerCase().indexOf(rev) != -1) { 
				count++;
			}
		}
		
		return (count * 3) * -1;
	}
}
