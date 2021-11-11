package ch5;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HashMap<Integer, Student> hm = new HashMap<Integer, Student>();
		boolean start = true;

		while (start) {
			System.out.println("1.입력, 2.출력, 3.종료");
			int select = sc.nextInt();
			
			switch (select) {
			case 1:
				input(hm);
				break;
			case 2:
				output(hm);
				break;
			case 3:
				start = false;
				break;
			}
		}
	}

	public static void input(HashMap<Integer, Student> hm) {
		int n_code;
		String s_name;
		int n_korean;
		int n_english;
		int n_math;

		System.out.print("코드를 입력해 주세요    > ");
		n_code = sc.nextInt();
		System.out.print("성명을 입력해 주세요    > ");
		s_name = sc.next();
		System.out.print("국어 성적을 입력해 주세요    > ");
		n_korean = sc.nextInt();
		System.out.print("영어 성적을 입력해 주세요    > ");
		n_english = sc.nextInt();
		System.out.print("수학 성적을 입력해 주세요    > ");
		n_math = sc.nextInt();
		hm.put(n_code, new Student(n_code, s_name, n_korean, n_english, n_math));
		System.out.println();
	}

	public static void output(HashMap<Integer, Student> hm) {
		System.out.println(" 코드\t성명\t국어\t영어\t수학");

		for (int i : hm.keySet()) {
			System.out.println(hm.get(i).getCode() + "\t" + hm.get(i).getName() + "\t" + hm.get(i).getKorean() + "\t"
					+ hm.get(i).getEnglish() + "\t" + hm.get(i).getMath());
		}
		System.out.println();
	}
}
