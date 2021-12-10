package mvc16;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ch20Controller")
public class Ch20CustomerServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");

		Ch20CustomerService svc = new Ch20CustomerService();
		String View = null;
		String cmd = request.getParameter("CMD");
		String upd = request.getParameter("UPD");
		
		//서비스 고르기
		if(cmd != null) {
			View = svc.getUser(request);
		}else if(upd != null){
			View = svc.Update(request);
		}else {
			View = svc.getSltCList(request);
		}
		
		//포워드
		RequestDispatcher dispatcher = request.getRequestDispatcher(View);
		dispatcher.forward(request, response);
	}
}
