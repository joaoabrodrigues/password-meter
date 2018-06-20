package com.passwordmeter.meter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.passwordmeter.meter.additions.LowercaseLettersAddition;
import com.passwordmeter.meter.additions.MiddleNumbersOrSymbolsAddition;
import com.passwordmeter.meter.additions.NumberOfCharactersAddition;
import com.passwordmeter.meter.additions.NumbersAddition;
import com.passwordmeter.meter.additions.RequirementsAddition;
import com.passwordmeter.meter.additions.SymbolsAddition;
import com.passwordmeter.meter.additions.UppercaseLettersAddition;
import com.passwordmeter.meter.deductions.ConsecutiveLowercaseLettersDeduction;
import com.passwordmeter.meter.deductions.ConsecutiveNumbersDeduction;
import com.passwordmeter.meter.deductions.ConsecutiveUppercaseLettersDeduction;
import com.passwordmeter.meter.deductions.LettersOnlyDeduction;
import com.passwordmeter.meter.deductions.NumbersOnlyDeduction;
import com.passwordmeter.meter.deductions.SequentialLettersDeduction;
import com.passwordmeter.meter.deductions.SequentialNumbersDeduction;
import com.passwordmeter.meter.deductions.SequentialSymbolsDeduction;

public class Meter {
	
	private static final List<Calculator> ADDITIONS = new ArrayList<>();
	private static final List<Calculator> DEDUCTIONS = new ArrayList<>();
	
	static {
		ADDITIONS.add(new LowercaseLettersAddition());
		ADDITIONS.add(new MiddleNumbersOrSymbolsAddition());
		ADDITIONS.add(new NumberOfCharactersAddition());
		ADDITIONS.add(new NumbersAddition());
		ADDITIONS.add(new RequirementsAddition());
		ADDITIONS.add(new UppercaseLettersAddition());
		ADDITIONS.add(new SymbolsAddition());
	}
	
	static {
		DEDUCTIONS.add(new ConsecutiveLowercaseLettersDeduction());
		DEDUCTIONS.add(new ConsecutiveNumbersDeduction());
		DEDUCTIONS.add(new ConsecutiveUppercaseLettersDeduction());
		DEDUCTIONS.add(new LettersOnlyDeduction());
		DEDUCTIONS.add(new NumbersOnlyDeduction());
		DEDUCTIONS.add(new SequentialLettersDeduction());
		DEDUCTIONS.add(new SequentialNumbersDeduction());
		DEDUCTIONS.add(new SequentialSymbolsDeduction());
	}
	
	public static Integer getScore(String password) {
		Integer score = getAdditions(password) + getDeductions(password);
		
		if (score > 100) {
			score = 100;
		} else if (score < 0) {
			score = 0;
		}
		
		return score;
	}
	
	public static String getComplexity(Integer score) {
		if (score >= 0 && score < 20) { 
			return "Muito fraca"; 
		} else if (score >= 20 && score < 40) { 
			return "Fraca"; 
		} else if (score >= 40 && score < 60) { 
			return "Boa"; 
		} else if (score >= 60 && score < 80) { 
			return "Forte"; 
		} else if (score >= 80 && score <= 100) { 
			return "Muito forte"; 
		}
		return null;
	}
	
	private static Integer getAdditions(String password) {
		AtomicInteger score = new AtomicInteger(0);
		
		ADDITIONS.forEach(addition -> {
			Integer s = addition.calculate(password);
			score.addAndGet(s);
		});
		
		return score.get();
	}
	
	private static Integer getDeductions(String password) {
		AtomicInteger score = new AtomicInteger(0);
		
		DEDUCTIONS.forEach(deduction -> {
			Integer s = deduction.calculate(password);
			score.addAndGet(s);
		});
		
		return score.get();
	}
}
