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
	
public static void main(String[] args) throws UnknownHostException, IOException {
		
	System.out.println("Cliente iniciado.");
	
	System.out.println("Iniciando conexão com o servidor.");
		
	Socket s = new Socket("localhost", 2525);
	
	System.out.println("Conexão estabelecida.");
		
	InputStream input = s.getInputStream();
		
	OutputStream output = s.getOutputStream();
		
	BufferedReader in = new BufferedReader(new InputStreamReader(input));
		
	PrintStream out = new PrintStream(output);
		
	Scanner scanner = new Scanner(System.in);
		
	while(true) {
			
		System.out.print("Digite uma mensagem: ");
			
		String msg = scanner.nextLine();
			
		out.println(msg);
			
		if (msg.equals("sair")) {
			break;
		}
			
		msg = in.readLine();
			
		System.out.println("Mensagem recebida do servidor: " + msg);
			
	}
		
	System.out.println("Encerrando conexão.");
		
	in.close();
		
	out.close();
		
	s.close();
		
	System.out.println("Conexão encerrada.");
		
	}
}