package main;

import ordenador.Ordenador;

public class App {

	static Integer [] numeros = {2, 7, 1, 3, 5, 1, 11, 0};	

	public static void main(String[] args) {
		System.out.println("Sequencia não ordenada:");
		for (int i = 0; i < numeros.length; i++) {
			System.out.println(numeros[i]);
		}
		System.out.println("Sequencia ordenada em ordem crescente:");
		Ordenador o = new Ordenador();
		o.ordenar(numeros);
	}
}