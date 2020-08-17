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

public static void main(String[] args) throws IOException {
		
	System.out.println("Servidor iniciado.");
		
	ServerSocket ss = new ServerSocket(2525);
		
	System.out.println("Aguardando conexão.");
	
	Socket s = ss.accept();
		
	System.out.println("Conexão estabelecida.");
		
	InputStream input = s.getInputStream();
		
	OutputStream output = s.getOutputStream();
		
	BufferedReader in = new BufferedReader(new InputStreamReader(input));
		
	PrintStream out = new PrintStream(output);
		
	while (true) {
		String msg = in.readLine();
			
		System.out.println("Mensagem recebida do cliente: " + msg);
			
		if (msg.equals("sair")) {
			break;
		}
			
		out.println(msg);
	}
	
	System.out.println("Programa encerrado.");
		
	in.close();
		
	out.close();
		
	s.close();
		
	System.out.println("Encerrando servidor..");
		
	ss.close();
		
	System.out.println("Servidor encerrado.");
	
	}
}