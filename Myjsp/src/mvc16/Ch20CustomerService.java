package mvc16;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class Ch20CustomerService {
	
	Ch20CustomerDAO dao = null;
	
	public Ch20CustomerService() {
		dao = new Ch20CustomerDAO();
	}
	
	public String getSltCList(HttpServletRequest request) throws ServletException {
		
		
		String pageNum = request.getParameter("PAGE_NO");
		
		int currentPage = 0;
		
		if (pageNum == null) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(pageNum);
		}
		
		Boolean nextPageCk = null;
		
		final int rowNum = 5;
		
		
		ArrayList<Ch20CustomerDTO> cstList = dao.custlist(currentPage, rowNum);
	
		
		if(cstList.size() > rowNum ) {
			nextPageCk = true;
			cstList.remove(5);
		}else {
			nextPageCk = false;
		}

		request.setAttribute("C_LIST", cstList);
		request.setAttribute("P_NUM", currentPage);
		request.setAttribute("NEXT_PAGE", nextPageCk);
		
		return "/mvc16/Select.jsp";
	}

	public String getUser(HttpServletRequest request) {
		String cmd = request.getParameter("CMD");
		
		Ch20CustomerDTO dto = dao.custInfo(cmd);
		request.setAttribute("I_USER", dto);
		return "/mvc16/UpdateMenu.jsp";
	}

	public String Update(HttpServletRequest request) throws ServletException {
		dao.UpdateUser(request);

		int currentPage = 1;
		final int rowNum = 5;
		boolean nextPageCk;
		
		ArrayList<Ch20CustomerDTO> cstList = dao.custlist(currentPage, rowNum);
	
		if(cstList.size() > rowNum ) {
			nextPageCk = true;
			cstList.remove(5);
		}else {
			nextPageCk = false;
		}

		request.setAttribute("C_LIST", cstList);
		request.setAttribute("P_NUM", currentPage);
		request.setAttribute("NEXT_PAGE", nextPageCk);
		return "/mvc16/Select.jsp";
	}
}
