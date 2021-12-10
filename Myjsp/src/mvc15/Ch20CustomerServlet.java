package mvc15;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc16.Ch20CustomerDTO;

@WebServlet("/Customer")
public class Ch20CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		//페이지 처리
		int page;
		if(request.getParameter("page") == null) {
			page = 1;
		}else {
			page = Integer.parseInt(request.getParameter("page"));
		}
		request.setAttribute("page", page);
		
		ArrayList<Ch20CustomerDTO> arr = new ArrayList<Ch20CustomerDTO>();
		
		//dto처리
		Ch20CustomerDTO dto = new Ch20CustomerDTO();
		dto.setCode(123);
		dto.setName("홍길동");
		dto.setEmail("hong@a.com");
		dto.setTel("010-1234-1234");
		dto.setWeight(123.1);
		arr.add(dto);
		
		dto = new Ch20CustomerDTO();
		dto.setCode(124);
		dto.setName("김경환");
		dto.setEmail("kim@a.com");
		dto.setTel("010-1111-1111");
		dto.setWeight(70.1);
		arr.add(dto);
		
		request.setAttribute("arr", arr);
		
		//next처리
		
		
		boolean next = false;
		if(3>page) {
			next = true;
		}
		request.setAttribute("next", next);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/mvc16/ch20Customer.jsp");
		dispatcher.forward(request, response);
	}

}
