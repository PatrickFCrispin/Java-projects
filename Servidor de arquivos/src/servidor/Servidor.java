package servidor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Servidor {

	private String servidor = "";
	private Scanner leitor = new Scanner(System.in);
	private List<File> arquivos = new ArrayList<File>();
	//private List<String> arquivos = new ArrayList<String>();
	private ObjectInputStream objectInputStream;
	
	//construtor
	public Servidor() {
		
	}
	
	//método que recebe o caminho do servidor
	public void informarServidor() {
		System.out.print("Informe a pasta do servidor: ");
		servidor = leitor.nextLine();
		servidor.trim();
		File fservidor = new File(servidor);
		if (fservidor.isDirectory()) {
			System.out.println("Servidor em --> " + servidor);
			setServidor(servidor);
		}
		else {
			servidor = "";
			System.out.println("Servidor inválido!");
			setServidor(servidor);
		}
	}
	
	public String getServidor() {
		return servidor;
	}

	public void setServidor(String servidor) {
		this.servidor = servidor;
	}

	//atualiza o servidor com os arquivos armazenados nele
	public void atualizarServidor() {		
		if (getServidor().isEmpty()) {
			System.out.println("Informe o Servidor!");
		}
		else {		
			arquivos.clear();								//zero a lista, para não adicionar o mesmo arquivo mais de 1x
			File fservidor = new File(servidor);
			for (File arquivo : fservidor.listFiles()) {	//para cada arquivo no servidor
				arquivos.add(arquivo);						//adiciono o arquivo na lista de arquivos 'arquivos'
			}				
			//se usasse a lista de arquivos do tipo <String>, ficaria assim:
			/*
			for (File arquivo : fservidor.listFiles()) {
				if (arquivo.isFile()) {
					arquivos.add(arquivo.getName());
				}
			}
			*/
		}
	}
	
	//atualiza o servidos com os arquivos armazenados nele e informa a qtd de arquivos
	public void atualizarServidorComMsg() {
		if (getServidor().isEmpty()) {
			System.out.println("Informe o Servidor!");
		}
		else {
			arquivos.clear();
			int count = 0;
			File fservidor = new File(servidor);
			for (File arquivo : fservidor.listFiles()) {
				arquivos.add(arquivo);
				count++;
			}
			System.out.println("Servidor atualizado com sucesso! " + count + " arquivo(s) armazenado(s).");
		}			
	}
	
	//retornar a quantidade de arquivos armazenados no servidor
	public int qtdArquivos() {
		atualizarServidor();
		return arquivos.size();
	}
	
	//exibe os arquivos armazenados no servidor
	public void exibirArquivos() {
		if (getServidor().isEmpty()) {
			System.out.println("Informe o Servidor!");
		}
		else {		
			int index = 0;
			if (qtdArquivos() == 0) {
				System.out.println("Nenhum arquivo armazenado no Servidor.");
			}
			else {
				System.out.println("Exibindo arquivos do servidor...");
				for (File arquivo : arquivos) {
					index++;
					System.out.println(index + " - " + arquivo.getName());
				}
				
				//se usasse a lista de arquivos do tipo <String>, poderia usar assim:
				/*
				for (int i = 0; i < arquivos.size(); i++) {
					index++;
					System.out.println(index + " - " + arquivos.get(i));
				}
				*/
			}
		}
	}
		
	//recebe arquivo / upload para o servidor
	public void recebeArquivo() {
		if (getServidor().isEmpty()) {
			System.out.println("Informe o Servidor!");
		}
		else {
			System.out.print("Informe a origem + nome do arquivo: ");
			String origem = leitor.nextLine();
			origem.trim();
			File arquivo = new File(origem);    										//recebe o origem + nome do arquivo

			if (arquivo.isFile()) {														//verifica se é um arquivo		
				String destino = servidor + File.separator + arquivo.getName(); 		//recebe o caminho do servidor + nome do arquivo
				try {
					byte[] buffer = new byte[128];
			        int qtd;
			        
			        FileInputStream in = new FileInputStream(arquivo);					//origem do arquivo
					FileOutputStream out = new FileOutputStream(destino);				//destino do arquivo
							
			        while ((qtd = in.read(buffer)) > 0) {
			            out.write(buffer, 0, qtd);
			        }
			        
			        out.flush();
			        out.close();
			        in.close();
			        
					System.out.println("Arquivo " + arquivo.getName() + " transferido com sucesso!");
	
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else {
				System.out.println("Arquivo não encontrado!");
			}
		}
	}
	
}