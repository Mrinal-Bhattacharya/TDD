package com.tdd.galaxy;

import static org.junit.Assert.*;

import org.junit.Test;

public class MerchantSpec {

	@Test
	public void tradingSingleDirtCalculation() {
		String[] tradingInstruction=new String[2];
		tradingInstruction[0]="glob is I";
		tradingInstruction[1]="how much is glob ?"; 
		String result=new Merchant(tradingInstruction).trade();
		assertEquals("glob is 1", result);
	}
	@Test
	public void tradingMultipleDirtCalculation() {
		String[] tradingInstruction=new String[4];
		tradingInstruction[0]="glob is I";
		tradingInstruction[1]="pish is X";
		tradingInstruction[2]="tegj is L";
		tradingInstruction[3]="how much is pish tegj glob glob ?"; 
		String result=new Merchant(tradingInstruction).trade();
		assertEquals("pish tegj glob glob is 42", result);
	}
	@Test
	public void tradingMetalCalculation() {
		String[] tradingInstruction=new String[6];
		tradingInstruction[0]="glob is I";
		tradingInstruction[1]="prok is V";
		tradingInstruction[2]="pish is X";
		tradingInstruction[3]="tegj is L";
		tradingInstruction[4]="glob glob Silver is 34 Credits"; 
		tradingInstruction[5]="how many Credits is glob prok Silver ?"; 
		String result=new Merchant(tradingInstruction).trade();
		assertEquals("glob prok Silver is 68 Credits", result);
	}
	@Test
	public void tradingMixCalculation() {
		String[] tradingInstruction=new String[7];
		tradingInstruction[0]="glob is I";
		tradingInstruction[1]="prok is V";
		tradingInstruction[2]="pish is X";
		tradingInstruction[3]="tegj is L";
		tradingInstruction[4]="glob glob Silver is 34 Credits"; 
		tradingInstruction[5]="how much is pish tegj glob glob ?";
		tradingInstruction[6]="how many Credits is glob prok Silver ?"; 
		String result=new Merchant(tradingInstruction).trade();
		assertEquals("pish tegj glob glob is 42\nglob prok Silver is 68 Credits", result);
	}
}
