package com.tdd.galaxy;

import java.util.ArrayList;
import java.util.List;

public class Number {
	private String roman;
	private static List<Symbol> SYMBOL_TABLE;

	static {
		SYMBOL_TABLE = new ArrayList<Symbol>();
		SYMBOL_TABLE.add(new Symbol(1000, "M"));
		SYMBOL_TABLE.add(new Symbol(900, "CM"));
		SYMBOL_TABLE.add(new Symbol(500, "D"));
		SYMBOL_TABLE.add(new Symbol(400, "CD"));
		SYMBOL_TABLE.add(new Symbol(100, "C"));
		SYMBOL_TABLE.add(new Symbol(90, "XC"));
		SYMBOL_TABLE.add(new Symbol(50, "L"));
		SYMBOL_TABLE.add(new Symbol(40, "XL"));
		SYMBOL_TABLE.add(new Symbol(10, "X"));
		SYMBOL_TABLE.add(new Symbol(9, "IX"));
		SYMBOL_TABLE.add(new Symbol(5, "V"));
		SYMBOL_TABLE.add(new Symbol(4, "IV"));
		SYMBOL_TABLE.add(new Symbol(1, "I"));
	}

	Number(String roman) {
		this.roman = roman;
	}

	public int toArabic() {
		int arabic = 0;
		for (Symbol symbol : SYMBOL_TABLE) {
			while (roman.startsWith(symbol.getRoman())) {
				arabic += symbol.getArabic();
				roman = roman.substring(symbol.getRoman().length());
			}
		}
		
		return arabic;
	}
}
