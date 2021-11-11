package javabook;

import java.util.Scanner;

public class TRa {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("밑변을 입력해주세요 >");
		int h = sc.nextInt();
		System.out.print("높이을 입력해주세요 >");
		int w = sc.nextInt();
		
		square(h,w);
		
		
	}
	
	public static void square(int h, int w) {
		System.out.println("삼각형의 면적은 "+h*w/2+"입니다.");
	}
}
