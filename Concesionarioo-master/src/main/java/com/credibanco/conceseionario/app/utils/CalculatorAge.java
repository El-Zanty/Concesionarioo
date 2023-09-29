package com.credibanco.conceseionario.app.utils;

import java.time.LocalDate;
import java.time.Period;

public class CalculatorAge {
	
	 public static String ageCalculator(LocalDate dateOfBirht) {
	        LocalDate dateActually = LocalDate.now();
	        Period periodo = Period.between(dateOfBirht, dateActually);
	        return String.format("Tu edad es: %s años, %s meses y %s días",
	                             periodo.getYears(), periodo.getMonths(), periodo.getDays());
	    }

}
