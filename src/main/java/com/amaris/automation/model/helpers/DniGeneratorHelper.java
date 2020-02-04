package com.amaris.automation.model.helpers;

import com.amaris.automation.model.utils.StringUtils;

import java.util.Formatter;

public class DniGeneratorHelper {

	private static final char[] LETRAS_ASIGNACION = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E' };

	private static final String digitoControlCif = "JABCDEFGHI";
	private static final  String cifLetra = "KPQRSNW";


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

	public static String generateCIF() {
		return generateCIF(null);
	}

	public static String generateCIF(String seed) {

		String result = null;
		String cif = null;
		seed = seed == null ? "" : seed;
		String[] organizacion = new String[]{ "A", "B", "C", "D", "E", "F", "G", "H", "J", "N", "P", "Q", "R", "S", "U", "V", "W"};

		if(seed.isEmpty() || StringUtils.isNumber(seed)) {

			int aleatorio = (int) Math.floor(Math.random() * organizacion.length);
			String letraO = organizacion[aleatorio];

			int valorAleatorioP = 0;
			do {
				valorAleatorioP = (int) Math.floor(Math.random() * 99 + 1);
			} while((valorAleatorioP >= 65 && valorAleatorioP <= 69 || valorAleatorioP >= 85 && valorAleatorioP <= 90));

			String numeroCIF = String.valueOf(Math.random()).concat(seed);
			numeroCIF = numeroCIF.substring(numeroCIF.length() - 5);

			String ceroExtra = "";
			if(valorAleatorioP < 10) {
				ceroExtra = "0";
			}

			result = letraO + ceroExtra + valorAleatorioP + numeroCIF;
			cif = result + calculaDigitoControl(result);
		}

		return cif;
	}
	private static String calculaDigitoControl(String cif) {
		String str = cif.substring(1, 8);
		String cabecera = cif.substring(0, 1);
		int sumaPar = 0;
		int sumaImpar = 0;
		int sumaTotal;

		for (int i = 1; i < str.length(); i += 2) {
			int aux = Integer.parseInt("" + str.charAt(i));
			sumaPar += aux;
		}

		for (int i = 0; i < str.length(); i += 2) {
			sumaImpar += posicionImpar("" + str.charAt(i));
		}

		sumaTotal = sumaPar + sumaImpar;
		sumaTotal = 10 - (sumaTotal % 10);

		if(sumaTotal==10){
			sumaTotal=0;
		}

		if (cifLetra.contains(cabecera)) {
			str = "" + digitoControlCif.charAt(sumaTotal);
		} else {
			str = "" + sumaTotal;
		}

		return str;
	}

	private static int posicionImpar(String str) {
		int aux = Integer.parseInt(str);
		aux = aux * 2;
		aux = (aux / 10) + (aux % 10);

		return aux;
	}

	public static void main(String[] args) {
		System.out.println("El resulatdo es " + generateCIF());
	}



}



