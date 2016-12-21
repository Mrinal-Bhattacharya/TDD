package com.tdd.galaxy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Merchant {

	private String[] tradingInstruction;

	public Merchant(String[] tradingInstruction) {
		this.tradingInstruction = tradingInstruction;
		// TODO Auto-generated constructor stub
	}

	public String trade() {
		List<String> results = new LinkedList<String>();
		Map<String, String> dirtTable = new HashMap<String, String>();
		Map<String, Integer> metalTable = new HashMap<String, Integer>();
		for (String instruction : tradingInstruction) {
			Pattern pattern = Pattern.compile("^([a-z]+) is (I|V|X|L|C|D|M)$");
			Matcher matcher = pattern.matcher(instruction);
			if (matcher.find()) {
				dirtTable.put(matcher.group(1), matcher.group(2));
				continue;
			}
			Pattern dirtCalculationPattern = Pattern.compile("^how much is ((?:\\w+ )+)\\?$");
			Matcher dirtCalculationMatcher = dirtCalculationPattern.matcher(instruction);
			if (dirtCalculationMatcher.find()) {
				final String collect = Pattern.compile(" ").splitAsStream(dirtCalculationMatcher.group(1).trim())
						.map(t -> {
							return dirtTable.get(t);
						}).collect(Collectors.joining(""));
				Number number = new Number(collect);
				results.add(dirtCalculationMatcher.group(1).trim()+" is "+number.toArabic());
				continue;
			}
			Pattern metalCalculationPattern = Pattern.compile("((?:\\w+ )+)([A-Z]\\w+) is (\\d+) Credits");
			Matcher metalCalculationMatcher = metalCalculationPattern.matcher(instruction);
			if (metalCalculationMatcher.find()) {
				final String collect = Pattern.compile(" ").splitAsStream(metalCalculationMatcher.group(1).trim())
						.map(t -> {
							return dirtTable.get(t);
						}).collect(Collectors.joining(""));
				Number number = new Number(collect);
				int metalValue = Integer.valueOf(metalCalculationMatcher.group(3)) / number.toArabic();
				metalTable.put(metalCalculationMatcher.group(2), metalValue);
				continue;
			}
			Pattern metalPattern = Pattern.compile("^how many Credits is ((?:\\w+ )+)([A-Z]\\w+) \\?");
			Matcher metalMatcher = metalPattern.matcher(instruction);
			if (metalMatcher.find()) {
				final String collect = Pattern.compile(" ").splitAsStream(metalMatcher.group(1).trim())
						.map(t -> {
							return dirtTable.get(t);
						}).collect(Collectors.joining(""));
				Number number = new Number(collect);
				int metalValue = metalTable.get(metalMatcher.group(2)) * number.toArabic();
				results.add(metalMatcher.group(1).trim()+" "+metalMatcher.group(2)+" is "+metalValue+" Credits");
				continue;
			}
			
		}
		return String.join("\n", results);
	}

}
