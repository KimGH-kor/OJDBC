package ch11_11;

import java.util.HashMap;
import java.util.Scanner;

import ch11_11.DAO.CustomerDAO;
import ch11_11.DTO.CustomerDTO;

public class Main {
	public static void main(String[] args) {
		int n_code;//인풋에서 준 리턴값을 저장할려고
		Service sr = new Service();// 서비스에 있는 메서드를 사용할려고

		n_code = input();
		
		HashMap<String, Object> hm = sr.userCheck(n_code);// 유저체크에서 리턴값으로 받은 해쉬맵(dto, 메세지라는 다른 오브젝트 저장하기 위해 해쉬맵)을 저장할려고
		
		output(hm);
	}

	// 학번 입력 받는곳
	public static int input() {
		int n_code;
		Scanner sc = new Scanner(System.in);

		System.out.println("조회할 회원코드를 입력하세요");
		System.out.print("조회할 코드        >>");
		n_code = sc.nextInt();

		return n_code;
	}

	// DB다뤄서 고객정보 배출

	// 저장된 데이터 출력
	public static void output(HashMap<String, Object> hm) {
		CustomerDTO cd = (CustomerDTO) hm.get("CUS");
		if (hm.get("MSG").equals("정상 조회되었습니다.")) {
			System.out.println("code   = " + cd.getN_code() + "\t");
			System.out.println("name   = " + cd.getS_name() + "\t");
			System.out.println("email  = " + cd.getS_email() + "\t");
			System.out.println("tel    = " + cd.getS_tel() + "\t");
			System.out.println("weight = " + cd.getD_weight() + "\t");
			System.out.println("msg = " + hm.get("MSG"));
		} else {
			System.out.println("msg = " + hm.get("MSG"));
		}
	}
}
