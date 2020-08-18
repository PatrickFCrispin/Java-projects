package main;

public class App {
	
	public static void main(String[] args) {
		
		String frase = "ab C DE";
		verificarMaiusculaMinuscula(frase);	
		verificarMaiusculaMinusculaLetras(frase);
		verificarMaiusculaMinusculaAscII(frase);
		
	}
	//Posso fazer uma fun��o que verifica se letra � ma�scula ou min�scula, utilizando o Character
	//para verificar se letra � realmente uma letra, e depois verificar se � mai�sculo ou min�scula
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
		
		System.out.println("Mai�sculas: " + upper);
		System.out.println("Min�sculas: " + lower);
	}

	
	//Ou posso fazer a verifica��o das letras se s�o de A � Z ou de a � z
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
		
		System.out.println("Mai�sculas: " + upper);
		System.out.println("Min�sculas: " + lower);
		
	}

	//Ou posso fazer a verifica��o das letras conforme tabela ASCII
	public static void verificarMaiusculaMinusculaAscII(String f) {
		
		char l;
		int upper = 0, lower = 0, ascII;
		
		for (int i = 0; i < f.length(); i++) {
			
			l = f.charAt(i);
			ascII = (int) l;
			
			//Conforme tabela ascII, de 65 � 90 s�o mai�sculas e de 97 � 122 s�o min�sculas. 
			if ((ascII >= 65 && ascII <= 90) || (ascII >= 97 && ascII <= 122)) {
				if (ascII >= 65 && ascII <= 90) {
					upper++;
				} else {				
					lower++;
				}				
			}
			
		}
		
		System.out.println("Mai�sculas: " + upper);
		System.out.println("Min�sculas: " + lower);

	}
}