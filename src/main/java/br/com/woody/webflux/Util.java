package br.com.woody.webflux;

import java.util.Random;

public class Util {

	private static Random r = new Random();
	
	public static String completarComZeroAEsquerda(int s, int tamanho) {
		return completarComZeroAEsquerda(String.valueOf(s), tamanho);
	}
	
	public static String completarComZeroAEsquerda(String s, int tamanho) {
		if (s.length() < tamanho) {
			return completarComZeroAEsquerda("0" + s, tamanho);
		}
		
		return s;
	}

	public static int gerarNumero(int min, int max) {
		return r.nextInt(max - min) + min;
	}

	public static String gerarPalavraV2(int length) {
		String palavra = "";
		for (int i = 0; i < length; i++) {
			if (palavra.isEmpty()) {
				palavra += gerarChar();
				continue;
			}

			char ultimoCaracter = palavra.charAt(i - 1);
			boolean vogal = isVogal(ultimoCaracter);
			char novoCaracter;

			if (vogal) {
				do {
					novoCaracter = gerarChar();
				} while (isVogal(novoCaracter));
			} else {
				do {
					novoCaracter = gerarChar();
				} while (!isVogal(novoCaracter));
			}

			palavra += novoCaracter;
		}

		return palavra;
	}

	private static boolean isLetraProibida(char c) {
		return c == 'X' || c == 'K' || c == 'W' || c == 'Y';
	}

	private static boolean isVogal(char c) {
		return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
	}

	public static String gerarPalavra(int length) {
		String palavra = "";

		for (int i = 0; i < length; i++) {
			palavra += gerarChar();
		}

		return palavra;
	}

	private static char gerarChar() {
		char c =  (char) (r.nextInt(90 - 65) + 65);
		if(isLetraProibida(c)) {
			return gerarChar();
		}
		
		return c;
	}

}
