package ch01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class TcpDateServer {
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(8200);
		System.out.println("TCP Server Start.");
		System.out.println("=======================");
		
		while(true) {
			System.out.println("\nwait..");
			Socket socket = server.accept();
			System.out.println("conntected!..");
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			String str = new Date().toString();
			out.println(str);
			
			System.out.println("data sent.." + str);
			socket.close();
			System.out.println("disconnected!..");
			
		}
	}
}
