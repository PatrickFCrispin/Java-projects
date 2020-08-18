package main;
import java.util.Scanner;

import palindroma.Palindroma;

public class App {
	
	public static void main(String[] args) {
		
		String frase;
		Scanner scanner = new Scanner(System.in);
		Palindroma p = new Palindroma();
		
		System.out.print("Informe uma frase ou palavra: ");
		frase = scanner.nextLine();
		p.palindromaComFor(frase);
		p.palindromaComWhile(frase);
		
	}

}