package javabook;

import java.util.Scanner;

public class Tutor {
	public static void main(String[] args) {
		int a[][] = new int[3][3];
		int count = 0;
		int temp = a.length;
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < temp; j++) {
				a[i][j] = ++count;
			}
			temp--;
		}
		
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
	}
}
