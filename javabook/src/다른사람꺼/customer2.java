package 다른사람꺼;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.HashMap;

public class customer2 {

	public static void main(String[] args){
		int code = input();
		HashMap<String, Object> hm = Service.Service(code); // 메세지까지 같이 넘겨야 해서 해쉬맵을 받기
		output(hm);

	}
	public static int input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("코드      >>");
		int code1 = sc.nextInt();// 조회할 pk를 입력받기 위해 인풋을 호출한다

		return code1;// 조회할 피케이값을 입력받아 리턴한다
	}

	public static void output(HashMap<String, Object> hm) { // output을 호출하여 모델에서 검색된 데이터를 호출한다

		Customer c = (Customer) hm.get("CODE");

		if (c != null) {// 메인으로부터 dto를 넘겨받아 화면출력한다
			System.out.println("CODE " + "=" + c.getCode());
			System.out.println("NAME " + "=" + c.getName());
			System.out.println("EMAIL " + "=" + c.getEmail());
			System.out.println("TEL " + "=" + c.getTel());
			System.out.println("WEIGHT " + "=" + c.getWeight());
			System.out.println(hm.get("STRING"));
		}
	}
}