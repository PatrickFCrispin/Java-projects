package main;

public class App {
	
	public static void main(String[] args) {
		
		String frase = "ab C DE";
		verificarMaiusculaMinuscula(frase);	
		verificarMaiusculaMinusculaLetras(frase);
		verificarMaiusculaMinusculaAscII(frase);
		
	}
	//Posso fazer uma função que verifica se letra é maúscula ou minúscula, utilizando o Character
	//para verificar se letra é realmente uma letra, e depois verificar se é maiúsculo ou minúscula
	public static void verificarMaiusculaMinuscula(String f) {
		
		char l;										//recebe a letra
		int upper = 0, lower = 0;
		
		for (int i = 0; i < f.length(); i++) {
			
			l = f.charAt(i);
			
			if (Character.isLetter(l)) {
				if (Character.isUpperCase(l)) {
					upper++;
				} else {
					lower++;
				}
			}
			
		}
		
		System.out.println("Maiúsculas: " + upper);
		System.out.println("Minúsculas: " + lower);
	}

	
	//Ou posso fazer a verificação das letras se são de A à Z ou de a à z
	public static void verificarMaiusculaMinusculaLetras(String f) {
		
		char l;
		int upper = 0, lower = 0;
		
		for (int i = 0; i < f.length(); i++) {
			
			l = f.charAt(i);
			
			if((l >= 'A' && l <= 'Z') || (l >= 'a' && l <= 'z')) {
				
				if (l >= 'A' && l <= 'Z') {
					upper++;
				} else {
					lower++;
				}
			} 
			
		}
		
		System.out.println("Maiúsculas: " + upper);
		System.out.println("Minúsculas: " + lower);
		
	}

	//Ou posso fazer a verificação das letras conforme tabela ASCII
	public static void verificarMaiusculaMinusculaAscII(String f) {
		
		char l;
		int upper = 0, lower = 0, ascII;
		
		for (int i = 0; i < f.length(); i++) {
			
			l = f.charAt(i);
			ascII = (int) l;
			
			//Conforme tabela ascII, de 65 à 90 são maiúsculas e de 97 à 122 são minúsculas. 
			if ((ascII >= 65 && ascII <= 90) || (ascII >= 97 && ascII <= 122)) {
				if (ascII >= 65 && ascII <= 90) {
					upper++;
				} else {				
					lower++;
				}				
			}
			
		}
		
		System.out.println("Maiúsculas: " + upper);
		System.out.println("Minúsculas: " + lower);

	}
}