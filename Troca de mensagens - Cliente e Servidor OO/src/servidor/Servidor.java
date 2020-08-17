package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	
	private ServerSocket serverSocket;
	private Socket socket;
	private InputStream input;
	private OutputStream output;
	private static BufferedReader in;
	private static PrintStream out;
	
	public void iniciarConexao() {
		try {
			System.out.println("Servidor iniciado.");
			serverSocket = new ServerSocket(3030);
			System.out.println("Aguardando a conexão do cliente.");
			socket = new Socket();
			socket = serverSocket.accept();
			input = socket.getInputStream();
			output = socket.getOutputStream();
			in = new BufferedReader(new InputStreamReader(input));
			out = new PrintStream(output);
			System.out.println("Conexão estabelecida.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void encerrarConexao() {
		try {
			System.out.println("Encerrando a conexão com o cliente.");
			in.close();
			out.close();
			socket.close();
			System.out.println("Encerrando o servidor.");
			serverSocket.close();
			System.out.println("Servidor encerrado.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		Servidor servidor = new Servidor();
		servidor.iniciarConexao();
		
		String msg;
		
		while (true) {
			msg = in.readLine();
			
			System.out.println("Mensagem recebida do cliente: " + msg);
			
			if (msg.equals("sair")) {
				servidor.encerrarConexao();
				break;
			}
			
			out.println(msg);
		}
		
	}	
}