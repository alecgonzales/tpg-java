package org.tpg.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPValidationRegex {

	private static final String IP_VALUE_REGEX = "[0-9]+";
	private static final String IP_DELIMITER = "\\.";
	private static final String IP_REGEX = IP_VALUE_REGEX + IP_DELIMITER + IP_VALUE_REGEX + IP_DELIMITER + IP_VALUE_REGEX + IP_DELIMITER + IP_VALUE_REGEX;
	private static final int IP_MAX_VALUE = 255;

	public boolean validate(String ip) {
		if (ip == null) {
			return false;
		} else {
			Pattern pattern = Pattern.compile(IP_REGEX);
			Matcher m = pattern.matcher(ip);
			if (m.matches() == false) {
				return false;
			} else {
				String[] tokens = ip.split(IP_DELIMITER);
				for (String token : tokens) {
					if (Integer.parseInt(token) > IP_MAX_VALUE) {
						return false;
					}
				}
			}
			return true;
		}
	}

}
