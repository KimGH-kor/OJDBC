package 다른사람꺼;

import java.util.HashMap;
import java.util.Scanner;

public class Service {
	
	public static HashMap<String, Object> Service(int num){// 디비에서 데이터를 검색하기 위해 모델을 호출한다
		// 메인으로부터 피케이값을 넘겨받아 디비에서 검색한 결과값을 dto에 담아 리턴한다
		HashMap<String, Object> hm = new HashMap<String, Object>();
		DAO dao = new DAO();
		Customer data = dao.check(num);
		hm.put("CODE", data);
		if (data != null) {
		hm.put("msg", "no data");
		} else {
			System.out.println("해당자료가 없습니다");
		}
		hm.put("CODE", data); // 해쉬맵으로 있던 값을 c에 넣어주고

		return hm;
	}

}
