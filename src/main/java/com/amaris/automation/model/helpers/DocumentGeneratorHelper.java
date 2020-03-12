package com.amaris.automation.model.helpers;

import com.amaris.automation.model.utils.StringUtils;

public class DocumentGeneratorHelper {

	private static final char[] LETRAS_ASIGNACION = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E' };
	private static final String CIF_CONTROL_DIGIT = "JABCDEFGHI";
	private static final String CIF_LETTERS = "KPQRSNW";

	private DocumentGeneratorHelper() {
	}

	public static String generateNif() {
		return generateNif(null);
	}

	public static String generateNif(String seed) {
		String result = null;
		seed = seed == null ? "" : seed;

		if(seed.isEmpty() || StringUtils.isNumber(seed)) {
			String numeroDNI = String.valueOf(Math.random()).concat(seed);
			String fullDNI = numeroDNI.substring(numeroDNI.length() - 8);

			result = fullDNI + LETRAS_ASIGNACION[Integer.parseInt(fullDNI) % 23];
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

	public static String generateNIE() {
		return generateNIE(null);
	}

	public static String generateNIE(String seed) {
		String result = null;
		seed = seed == null ? "" : seed;

		if(seed.isEmpty() || StringUtils.isNumber(seed)) {
			String letter = "X";
			String nieNumber = String.valueOf(Math.random()).concat(seed);
			nieNumber = nieNumber.substring(nieNumber.length() - 7);

			int firstLetterValue = (int) Math.floor(Math.random() * 3);

			if(firstLetterValue == 1) {
				letter = "Y";
			} else if(firstLetterValue == 2) {
				letter = "Z";
			}

			result = letter + nieNumber + LETRAS_ASIGNACION[
				(Integer.parseInt(Integer.toString(firstLetterValue) + nieNumber)) % 23];
		}

		return result;
	}

	public static String generateCIF() {
		return generateCIF(null);
	}

	public static String generateCIF(String seed) {
		String result = null;
		seed = seed == null ? "" : seed;
		String[] organization = new String[]{ "A", "B", "C", "D", "F", "G", "H", "J", "N", "P", "Q", "R", "S", "U", "V", "W" };

		if(seed.isEmpty() || StringUtils.isNumber(seed)) {
			int pValue = 0;

			do {
				pValue = (int) Math.floor(Math.random() * 99 + 1);
			} while((pValue >= 65 && pValue <= 69)
				|| (pValue >= 85 && pValue <= 90));

			String cifNumber = String.valueOf(Math.random()).concat(seed);
			cifNumber = cifNumber.substring(cifNumber.length() - 5);

			String extraZero = "";

			if(pValue < 10) {
				extraZero = "0";
			}

			result = organization[(int) Math.floor(Math.random() * organization.length)]
				+ extraZero + pValue + cifNumber;
			result += calculateControlDigit(result);
		}

		return result;
	}

	private static String calculateControlDigit(String cif) {
		int totalSum;
		int oddSum = 0;
		int pairSum = 0;
		String body = cif.substring(1, 8);
		String header = cif.substring(0, 1);

		for(int i = 1; i < body.length(); i += 2) {
			int aux = Integer.parseInt("" + body.charAt(i));
			pairSum += aux;
		}

		for(int i = 0; i < body.length(); i += 2) {
			oddSum += oddPosition("" + body.charAt(i));
		}

		totalSum = pairSum + oddSum;
		totalSum = 10 - (totalSum % 10);

		if(totalSum == 10) {
			totalSum = 0;
		}

		if(CIF_LETTERS.contains(header)) {
			body = "" + CIF_CONTROL_DIGIT.charAt(totalSum);
		} else {
			body = "" + totalSum;
		}

		return body;
	}

	private static int oddPosition(String str) {
		return (Integer.parseInt(str) * 2 / 10) + (Integer.parseInt(str) * 2 % 10);
	}

}