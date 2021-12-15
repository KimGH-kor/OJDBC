package ch2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TcpIfClient {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Socket s = new Socket("localhost", 8200);
		System.out.println("client start!!!");

		while (true) {
			PrintWriter out = new PrintWriter(s.getOutputStream());
			System.out.println("서버한테 원하는 것을 보내세요.");
			String str = sc.nextLine();
			if (!"bye".equals(str)) {
				out.println(str);
				out.flush();

				BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
				String res = input.readLine();
				System.out.println(res);
			}else {
				out.println(str);
				out.flush();
				s.close();
				System.out.println("소켓을 끊습니다.");
				break;
			}
			
		}
	}
}
//date? => date value
//how are you
//not bad
//
//bye = 종료