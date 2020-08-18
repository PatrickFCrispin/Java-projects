package palindroma;

import java.util.ArrayList;

public class Palindroma {

	
	public Palindroma() {
		
	}

	//Método para verificar se é palindroma usando 'for'
	public void palindromaComFor(String f) {
		
		boolean palindroma = true;		
		ArrayList<String> frase = new ArrayList<String>();
		
		for (int i = 0; i < f.length(); i++) {
			//Se letra não for espaço, adiciono letra no vetor
			if (f.charAt(i) != ' ') {
				//Adiciono o letra em maiúscula no vetor para comparar os valores. 
				//Poderia ter usado 'toLowerCase()' que funcionaria igual.
				frase.add(String.valueOf(Character.toUpperCase(f.charAt(i))));
			}
		}
				
		int j = frase.size() - 1;
		//Utilizando o for
		for (int i = 0; i < frase.size(); i++) {
			if (!frase.get(i).equals(frase.get(j))) {
				palindroma = false;
			}
			j--;
		}
		
		if (palindroma) {
			System.out.println(f + " é palindroma.");
		} else {
			System.out.println(f + " não é palindroma.");
		}
		
	}

	//Método para verificar se é palindroma usando 'while'
	public void palindromaComWhile(String f) {
		
		boolean palindroma = true;
		ArrayList<String> frase = new ArrayList<String>();
		
		int i = 0;
		while (i < f.length()) {
			if (f.charAt(i) != ' ') {
				frase.add(String.valueOf(Character.toUpperCase(f.charAt(i))));
			}
			i++;
		}
		
		i = 0;
		int j = frase.size() - 1;
		//Utilizando o while()
		while (i < frase.size()) {
			if(!frase.get(i).equals(frase.get(j))) {
				palindroma = false;
			}		
			j--;
			i++;
		}
		
		if (palindroma) {
			System.out.println(f + " é palindroma.");
		} else {
			System.out.println(f + " não é palindroma.");
		}
		
	}
}