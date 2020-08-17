import java.util.Scanner;

import servidor.Servidor;

public class AppServidor {
	
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		int opcao = 0;
		Servidor servidor = new Servidor();
		
		do {
			System.out.println("*Servidor de arquivos - [0] para sair*");
			System.out.println("[1] - Informar o Servidor");
			System.out.println("[2] - Atualizar o Servidor");
			System.out.println("[3] - Exibir arquivos armazenados no Servidor");
			System.out.println("[4] - Enviar arquivo para o Servidor");
			System.out.println("[0] - Sair");
			System.out.print("Opção: ");
			opcao = leitor.nextInt();
			
			switch (opcao) {
				case 1:
					System.out.println("");
					servidor.informarServidor();
					System.out.println("");
					break;
				case 2:
					System.out.println("");
					servidor.atualizarServidorComMsg();
					System.out.println("");
					break;
				case 3:
					System.out.println("");
					servidor.exibirArquivos();
					System.out.println("");
					break;
				case 4:
					System.out.println("");
					servidor.recebeArquivo();
					System.out.println("");
					break;
				case 0:
					System.out.println("");
					System.out.println("Programa encerrado.");
					break;
				default:
					System.out.println("");
					System.out.println("Opção inválida!");
					System.out.println("");
					break;
				}
		} while(opcao != 0);
	}
	
}