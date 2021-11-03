package javabook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Ch1001Ex1 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "hr";
		String password = "hr";
		
		int cnt = 0;
		
		String sql;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		
		try {
			Class.forName(driver);
			System.out.println("Driver Loading Success~~");
			
			con = DriverManager.getConnection(url,user,password);
			System.out.println("DB Connected...");

			sql = "SELECT * FROM regions";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			cnt = 0;
			
			while(rs.next()) {
				System.out.print(rs.getInt("REGION_ID")+"\t");
				System.out.println(rs.getString("REGION_NAME"));
				cnt++;
			}
			
			if(cnt > 0) {
				System.out.println("정상 조회되었습니다.");
			}else {
				System.out.println("해당 자료가 없습니다.");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
			}catch (Exception e) {}
			try {
				if(pstmt != null) {
					pstmt.close();
				}
			}catch (Exception e2) {}
			try {
				if(con != null) {
					con.close();
				}
			}catch (Exception e3) {}
			
		}
	}
}
