package org.tpg.runner;

import java.io.BufferedReader;
import java.io.FileReader;

import org.tpg.validators.IPValidationRegex;

public class Runner {

	private static final String IPS_FILE = "ips.txt";

	public static void main(String[] args) throws Exception {
		IPValidationRegex ipValidator = new IPValidationRegex();
		BufferedReader br = new BufferedReader(new FileReader(IPS_FILE));
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        if (ipValidator.validate(line)) {
		        	sb.append(line);
		        	sb.append(System.lineSeparator());
		        }
		        line = br.readLine();
		    }
		    String validIps = sb.toString();
		    System.out.println(validIps);
		} finally {
		    br.close();
		}

	}

}
