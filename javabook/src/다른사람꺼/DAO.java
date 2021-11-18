package 다른사람꺼;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ch11_11.DTO.CustomerDTO;

public class DAO {
	Connection con = null;

	public DAO() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "dev";
		String password = "123456";

		try {
			Class.forName(driver);
			System.out.println("드라이브 로딩");
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("드라이브 연결");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Customer check(int num) { // int에 들어가는 변수는
		Customer dto = null;
		try {
			String sql, gubun;
			PreparedStatement pstmt;
			ResultSet rs;
			
			sql = "SELECT * FROM CUSTOMER WHERE CODE=? ";
			// 디비연결한다 쿼리 준비한다 ****(select * from 테이블 명 where 변수값=?
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {// 디비정보를 dto에 담는다
				dto = new Customer(rs.getInt("CODE"),rs.getString("NAME"),rs.getString("EMAIL"),rs.getString("TEL"),rs.getDouble("WEIGHT"));
			}
			rs.close();
			pstmt.close();
			con.close();

			return dto;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dto;
	}
}
