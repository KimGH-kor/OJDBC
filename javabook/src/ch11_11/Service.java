package ch11_11;

import java.util.HashMap;
import java.util.Scanner;

import ch11_11.DAO.CustomerDAO;
import ch11_11.DTO.CustomerDTO;

public class Service {
	public HashMap<String, Object> userCheck(int n_code) {
		HashMap<String, Object> hm = new HashMap<>();
		CustomerDAO dao = new CustomerDAO();
		CustomerDTO dto = null;

		dto = dao.select(n_code);

		hm.put("CUS", dto);
		
		if (dto == null) {
			hm.put("MSG", "해당 자료가 없습니다.");
		} else {
			hm.put("MSG", "정상 조회되었습니다.");
		}

		return hm;
	}
}
