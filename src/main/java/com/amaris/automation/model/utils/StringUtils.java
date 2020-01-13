package com.amaris.automation.model.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringUtils {

	public static String getRandomNumberChain(int length) {
		StringBuilder result = new StringBuilder();

		while(length > 0) {
			result.append((int) (Math.random() * 9));

			length--;
		}

		return result.toString();
	}

	public static String getRandomLetterChain(int length) {
		StringBuilder result = new StringBuilder();

		while(length > 0) {
			result.append((char) (65 + (Math.random() * 25) + (Math.random() > 0.5 ? 32 : 0)));

			length--;
		}

		return result.toString();
	}

	public static String[][] csvStringToMatrix(String csvString) {
		return stringToMatrix(csvString, "\n", ";");
	}

	public static String priceToASCII(String data) {
		StringBuilder result = new StringBuilder();
		List<Character> allowedChars = Arrays.asList('€', '£', 'р', 'у', 'б', '원');

		for(int i = 0; i < data.length(); i++) {
			char ch = data.charAt(i);

			if((ch > 43 && ch < 65) || allowedChars.contains(ch)) result.append(ch);
		}

		return result.toString();
	}

	public static String[][] stringToMatrix(String csvString, String rowDiv, String colDiv) {
		String[][] result = new String[0][0];

		if(!csvString.isEmpty()) {
			int nRows = countOcurrencesInString(csvString, rowDiv) + 1;
			int nCol = countOcurrencesInString(csvString.split(rowDiv)[0], colDiv) + 1;

			result = new String[nRows][nCol];

			for(int i = 0; i < nRows; i++) {
				result[i] = csvString.split(rowDiv)[i].split(colDiv);
			}
		}

		return result;
	}

	public static String correctUrlSlashes(String url) {
		String firstPart = "";
		String secondPart = url;

		if(url.startsWith("http")) {
			firstPart = url.substring(0, url.indexOf("://") + 3);
			secondPart = url.substring(url.indexOf("://") + 3);
		}

		secondPart = secondPart.replaceAll("\\/+", "/");

		return firstPart + secondPart;
	}

	public static String snakeCaseToNatural(String snakeCaseText) {
		String result = snakeCaseText;

		if(result != null && !result.isEmpty()) {
			result = result.substring(0, 1).toUpperCase() + snakeCaseText.substring(1).toLowerCase().replace("_", " ");
		}

		return result;
	}

	public static String camelCaseToNatural(String camelCaseText) {
		camelCaseText = camelCaseText.substring(0, 1).toUpperCase() + camelCaseText.substring(1);

		for(int i = 0; i < camelCaseText.length(); i++) {
			if(Character.isUpperCase(camelCaseText.charAt(i))) {
				camelCaseText = camelCaseText.substring(i) + " " + Character.toLowerCase(camelCaseText.charAt(i));
				i++;
			}
		}

		return camelCaseText;
	}

	public static String naturalToCamelCase(String naturalText) {
		naturalText = naturalText.toLowerCase();

		for(int i = 0; i < naturalText.length(); i++) {
			if(naturalText.charAt(i) == ' ') {
				naturalText = naturalText.substring(i) + naturalText.substring(i + 1);
				i--;
			}
		}

		return naturalText;
	}

	public static String naturalToSnakeCase(String naturalText) {
		return naturalText.substring(0, 1).toLowerCase() + naturalText.substring(1).toLowerCase().replace(" ", "_");
	}

	public static String replaceTextInBetween(String text, String replaceString, String leftSubstring, String rightSubstring) {
		String textInside = "";

		try {
			textInside = StringUtils.stringToArray(text, leftSubstring, rightSubstring)[0];
		} catch(ArrayIndexOutOfBoundsException e) {}

		return text.replace(leftSubstring + textInside + rightSubstring, leftSubstring + replaceString + rightSubstring);
	}

	public static Map<String, String> stringToDMRow(String text, String divider) {
		String key = null;
		Map<String, String> result = new HashMap<>();

		for(int i = 0; i <= text.length(); i++) {
			if((i <= text.length() - divider.length() && text.substring(i, divider.length()).equals(divider)) || i == text.length()) {
				if(key == null) key = text.substring(0, i);

				result.put(key, text.substring(0, i));

				text = text.substring(i);
				if(text.startsWith(divider)) text = text.substring(divider.length());
				i = 0;
			}
		}

		return result;
	}

	public static Map<String, String> stringToDMRow(String[] keyArray, String[] valueArray) {
		Map<String, String> result = new HashMap<>();

		for(int i = 0; i < valueArray.length; i++) {
			result.put(keyArray[i], valueArray[i]);
		}

		return result;
	}

	public static String mRowToString(Map<String, String> mappedRow, String divider) {
		String value = "";
		StringBuilder result = new StringBuilder();
		String[] keySet = mappedRow.keySet().toArray(new String[0]);

		for(int i = 0; i < keySet.length; i++) {
			if(i != 0) result.append(divider);
			value = mappedRow.get(keySet[i]);
			result.append(value);
		}

		return result.toString();
	}

	public static String mDataToString(Map<String, Map<String, String>> mappedData) {
		return mDataToString(mappedData, ";");
	}

	public static String mDataToString(Map<String, Map<String, String>> mappedData, String divider) {
		Map<String, String> mappedRow = null;
		StringBuilder result = new StringBuilder();
		String[] keySet = mappedData.keySet().toArray(new String[0]);

		for(int i = 0; i < keySet.length; i++) {
			mappedRow = mappedData.get(keySet[i]);

			if(i == 0) result.append("row" + divider + ArrayUtils.arrayToString(mappedRow.keySet().toArray(new String[0]), divider));

			result.append("\n" + keySet[i] + divider + mRowToString(mappedRow, divider));
		}

		return result.toString();
	}

	public static int countOcurrencesInString(String text, String compareString) {
		int count = 0;

		for(int i = 0; i <= text.length() - compareString.length(); i++) {
			if(text.substring(i, i + compareString.length()).equals(compareString)) count++;
		}

		return count;
	}

	public static String[] stringToArray(String text, String divider) {
		int count = 0;
		String[] result = new String[countOcurrencesInString(text, divider) + 1];

		for(int i = 0; i <= text.length(); i++) {
			if(i + divider.length() <= text.length() && text.substring(i, i + divider.length()).equals(divider)) {
				result[count++] = text.substring(0, i);

				text = text.substring(i + 1);
				i = -1;
			} else if(i == text.length()) result[count] = text;
		}

		return result;
	}

	public static String[] stringToArray(String text, String leftDivider, String rightDivider) {
		int pos = 0;
		int count = 0;
		int nested = 0;
		boolean write = false;
		String[] result = new String[countOcurrencesInString(text, leftDivider)];

		for(int i = 0; i <= text.length(); i++) {
			if(write && i + leftDivider.length() <= text.length() && text.substring(i, i + leftDivider.length()).equals(leftDivider)) {
				nested++;
			} else if(write && i + rightDivider.length() <= text.length() && text.substring(i, i + rightDivider.length()).equals(rightDivider) && nested != 0) {
				nested--;
			} else if(!write && i + leftDivider.length() <= text.length() && text.substring(i, i + leftDivider.length()).equals(leftDivider)) {
				i = i + leftDivider.length() - 1;
				pos = i + 1;
				write = true;
			} else if(write && i + rightDivider.length() <= text.length() && text.substring(i, i + rightDivider.length()).equals(rightDivider) && nested == 0) {
				result[count++] = text.substring(pos, i);
				write = false;
			}
		}

		return result;
	}

	public static String getLastElementFromArray(String[] array) {
		return array[array.length - 1];
	}

	public static boolean isNumber(String stringNumber) {
		boolean isNumber = false;

		try {
			if(stringNumber != null && !stringNumber.isEmpty()) {
				Integer.parseInt(stringNumber);

				isNumber = true;
			}
		} catch(NumberFormatException e) {}

		return isNumber;
	}

	private StringUtils() {}
}