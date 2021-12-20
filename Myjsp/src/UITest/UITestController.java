package UITest;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UITestController
 */
@WebServlet("/UITestController")
public class UITestController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");

		UITestService svc = new UITestService();
		String View = null;
		String cmd = request.getParameter("CMD");
		System.out.println(cmd);
		
		if ("SEL".equals(cmd)) {
			int check = svc.checkInfo(request);
			if (check == 1) {
				View = svc.getSltCList(request);
			} else {
				View = "/UITest/Insert.jsp";
			}
		} else if ("INT".equals(cmd)) {
			View = svc.Insert(request);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(View);
		dispatcher.forward(request, response);
	}

}
