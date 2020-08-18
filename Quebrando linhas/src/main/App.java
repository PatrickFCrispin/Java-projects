package main;

public class App {
	
	public static void main(String[] args) {

		String frase, quebra = "";
		int colunas;
		boolean temEspaco = false;
		int posEsp = 0;
		
		frase = "Um pequeno jabuti xereta viu dez cegonhas felizes.";
		colunas = 20;
		
		if (frase.length() <= colunas) {	//Se tamanho da frase menor que colunas, só imprime a frase
			System.out.println(frase);
		} else {							//Se não...
			int j = 0;
			int i = 0;
				while(j < frase.length()) {	//Enquanto j for menor que tamanho da frase...
					temEspaco = false;
					//Se frase menor que colunas, imprime a frase
					if (frase.length() < colunas) {
						System.out.println(frase);
					} else {	//Se não...
						//Verifico se existem espaços na frase e se ocorrem antes do numero de colunas
						for (i = 0; i < frase.length(); i++) {
							if (frase.charAt(i) == ' ' && i <= colunas) {
								temEspaco = true;
							}
						}
						//Se achar algum espaço antes do número de colunas, pego o ultimo espaço encontrado e atribuo à 'posEsp'
						if (temEspaco) {
							while (j <= colunas) {
								if (frase.charAt(j) == ' ') {
									posEsp = j;
								}
								j++;
							}
							
							//Faço minha variável "quebra" receber as letras até o último espaço encontrado
							for (i = 0; i <= posEsp; i++) {
								quebra += frase.charAt(i);
							}
							//Imprimo
							System.out.println(quebra);
							//Zero a variável "quebra"
							quebra = "";

							//A partir do último espaço encontrado até o final da frase, à minha variável "quebra" recebe frase
							for (int k = posEsp + 1; k < frase.length(); k++) {
								quebra += frase.charAt(k);
							}
						} else {	//Se não achou espaços e a qtd de letras é maior que colunas, imprime a msg abaixo
							System.out.println("Impossível quebrar a linha! Nenhum espaço encontrado.");
						}
					}
					//Minha "frase" recebe a quebra que tem o resto da frase
					frase = quebra;
					quebra = "";
					//Meu j = 0, pois como a frase mudou, vou varre-la novamente
					j = 0;
				}
		}
				
	}

}
