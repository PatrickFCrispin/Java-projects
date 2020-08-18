package main;

public class App {
	
	public static void main(String[] args) {

		String frase, quebra = "";
		int colunas;
		boolean temEspaco = false;
		int posEsp = 0;
		
		frase = "Um pequeno jabuti xereta viu dez cegonhas felizes.";
		colunas = 20;
		
		if (frase.length() <= colunas) {	//Se tamanho da frase menor que colunas, s� imprime a frase
			System.out.println(frase);
		} else {							//Se n�o...
			int j = 0;
			int i = 0;
				while(j < frase.length()) {	//Enquanto j for menor que tamanho da frase...
					temEspaco = false;
					//Se frase menor que colunas, imprime a frase
					if (frase.length() < colunas) {
						System.out.println(frase);
					} else {	//Se n�o...
						//Verifico se existem espa�os na frase e se ocorrem antes do numero de colunas
						for (i = 0; i < frase.length(); i++) {
							if (frase.charAt(i) == ' ' && i <= colunas) {
								temEspaco = true;
							}
						}
						//Se achar algum espa�o antes do n�mero de colunas, pego o ultimo espa�o encontrado e atribuo � 'posEsp'
						if (temEspaco) {
							while (j <= colunas) {
								if (frase.charAt(j) == ' ') {
									posEsp = j;
								}
								j++;
							}
							
							//Fa�o minha vari�vel "quebra" receber as letras at� o �ltimo espa�o encontrado
							for (i = 0; i <= posEsp; i++) {
								quebra += frase.charAt(i);
							}
							//Imprimo
							System.out.println(quebra);
							//Zero a vari�vel "quebra"
							quebra = "";

							//A partir do �ltimo espa�o encontrado at� o final da frase, � minha vari�vel "quebra" recebe frase
							for (int k = posEsp + 1; k < frase.length(); k++) {
								quebra += frase.charAt(k);
							}
						} else {	//Se n�o achou espa�os e a qtd de letras � maior que colunas, imprime a msg abaixo
							System.out.println("Imposs�vel quebrar a linha! Nenhum espa�o encontrado.");
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
