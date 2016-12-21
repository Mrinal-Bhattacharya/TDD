package com.tdd.galaxy;

public class Symbol {
	private int arabic;
	private String roman;

	Symbol(int arabic, String roman) {
		this.arabic = arabic;
		this.roman = roman;

	}

	public int getArabic() {
		return arabic;
	}

	public String getRoman() {
		return roman;
	}
	
	
}
