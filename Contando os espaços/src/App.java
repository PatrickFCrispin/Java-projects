import java.util.Scanner;

import Operacoes.ContadorDeEspacos;

public class App {

	public static void main(String[] args) {
		
		String frase;
		Scanner scanner = new Scanner(System.in);
		ContadorDeEspacos c = new ContadorDeEspacos();
		
		System.out.print("Informe uma frase: ");
		frase = scanner.nextLine();
		c.contadorDeEspacos(frase);
		c.contadorDeEspacosComVetor(frase);
		
	}
	
}
