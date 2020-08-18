package palindroma;

import java.util.ArrayList;

public class Palindroma {

	
	public Palindroma() {
		
	}

	//M�todo para verificar se � palindroma usando 'for'
	public void palindromaComFor(String f) {
		
		boolean palindroma = true;		
		ArrayList<String> frase = new ArrayList<String>();
		
		for (int i = 0; i < f.length(); i++) {
			//Se letra n�o for espa�o, adiciono letra no vetor
			if (f.charAt(i) != ' ') {
				//Adiciono o letra em mai�scula no vetor para comparar os valores. 
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
			System.out.println(f + " � palindroma.");
		} else {
			System.out.println(f + " n�o � palindroma.");
		}
		
	}

	//M�todo para verificar se � palindroma usando 'while'
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
			System.out.println(f + " � palindroma.");
		} else {
			System.out.println(f + " n�o � palindroma.");
		}
		
	}
}