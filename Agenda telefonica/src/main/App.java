package main;

import java.util.Scanner;

import metodos.Metodos;

public class App {

	public static void main(String[] args) {
		
		int opcao;
		Scanner leitor = new Scanner(System.in);
		Metodos metodo = new Metodos();
		
		do {
			System.out.println("**Agenda telefonica**");
			System.out.println("[1] - Criar novo contato");
			System.out.println("[2] - Editar um contato");
			System.out.println("[3] - Mostrar contatos");
			System.out.println("[4] - Remover um contato");
			System.out.println("[5] - Remover todos os contatos");
			System.out.println("[0] - Sair");
			System.out.print("Opção: ");
			opcao = leitor.nextInt();
			leitor.nextLine();
			
			if (opcao == 1) {
				System.out.println("");
				metodo.novoContato();
				System.out.println("");
			}
			else if (opcao == 2) {
				System.out.println("");
				metodo.editarContato();
				System.out.println("");
			}
			else if (opcao == 3) {
				System.out.println("");
				metodo.mostrarAgenda();
				System.out.println("");
			}
			else if (opcao == 4) {
				System.out.println("");
				metodo.removerContato();
				System.out.println("");
			}
			else if (opcao == 5) {
				System.out.println("");
				metodo.removerContatos();
				System.out.println("");
			}
			else if (opcao == 0) {
				System.out.println("");
				System.out.println("Programa encerrado.");
			}
			else {
				System.out.println("");
				System.out.println("Opção inválida!");
				System.out.println("");
			}
		} while(opcao!=0);
	}
	
}