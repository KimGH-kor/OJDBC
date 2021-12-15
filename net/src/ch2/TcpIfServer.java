package ch2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class TcpIfServer {
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(8200);
		System.out.println("TCP Server Start.");
		System.out.println("=======================");
		System.out.println("\nwait..");
		Socket socket = server.accept();
		System.out.println("conntected!..");
		
		while(true) {
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String message = input.readLine();
			
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			String str = null;
			
			if("Date?".equals(message)) {
				 str = new Date().toString();
			}else if("How are you?".equals(message)) {
				 str = "Not bad";
			}else if("bye".equals(message)) {
				socket.close();
				server.close();
				System.out.println("disconnected!..");
				break;
			}else {
				str = "없는 명령어 입니다.";
			}
			out.println(str);
			System.out.println("data sent.." + str);

		}
	}
}
