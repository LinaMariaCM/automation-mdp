package com.amaris.automation.model.helpers;

import com.amaris.automation.model.utils.StringUtils;

import java.util.Formatter;

public class DniGeneratorHelper {

	private static final char[] LETRAS_ASIGNACION = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E' };

	private DniGeneratorHelper() {
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
			String letra = "X";
			String numeroNIE = String.valueOf(Math.random()).concat(seed);
			numeroNIE = numeroNIE.substring(numeroNIE.length() - 7);

			int valorPrimeraLetra = (int) Math.floor(Math.random() * 3);

			if(valorPrimeraLetra == 1) {
				letra = "Y";
			} else if(valorPrimeraLetra == 2) {
				letra = "Z";
			}

			result = letra + numeroNIE + LETRAS_ASIGNACION[
				(Integer.parseInt(Integer.toString(valorPrimeraLetra) + numeroNIE)) % 23];
		}

		return result;
	}
/* falta revisaar
	public static String generateCIF(String seed) {
		String result = null;
		seed = seed == null ? "" : seed;
		String[] organizacion = new String[]{ "A", "B", "C", "D", "E", "F", "G", "H", "K", "L", "M", "N", "P", "Q", "S" };

		if(seed.isEmpty() || StringUtils.isNumber(seed)) {

			String numeroCIF = String.valueOf(Math.random()).concat(seed);
			numeroCIF = numeroCIF.substring(numeroCIF.length() - 5);

			int aleatorio = (int) Math.random() * (organizacion.length);
			String letraO = organizacion[aleatorio];

			int valorAleatorioP = 0;
			do {
				valorAleatorioP = (int) Math.floor(Math.random() * (99) + 1);
			} while((valorAleatorioP >= 65 && valorAleatorioP <= 69 || valorAleatorioP >= 85 && valorAleatorioP <= 90));

			if(valorAleatorioP < 10) {
				Formatter letraP = new Formatter();
				letraP.format("%08d", valorAleatorioP);
			}
			String letraC;
			if(letraO.equalsIgnoreCase("K") ||
				letraO.equalsIgnoreCase("P") || letraO.equalsIgnoreCase("Q") ||
				letraO.equalsIgnoreCase("S")) {
				letraC = organizacion[aleatorio];
			} else {
				letraC = String.valueOf(Math.floor(Math.random() * (9) + 1));
			}

			result = letraO + valorAleatorioP + numeroCIF + letraC;
		}

		return result;
	}

	public static void main(String[] args) {

		System.out.println();


 */
}



