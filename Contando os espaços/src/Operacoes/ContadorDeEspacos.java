package Operacoes;

import java.util.ArrayList;

public class ContadorDeEspacos {
	
	public ContadorDeEspacos() {
		
	}

	public static void contadorDeEspacos(String frase) {
		
		int contEspacos = 0;
		char l;
		
		for (int i = 0; i < frase.length(); i++) {
			l = frase.charAt(i);
			if (l == ' ') {
				contEspacos++;
			}
		}
		
		System.out.println("Encontrados " + contEspacos + " espaços.");
		
	}
	
	public static void contadorDeEspacosComVetor(String frase) {
		
		ArrayList<String> f = new ArrayList<String>();
		int contEspacos = 0;
		
		for (int i = 0; i < frase.length(); i++) {
			f.add(String.valueOf(frase.charAt(i)));
		}
		
		for (int i = 0; i < f.size(); i++) {
			if (f.get(i).equals(" ")) {
				contEspacos++;
			}
		}
				
		System.out.println("Encontrados " + contEspacos + " espaços.");
		
	}
}
