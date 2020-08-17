package metodos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import agenda.Agenda;

public class Metodos{
	
	private Scanner leitor = new Scanner(System.in);
	private String nome;
	private long numero;
	private String numeroString;
	private Agenda agenda;
	private List<Agenda> lista = new ArrayList<Agenda>();
	private boolean encontrou;
	
	//construtor
	public Metodos() {
		
	}
	
	//m�todo para criar um novo contato
	public void novoContato() {
		agenda = new Agenda();
		System.out.println("*Novo contato*");
		System.out.print("Informe o nome: ");
		nome = leitor.nextLine();
		if (buscarNome(nome)) {
			System.out.println("Nome j� cadastrado!");
		}
		else {
			System.out.print("Informe o telefone: ");
			numeroString = leitor.nextLine();
			
			if (numeroString.contains(" ")) {
				System.out.println("N�mero inv�lido. N�mero cont�m espa�o(s)!");
			}
			else if (!numeroString.matches("[0-9]+")) { //verifica se cont�m algo diferente de n�meros
				System.out.println("N�mero inv�lido!");
			}
			else {
				numero = Long.parseLong(numeroString);
				agenda.setNome(nome);
				agenda.setNumero(numero);
				lista.add(agenda); //adicionamos o nome e o n�mero na lista
				System.out.println("Contato criado com sucesso!");
			}
		}
	}
	
	//m�todo para editar um contato
	public void editarContato() {
		if (tamanhoLista() == 0) {
			System.out.println("Lista vazia!");
		}
		else {
			encontrou = false;
			System.out.println("*Editar contato*");
			System.out.print("Informe o nome: ");
			nome = leitor.nextLine();
			if (buscarNome(nome)) {
				System.out.print("Informe o novo telefone: ");
				numeroString = leitor.nextLine();
				if (numeroString.contains(" ")) {
					System.out.println("N�mero inv�lido. N�mero cont�m espa�o(s)!");
				}
				else if (!numeroString.matches("[0-9]+")) { //verifica se cont�m algo diferente de n�meros
					System.out.println("N�mero inv�lido!");
				}
				else {
					numero = Long.parseLong(numeroString);
					for (int i = 0; i < lista.size(); i++) {
						if (lista.get(i).getNome().equals(nome)) {
							lista.get(i).setNumero(numero);
						}
					}
					System.out.println("Contato editado com sucesso!");
				}
			}
			else {
				System.out.println("Nome n�o encontrado!");
			}
		}
	}
	
	//m�todo para printar os contatos salvos na lista
	public void mostrarAgenda() {
		if (tamanhoLista() == 0) {
			System.out.println("Lista vazia!");
		}
		else {
			System.out.println("*Contatos salvos*");
			for (int i = 0; i < lista.size(); i++) {
				System.out.println(lista.get(i).getNome() + " - " + lista.get(i).getNumero());
			}
		}
	}
	
	//m�todo para verificar o tamanho da lista
	public int tamanhoLista() {
		return lista.size();
	}
	
	public boolean buscarNome(String nome) {
		encontrou = false;
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getNome().equals(nome)) {
				encontrou = true;
			}
		}
		return encontrou;
	}
	
	//m�todo para remover um contato
	public void removerContato() {
		if (tamanhoLista() == 0) {
			System.out.println("Lista vazia!");
		}
		else {
			System.out.println("*Remover contato*");
			System.out.print("Informe o nome: ");
			nome = leitor.nextLine();
			if (buscarNome(nome)) {
				for (int i = 0; i < lista.size(); i++) {
					if (lista.get(i).getNome().equals(nome)) {
						lista.remove(i);
					}
				}
				System.out.println("Contato removido com sucesso!");
			}
			else {
				System.out.println("Nome n�o encontrado!");
			}
		}
	}
	
	//m�todo para remover todos os contatos
	public void removerContatos() {
		if (tamanhoLista() == 0) {
			System.out.println("Lista vazia!");
		}
		else {
			lista.clear();
			System.out.println("Contatos removidos com sucesso!");
		}
	}
	
}