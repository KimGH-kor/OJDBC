package ch02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Ch0240SvlEchoData
 */
@WebServlet("/SvlEchoData")
public class Ch0240SvlEchoData extends HttpServlet {
   private static final long serialVersionUID = 1L;

   //doGet get방식으로 전달 받음
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doPost(request, response);
   }
   //doPost post방식으로 전달 받음
   protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      res.setContentType("text/html;charset=UTF-8");
      PrintWriter out = res.getWriter();
      req.setCharacterEncoding("UTF-8");
      
      out.println("<html>");
      out.println("<head><meta charset=\"UTF-8\"><title>Echo Data</title></head>");
      out.println("<body>");
      
      Enumeration<String> e = req.getParameterNames();
      while(e.hasMoreElements()) {
         String name = (String)e.nextElement();
         String values[] = req.getParameterValues(name);
         if(values != null) {
            for(int i = 0; i < values.length; i++) {
               out.print("<li>" + name + " : " + values[i]);
            }
         }
      }
      out.println("</body>");
      out.println("</html>");
      out.close();
   }

}