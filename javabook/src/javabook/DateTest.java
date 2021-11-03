package javabook;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) {
		Date dt = new Date();
		System.out.println(dt);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일hh시mm분ss초 a");
		String sCur = sdf.format(dt).toString();
		System.out.println(sCur);
	}
}
