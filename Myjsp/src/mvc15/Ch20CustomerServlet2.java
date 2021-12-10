package mvc15;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc16.Ch20CustomerDTO;

@WebServlet("/CustomerSvl4")
public class Ch20CustomerServlet2 extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doPost(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html;charset=utf-8");
      
      String pageNum = request.getParameter("PAGE_NO");
      int maxPage;
      Boolean nextPageCk = null;
      int currentPage = 0;
      int cnt = 0;
      final int MAX_ROWS = 5;
      
      if(pageNum == null) {
         currentPage = 1;
      }else {
         currentPage = Integer.parseInt(pageNum);
      }
      
      
      ArrayList<Ch20CustomerDTO> cstList = new ArrayList<Ch20CustomerDTO>();
      
      // 데이터베이스 연결관련 변수 선언
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      // 데이터베이스 연결관련 정보를 문자열로 선언
      String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
      String jdbc_url = "jdbc:oracle:thin:@localhost:1521:XE";
      
      try{
         // JDBC 드라이버 로드
         Class.forName(jdbc_driver);
         
         // 데이터베이스 연결정보를 이용해 Connection 인스턴스 확보
         conn = DriverManager.getConnection(jdbc_url, "dev", "123456");
         
         String sql = "select *" + 
                   "from ( select rownum as no" +
                   "            , o.*         " +
                   "       from (select * from customer    " +
                   "       order by code) o	) " +
                   "where  no >= ?             " +
                   "and    rownum <= ?            ";
         
         pstmt = conn.prepareStatement(sql);
         
         pstmt.setInt(1, (currentPage-1)* MAX_ROWS + 1);
         pstmt.setInt(2, MAX_ROWS);
         
         rs = pstmt.executeQuery();
         Ch20CustomerDTO cDTO = null;
         
         while(rs.next()) {
            cDTO = new Ch20CustomerDTO();
            cDTO.setCode(rs.getInt("CODE"));
            cDTO.setName(rs.getString("NAME"));
            cDTO.setEmail(rs.getString("EMAIL"));
            cDTO.setTel(rs.getString("TEL"));
            cDTO.setWeight(rs.getDouble("WEIGHT"));
            cstList.add(cDTO);
         
         }
         
         sql = "SELECT COUNT(*) FROM CUSTOMER";
         pstmt = conn.prepareStatement(sql);
         rs = pstmt.executeQuery();
         if(rs.next()) {
            cnt = rs.getInt(1);
         }
         
         rs.close();
         pstmt.close();
         conn.close();
      }catch(Exception e){
         System.out.println(e);
      }
      
      if(cnt/MAX_ROWS == 0) {
         maxPage = cnt/MAX_ROWS;
      }else {
         maxPage = (cnt/MAX_ROWS)+1;
      }
      
      if(maxPage>currentPage) {
         nextPageCk = true;
      }else{
         nextPageCk = false;
      }
      
      request.setAttribute("C_LIST", cstList);
      request.setAttribute("P_NUM", currentPage);
      request.setAttribute("MAX_PAGE", maxPage);
      request.setAttribute("NEXT_PAGE", nextPageCk);
      RequestDispatcher dispatcher = request.getRequestDispatcher("/mvc16/mvc15customerView4.jsp");
      dispatcher.forward(request, response);
   }

}