package com.passwordmeter.meter.deductions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractConsecutiveChecker {
	
	protected Integer calculate(String password, String regex) {
		Pattern pattern = Pattern.compile(regex);
		
		Matcher m = pattern.matcher(password);
		String[] split = pattern.split(password);
		
		Integer from = 0;
		Integer count = 0;
		
	    while (m.find(from)) {
	        count++;
	        from = m.start() + 1;
	    }
	    
	    if (count == 1) {
	    	return 0;
	    } else if (count > 0) {
	    	count = count - (split.length > 0 ? split.length : 1);	    	
	    }
	    
		return count < 0 ? 0 : (count * 2) * -1;
	}

}
