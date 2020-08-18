package main;

import java.util.Random;

public class App {	
	
	public static void main(String[] args) {
		int[] numSorteados = new int[6];
		int numero, numAux = 0;
		Random sort = new Random();
		
		System.out.println("Números sorteados:");
		
		for(int i = 0; i < 6; i++) { 	//6 primeiros números
			numero = sort.nextInt(6)+1; //sorteia um numero (1 à 6)
			if (i == 0) { 				//o primeiro número entra direto no vetor, pois é o primeiro...
				numSorteados[i] = numero;
				System.out.printf("[%d] = ", i+1);
				System.out.print(numSorteados[i]);
			} else {
				for (int j = 0; j < numSorteados.length; j++) { //do segundo em diante, começo a verificar se já não existe..
					if (numSorteados[j] == numero) {
						numero = sort.nextInt(6)+1;
						for (j = numSorteados.length-1; j >= 0; j--) { //depois de sortear um número, verifico nos sorteados se ele não está lá, percorrendo todos eles (j--)
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