package UITest;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class UITestService {
	
	UITestDAO dao = null;
	
	public UITestService() {
		dao = new UITestDAO();
	}
	
	public String getSltCList(HttpServletRequest request){
		ArrayList<UITestDTO> cstList = dao.custlist();
		int size = cstList.size();
		double avg = 0;
		for(UITestDTO dto : cstList) {
			avg += dto.getWeight();
		}
		avg = Math.round(avg/size*100)/100.0;

		request.setAttribute("C_LIST", cstList);
		request.setAttribute("SIZE", size);
		request.setAttribute("AVG", avg);
		dao.closeDB();
		return "/UITest/Select.jsp";
	}

	public String Insert(HttpServletRequest request){
		UITestDTO dto = dao.custInfo(request.getParameter("code"));
		
		if(dto == null) {
			dao.InsertUser(request);
		}
		return getSltCList(request);
	}

	public int checkInfo(HttpServletRequest request) {
		int check = dao.getCheck();
			return check;
		}
}
