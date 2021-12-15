package ch01;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class GetTime {
	public static void main(String[] args) throws Exception {
		Socket s = new Socket("time-c.nist.gov", 13);
		InputStream in = s.getInputStream();
		Scanner sc = new Scanner(in);
		
		String line;
		
		while(sc.hasNextLine()) {
			line = sc.nextLine();
			System.out.println(line);
		}
		
		sc.close();
		s.close();
	}
}
