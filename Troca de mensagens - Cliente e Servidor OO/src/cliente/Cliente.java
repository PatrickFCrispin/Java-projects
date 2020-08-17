package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
	
	private Socket socket;
	private InputStream input;
	private OutputStream output;
	private static BufferedReader in;
	private static PrintStream out;
	
	public void iniciarConexao() {
		try {
			socket = new Socket("localhost", 3030);
			input = socket.getInputStream();
			output = socket.getOutputStream();			
			in = new BufferedReader(new InputStreamReader(input));
			out = new PrintStream(output);
			System.out.println("Cliente iniciado.");
			System.out.println("Iniciando a conexão com o sevidor.");
			System.out.println("Conexão com o servidor estabelecida.");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void encerrarConexao() {
		try {
			System.out.println("Encerrando a conexão com o servidor.");
			in.close();
			out.close();
			socket.close();
			System.out.println("Conexão com o servidor encerrada.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		Cliente cliente = new Cliente();
		cliente.iniciarConexao();
		
		String msg;
		Scanner scanner = new Scanner(System.in);
				
		while (true) {
			System.out.print("Digite uma mensagem: ");
			msg = scanner.nextLine();
			out.println(msg);
			
			if (msg.equals("sair")) {
				cliente.encerrarConexao();
				break;
			}
			
			msg = in.readLine();
			
			System.out.println("Mensagem recebida do servidor: " + msg);
		}
		
	}
}