package client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import fileShared.FileShared;
import server.Server;

public class Client {
	
	private Socket socket = null;
	private static BufferedReader bufferedReader = null;
	private static PrintStream printStream = null;
	private static Scanner scanner = new Scanner(System.in);
	private String pastaDownload;

	//Inicia a conexão com o servidor
	public void iniciarConexao() {
		try {
			System.out.println("Iniciando o cliente..");
			socket = new Socket("localhost", 3030);
			System.out.println("Cliente iniciado.");
			System.out.println("Cliente iniciando a conexão com o sevidor..");
			System.out.println("Conexão estabelecida.");
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			printStream = new PrintStream(socket.getOutputStream());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Encerra a conexão com o servidor
	public void encerrarConexao() {
		try {
			System.out.println("Encerrando a conexão com o servidor..");
			bufferedReader.close();
			printStream.close();
			socket.close();
			System.out.println("Conexão encerrada.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Envia um arquivo para o servidor
	public void uploadArquivo(){
        try {
        	System.out.println("Informe o local + nome do arquivo para upload");
			System.out.println("Exemplo: C:\\Users\\Fabiana\\Desktop\\Client\\nome_do_arquivo.jpg");
            System.out.print("Informar: ");
            String path = scanner.nextLine();
            path.trim();
            
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

            File file = new File(path);
            FileInputStream fileInputStream = new FileInputStream(file);
            byte memory[] = new byte[(int)file.length()];
            fileInputStream.read(memory);
            
            FileShared fileShared = new FileShared(memory, file.getName());
            objectOutputStream.writeObject(fileShared);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	//Recebe o arquivo enviado pelo servidor
    public void downloadArquivo(){
        try {
        	System.out.println("Informe o local de download");
    		System.out.println("Exemplo: C:\\Users\\Fabiana\\Desktop\\Downloads");
            System.out.print("Informar: ");
    		pastaDownload = scanner.nextLine();
            pastaDownload.trim();
        	ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        	FileShared fileShared = (FileShared) objectInputStream.readObject();
            System.out.println(fileShared.msgDownloadSucess());
            armazenarArquivo(fileShared.getBytes(), fileShared.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Armazena o arquivo recebido do servidor na pasta informada
    public void armazenarArquivo(byte buffer[], String name){
        String path = pastaDownload + File.separator + name;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            fileOutputStream.write(buffer);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }	
		
	public static void main(String[] args) throws UnknownHostException, IOException {
		Client client = new Client();
		client.iniciarConexao();
						
		String comando = "";
		String[] parts;
		String codString;
		int cod;
		Server server = new Server();
		
		while (!comando.equals("sair")) {
			System.out.println("Entre com o comando desejado: sair | down COD | list | up");
			System.out.print("comando: ");
			comando = scanner.nextLine();
			comando.trim();
			printStream.println(comando);						
			if (comando.equals("sair")) {
				client.encerrarConexao();
				break;
			} else if (comando.equals("list")) {
				continue;
			} else if (comando.equals("up")) {
				client.uploadArquivo();
				continue;
			} else if (comando.startsWith("down")) {
				if (comando.contains(" ")) {
					parts = comando.split(" ");
					comando = parts[0];
					codString = parts[1];
					if (codString.matches("[0-9]+")) { //verifica se é um número
						cod = Integer.parseInt(codString); //cod recebe o número
						System.out.println("Código enviado: " + cod);
						client.downloadArquivo();
					} else {
						System.out.println("Comando inválido!");
					}
				} else {
					System.out.println("Comando inválido!");
				}
				continue;
			} else {
				System.out.println("Comando inválido!");
			}			
			comando = bufferedReader.readLine();			
		}	
	}
}