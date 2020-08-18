package main;
import java.util.Scanner;

import calculoAnoBissexto.CalculoAnoBissexto;

public class App {
	
	public static void main(String[] args) {
		
		int ano;
		Scanner scanner = new Scanner(System.in);
		CalculoAnoBissexto c = new CalculoAnoBissexto();
		
		System.out.print("Informe um ano: ");
		ano = scanner.nextInt();
		c.anoBissexto(ano);
		
	}

}