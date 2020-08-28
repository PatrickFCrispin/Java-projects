package maiormenor;

import java.util.ArrayList;

public class MaiorMenorComArray {

	public MaiorMenorComArray() {
		
	}
	
	//Com vetor de inteiros
	public void maior(int[] n) {		
		int maior = n[0]; //'maior' recebe sempre o primeiro item
		for (int i = 0; i < n.length; i++) {
			if(n[i] > maior) {	//Verifico se algum item é maior que o 'maior'
				maior = n[i];
			}
		}		
		System.out.println("O maior número é: " + maior);
	}
	
	public void menor(int[] n) {		
		int menor = n[0];		
		for (int i = 0; i < n.length; i++) {
			if(n[i] < menor) {
				menor = n[i];
			}
		}		
		System.out.println("O menor número é: " + menor);
	}
	
	//Com Array utilizando o ArrayList
	public void maior(ArrayList<Integer> numero) {
		int maior = numero.get(0);	//'maior' recebe o primeiro item
		for (int i = 0; i < numero.size(); i++) {
			if (numero.get(i) > maior) {	//Verifico se algum item é maior que o 'maior'
				maior = numero.get(i);
			}
		}
		System.out.println("O maior número é: " + maior);
	}
	
	public void menor(ArrayList<Integer> numero) {
		int menor = numero.get(0);
		for (int i = 0; i < numero.size(); i++) {
			if (numero.get(i) < menor) {
				menor = numero.get(i);
			}
		}
		System.out.println("O menor número é: " + menor);
	}
}
