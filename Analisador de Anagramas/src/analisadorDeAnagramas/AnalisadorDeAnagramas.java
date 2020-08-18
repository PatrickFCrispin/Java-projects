package analisadorDeAnagramas;
import java.util.ArrayList;

//ESTE PROGRAMA RETORNA A QUANTIDADE DE ANAGRAMAS POSSÍVEIS A SEREM GERADOS COM UMA DETERMINADA PALAVRA.

public class AnalisadorDeAnagramas {
	
	static ArrayList<String> letras = new ArrayList<>();
	static ArrayList<String> letraRept = new ArrayList<>();
	static ArrayList<Integer> contRept = new ArrayList<>();
	
	public static void getPalavra(String p) {
		p = p.toLowerCase();
		
		//pego as letras e salvo no array 'letras'
		for (int i = 0; i < p.length(); i++) {
			letras.add(String.valueOf(p.charAt(i)));
		}
		
		//verifico se existem letras repetidas no array
		encontraLetraRetp(p, letras);
	}
	
	public static void encontraLetraRetp(String p, ArrayList<String> letras) {
		int j, cont = 0;
		String letra = "";
		boolean encontrou = false;
		
		//verifico se a letra se repete somando o contador
		for (int i = 0; i < letras.size(); i++) {
			letra = String.valueOf(letras.get(i));
			j = 0;
			cont = 0;
			while(j < letras.size()) {
				if(letra.equals(letras.get(j)))
					cont++;
				j++;
			}
			
			//se cont > 1 é porque a letra apareceu mais de uma vez na palavra, ou seja, repetiu.
			//se repetiu, adiciono a letra no array letraRept junto com a quantidade de repetições.
			if (cont > 1) {
				if (letraRept.isEmpty()) {
					letraRept.add(letra);
					contRept.add(cont);
				} else {
					for (String l : letraRept) {
						if(l.equals(letra)) {
							encontrou = true;
						}
					}
					if (!encontrou) {
						letraRept.add(letra);
						contRept.add(cont);
					}
				}
			}
		}
		
		//informa se existem letras repetidas
		if (letraRept.isEmpty()) {
			System.out.println("Nenhuma letra repetida.");
		} else {
			System.out.println("Letra repetida: " + letraRept + " Quantidade: " + contRept);
		}
		
		//Chama o analisador de anagramas
		anagrama(p);
		
	}
	
	//gera a qtd de anagramas possíveis para uma palavra
	public static void anagrama(String p) {
		int qtdAnagramas = letras.size();
		int j = qtdAnagramas-1;
		
		//calcula o fatorial da palavra
		while(j > 0) {
			qtdAnagramas *= j;
			j--;
		}
		
		//se não tiver letras repetidas, basta printar a qtdAnagramas
		if (contRept.isEmpty()) {		
			System.out.print("Qtd de anagramas possíveis com a palavra '" + p + "': " + qtdAnagramas);
		} else {
			int total = 1;
			for (int i = 0; i < contRept.size(); i++) {
				j = contRept.get(i);
				int k = j-1;
				while(k > 0) {
					j *= k;
					k--;
				}
				total *= j;
			}
			qtdAnagramas /= total;
			System.out.print("Qtd de anagramas possíveis com a palavra '" + p + "': " + qtdAnagramas);
		}
	}
	
}