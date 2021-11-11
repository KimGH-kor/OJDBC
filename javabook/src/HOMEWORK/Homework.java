package HOMEWORK;

import java.util.ArrayList;

public class Homework {
	public static void main(String[] args) {
		ArrayList<User> arr = new ArrayList<>();
		
		arr.add(new User(1, 1, 290));
		arr.add(new User(1, 7, 280));
		arr.add(new User(9, 7, 270));
		arr.add(new User(9, 9, 260));
		
		getGroupScore(arr, 1);
		getGroupScore(arr, 9);
		getTotal(arr);
		
	}
	
	public static void getGroupScore(ArrayList<User> arr, int group) {
		int sum = 0;
		for(int i = 0; i< arr.size(); i++) {
			if(arr.get(i).getGroup() == group) {
				sum += arr.get(i).getScore();
			}
		}
		System.out.println(group+"반의 총점은 "+sum+"입니다.");
	}
	
	public static void getTotal(ArrayList<User> arr) {
		int sum = 0;
		for(int i = 0; i< arr.size(); i++) {
			sum += arr.get(i).getScore();
		}
		System.out.println("이 학교의 학생들의 총점은 "+sum+"입니다.");
	}
}
