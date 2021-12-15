package netTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {
	public static void main(String[] args) throws Exception {
		BufferedReader input = null;
		PrintWriter out = null;
		ServerSocket server = new ServerSocket(8200);
		System.out.println("TCP Server Start.");
		System.out.println("=======================");
		System.out.println("\nwait..");
		Socket socket = server.accept();
		System.out.println("conntected!..");
		
		while(true) {
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String message = input.readLine();
			
			if("bye".equals(message)) {
				socket.close();
				server.close();
				System.out.println("disconnected!..");
				break;
			}
			
			out = new PrintWriter(socket.getOutputStream(), true);
			String str = message;
			out.println(str);
			System.out.println("data sent.." + str);

		}
	}
}
