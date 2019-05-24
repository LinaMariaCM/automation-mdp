package com.amaris.automation.model.helpers;

import com.amaris.automation.model.utils.StringUtils;

public class DniGeneratorHelper {

	private static final char[] LETRAS_NIF = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

	public static String generateNif() {
		return generateNif(null);
	}

	public static String generateNif(String seed) {
		String result = null;
		seed = seed == null ? "" : seed;

		if(seed.isEmpty() || StringUtils.isNumber(seed)) {
			String numeroDNI = String.valueOf(Math.random()).concat(seed);
			String fullDNI = numeroDNI.substring(numeroDNI.length() - 8);

			result = fullDNI + LETRAS_NIF[Integer.parseInt(fullDNI) % 23];
		}

		return result;
	}

	public static boolean isValidNif(String nif) {
		boolean result = false;

		if(nif != null && nif.length() == 9 && StringUtils.isNumber(nif.substring(0, 8))) {
			result = nif.equalsIgnoreCase(generateNif(nif.substring(0, 8)));
		}

		return result;
	}

	private DniGeneratorHelper() {}
}
