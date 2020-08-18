package main;

import analisadorDeAnagramas.AnalisadorDeAnagramas;

public class App {

	public static void main(String[] args) {
		AnalisadorDeAnagramas a = new AnalisadorDeAnagramas();
		String palavra = "infini";
		a.getPalavra(palavra);
	}
	
}