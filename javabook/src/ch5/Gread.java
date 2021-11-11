package ch5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Gread {
	public static void main(String[] args) {
		ArrayList<HashMap<String, Object>> arr = null;

		arr = input();
		arr = proc(arr);
		output(arr);
	}

	public static ArrayList<HashMap<String, Object>> input() {
		ArrayList<HashMap<String, Object>> arr = new ArrayList<HashMap<String, Object>>();

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 2; i++) {
			HashMap<String, Object> hm = new HashMap<String, Object>();
			int code, gread;
			String name;

			System.out.print("코드 => ");
			code = sc.nextInt();

			System.out.print("이름 => ");
			name = sc.next();

			System.out.print("학점 => ");
			gread = sc.nextInt();

			hm.put("CODE", code);
			hm.put("NAME", name);
			hm.put("GREAD", gread);
			arr.add(hm);
		}
		
		return arr;
	}

	public static ArrayList<HashMap<String, Object>> proc(ArrayList<HashMap<String, Object>> arr) {
		// 총건 총점 평균
		HashMap<String, Object> hm1 = new HashMap<String, Object>();
		int num = arr.size();
		int sum = 0;
		double avg = 1;

		for (int i = 0; i < arr.size(); i++) {
			HashMap<String, Object> hm = arr.get(i);
			sum += (int) hm.get("GREAD");
		}
		avg = sum / num;

		hm1.put("NUM", num);
		hm1.put("SUM", sum);
		hm1.put("AVG", avg);

		arr.add(hm1);
		return arr;
	}

	public static void output(ArrayList<HashMap<String, Object>> arr) {
		System.out.println("코드\t이름\t학점\t");
		for (int i = 0; i < arr.size(); i++) {
			HashMap<String, Object> hm = arr.get(i);
			if (i != arr.size()-1) {
				System.out.print(hm.get("CODE")+"\t"+hm.get("NAME")+"\t"+hm.get("GREAD") + "\n");
			} else {
				System.out.println("건수\t총점\t평균\t");
				System.out.println(hm.get("NUM")+"\t"+hm.get("SUM")+"\t"+hm.get("AVG"));
			}
			
		}

	}
}