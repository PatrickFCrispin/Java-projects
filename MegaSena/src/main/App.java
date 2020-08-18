package main;

import java.util.Random;

public class App {	
	
	public static void main(String[] args) {
		int[] numSorteados = new int[6];
		int numero, numAux = 0;
		Random sort = new Random();
		
		System.out.println("N�meros sorteados:");
		
		for(int i = 0; i < 6; i++) { 	//6 primeiros n�meros
			numero = sort.nextInt(6)+1; //sorteia um numero (1 � 6)
			if (i == 0) { 				//o primeiro n�mero entra direto no vetor, pois � o primeiro...
				numSorteados[i] = numero;
				System.out.printf("[%d] = ", i+1);
				System.out.print(numSorteados[i]);
			} else {
				for (int j = 0; j < numSorteados.length; j++) { //do segundo em diante, come�o a verificar se j� n�o existe..
					if (numSorteados[j] == numero) {
						numero = sort.nextInt(6)+1;
						for (j = numSorteados.length-1; j >= 0; j--) { //depois de sortear um n�mero, verifico nos sorteados se ele n�o est� l�, percorrendo todos eles (j--)
							if (numSorteados[j] == numero) {
								numero = sort.nextInt(6)+1;
							} else {
								numAux = numero;
							}								
						}
					} else {
						numAux = numero;
					}
				}	
				numSorteados[i] = numAux;
				System.out.printf("\n[%d] = ", i+1);
				System.out.print(numSorteados[i]);
			}
		}		
	}
	
}