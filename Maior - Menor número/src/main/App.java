package main;

import java.util.ArrayList;

import maiormenor.MaiorMenor;
import maiormenor.MaiorMenorComArray;

public class App {

	public static void main(String[] args) {		
		MaiorMenor m = new MaiorMenor();
		MaiorMenorComArray mArray = new MaiorMenorComArray();
		
		//Passo os valores por parâmetro
		m.maior(40, 50, 57);		//Recebe 3 numeros e encontra o maior deles
		m.menor(17, 04, 13);		//Recebe 3 números e encontra o menor deles
		
		//Crio um vetor e passo 'n' valores
		int [] n = {25, 2, 9};		//Meu vetor recebe 3 valores
		mArray.maior(n);			//Encontra o maior
		mArray.menor(n);			//Encontra o menor
		
		//Crio um Arraylist que recebe 'n' valores
		ArrayList<Integer> numero = new ArrayList<Integer>();
		numero.add(25);
		numero.add(1);
		numero.add(-1);
		mArray.maior(numero);		//Encontra o maior
		mArray.menor(numero);		//Encontra o menor
	}
	
}
