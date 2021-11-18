package ch11_11.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import ch11_11.DTO.CustomerDTO;

public class CustomerDAO {
	
	public CustomerDTO select(int n_code) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "dev";
		String password = "123456";
		CustomerDTO dto = null;

		try {
			Class.forName(driver);
			System.out.println("드라이브 로딩");
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("드라이브 연결");

			String sql;
			PreparedStatement pstmt;
			ResultSet rs;

			sql = "SELECT * FROM CUSTOMER WHERE CODE = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, n_code);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto = new CustomerDTO(rs.getInt("CODE"), rs.getString("NAME"), rs.getString("EMAIL"),
						rs.getString("TEL"), rs.getDouble("WEIGHT"));
			}
			
			rs.close();
			pstmt.close();
			con.close();
			return dto;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

}
