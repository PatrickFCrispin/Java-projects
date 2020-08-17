package server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import fileShared.FileShared;

public class Server {
	
	private String pastaServidor;
	private Scanner scanner = new Scanner(System.in);
	private ServerSocket serverSocket = null;
	private Socket socket = null;
	private static BufferedReader bufferedReader = null;
	private static PrintStream printStream = null;
	public static ArrayList<String> listaDeArquivos = new ArrayList<String>();
	private String nameArquivo;
	public boolean encontrouCod = false;

	//Solicita ao cliente o local para upload dos arquivos no servidor
	public void informarServidor() {
		System.out.println("Informe o local do Servidor");
		System.out.println("Exemplo: C:\\Users\\Fabiana\\Desktop\\Server");
        System.out.print("Informar: ");
		pastaServidor = scanner.nextLine();
        pastaServidor.trim();
	}
	
    //Inicia a conexão com o servidor
	public void iniciarConexao() {
		try {
			System.out.println("Iniciando o Servidor..");
			serverSocket = new ServerSocket(3030); //pode ser alterada a porta. 
			System.out.println("Servidor iniciado.");
			System.out.println("Servidor apontando para --> " + pastaServidor);
			System.out.println("Servidor aguardando a conexão do cliente..");
			socket = serverSocket.accept();
			System.out.println("Conexão estabelecida.");
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			printStream = new PrintStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Encerra a conexão com o servidor
    public void encerrarConexao() {
		try {
			System.out.println("Encerrando a conexão com o cliente..");
			bufferedReader.close();
			printStream.close();
			socket.close();
			System.out.println("Conexão encerrada.");
			System.out.println("Encerrando o servidor..");
			serverSocket.close();
			System.out.println("Servidor encerrado.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Verifica se existem arquivos armazenados na pasta do servidor. Se sim, adiciona ao array de arquivos.
    public void atualizarServidor() {
    	listaDeArquivos.clear();	//limpo o array a cada chamada para sempre mante-lo atualizado
    	File servidor = new File(pastaServidor);
    	for (File arquivo : servidor.listFiles()) {
       		listaDeArquivos.add(arquivo.getName());
    	}
    }
    
	//Recebe o arquivo enviado pelo cliente
    public void uploadArquivo(){
        try {
        	ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        	FileShared fileShared = (FileShared) objectInputStream.readObject();
            System.out.println(fileShared.msgUploadSucess());
            armazenarArquivo(fileShared.getBytes(), fileShared.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Armazena o arquivo enviado pelo cliente
    public void armazenarArquivo(byte buffer[], String name){
        String path = pastaServidor + File.separator + name;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            fileOutputStream.write(buffer);
            fileOutputStream.flush();
            fileOutputStream.close();
            armazenarNoArray(name); //armazena o nome do arquivo no array de arquivos
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //Armazena o arquivo recebido do cliente em nosso array
    public void armazenarNoArray(String name) {
    	boolean existe = false;
    	for (int i = 0; i < listaDeArquivos.size(); i++) {
    		if (name.equals(listaDeArquivos.get(i))) {
    			existe = true;
			}
		}
    	//Se o arquivo não existe, é adicionado ao array de arquivos. É feito dessa forma para que na listagem do 
    	//cliente os numerados fiquem corretos e não seja listado, por exemplo, o mesmo nome de arquivo duas vezes ou mais
    	if (!existe) {
			listaDeArquivos.add(name);
		}
    }
    
    //Lista os arquivos armazenados no servidor
    public void listarArquivosArmazenados() {
    	atualizarServidor();
    	int index = 0;
		System.out.println("List");
		if (getSizelistaDeArquivos() == 0) {
			System.out.println("Nenhum arquivo armazenado no servidor.");
		} else {
	    	for (int i = 0; i < listaDeArquivos.size(); i++) {
	    		index++;
				System.out.println(index + " - " + listaDeArquivos.get(i));
			} 
		}
    }
    
    //Busca código recebido na lista de arquivos armazenados
    public boolean buscarCodigo(int cod) {
    	boolean encontrouCodigo = false;
    	int index = 0;
    	for (int i = 0; i < listaDeArquivos.size(); i++) {
    		index++;
    		if (cod == index) {
    			encontrouCodigo = true;
    			nameArquivo = listaDeArquivos.get(i);
			}
		}
    	return encontrouCodigo;
    }
    
    //Retorna o nome do arquivo encontrado no servidor.
    public String getNameArquivo() {
    	return nameArquivo;
    }
    
    //Retorna o tamanho do array listaDeArquivos.
    public int getSizelistaDeArquivos() {
    	return listaDeArquivos.size();
    }
    
    //Realiza o download do arquivo
    public void downloadArquivo() {
    	try {
			String path = pastaServidor + File.separator + getNameArquivo();
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
    
	public static void main(String[] args) throws IOException {
		Server server = new Server();
		server.informarServidor();
		server.iniciarConexao();
		server.atualizarServidor();
		
		String comando = "";
		String[] parts;
		String codString;
		int cod;
		
		while (!comando.equals("sair")) {
			comando = bufferedReader.readLine();			
			System.out.println("Comando recebido do cliente: " + comando);			
			if (comando.equals("sair")) {
				server.encerrarConexao();
				break;
			} else if (comando.equals("list")) {
				server.listarArquivosArmazenados();
				continue;
			} else if (comando.equals("up")) {
				server.uploadArquivo();
				continue;
			} else if (comando.startsWith("down")) {
				if (comando.contains(" ")) {
					parts = comando.split(" ");
					comando = parts[0];
					codString = parts[1];
					if (codString.matches("[0-9]+")) { //verifica se é um número
						cod = Integer.parseInt(codString); //cod recebe o número
						if (server.getSizelistaDeArquivos() == 0) {	//se nenhum arquivo no servidor...
							System.out.println("Nenhum arquivo armazenado no Servidor.");
						} else {	//se não...
							System.out.println("Código recebido: " + cod);
							if (server.buscarCodigo(cod)) {
								System.out.println("Arquivo solicitado: " + server.getNameArquivo());
								server.downloadArquivo();
							} else {
								System.out.println("Código não encontrado.");
							}
						}
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
			printStream.println(comando);
		}
	}
}