package ch11;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Ch11BoardDBBean {
	private static Ch11BoardDBBean instance = new Ch11BoardDBBean();

	// .jsp페이지에서 DB연동빈인 BoardDBBean클래스의 메소드에 접근시 필요
	public static Ch11BoardDBBean getInstance() {
		return instance;
	}

	private Ch11BoardDBBean() {
	}

	// 커넥션풀로부터 Connection객체를 얻어냄
	private Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:/comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/jsp");
		return ds.getConnection();
	}

	// board테이블에 글을 추가 (insert문) <= writePro.jsp페이지에서 사용
	public void insertArticle(Ch11BoardDataBean article) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rs = null;
		
		int num = article.getNum();
		int ref = article.getRef();
		int re_step = article.getRe_step();
		int re_level = article.getRe_level();
		int number = 0;
		String sql = "";
		
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("select max(num) from board");
				rs = pstmt.executeQuery();
				
				if(rs.next()) 
					number = rs.getInt(1)+1;
					else
						number = 1;
				
				if(num!=0) {
					sql="update board set re_step = re_step + 1";
					sql += "where ref = ? and re_step > ?";
						pstmt2 = conn.prepareStatement(sql);
						pstmt2.setInt(1, ref);
				pstmt2.setInt(2, re_step);
				pstmt2.executeUpdate();
				re_step = re_step + 1;
				re_level = re_level + 1;
				}else {
					ref = number;
					re_step = 0;
					re_level = 0;
				}
				//쿼리를 작성
				sql = "insert into board(num, writer, email, subject, passwd, reg_date,";
				
				
			}catch (Exception e) {
				// TODO: handle exception
			}
			}
}
