package UITest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class UITestDAO {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public UITestDAO() {
		getConnect();
	}

	public void getConnect() {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "dev";
		String password = "123456";

		try {
			Class.forName(driver);
			System.out.println("Driver Loading Sucess!");

			con = DriverManager.getConnection(url, user, password);
			System.out.println("DB Connected...");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public int getCheck() {
		try {
			String sql = "SELECT * FROM MBR";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public ArrayList<UITestDTO> custlist() {
		ArrayList<UITestDTO> list = new ArrayList<UITestDTO>();
		try {
			String sql = "SELECT * FROM MBR";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			UITestDTO cst = null;
			while (rs.next()) {
				cst = new UITestDTO();
				cst.setCode(rs.getInt("code"));
				cst.setName(rs.getString("name"));
				cst.setWeight(rs.getDouble("weight"));
				list.add(cst);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return list;
	}

	public UITestDTO custInfo(String code) {
		UITestDTO dto = null;

		try {
			String sql = "SELECT * FROM MBR WHERE CODE = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto = new UITestDTO();
				dto.setCode(rs.getInt("code"));
				dto.setName(rs.getString("name"));
				dto.setWeight(rs.getDouble("weight"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto;
	}

	public void InsertUser(HttpServletRequest request) {

		try {
			String sql = "INSERT INTO MBR(CODE, NAME, WEIGHT) VALUES(?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("code"));
			pstmt.setString(2, request.getParameter("name"));
			pstmt.setString(3, request.getParameter("weight"));

			pstmt.executeUpdate();
			System.out.println("들어갔음");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void closeDB() {
        try {rs.close();} catch (SQLException e) {e.printStackTrace();}
        try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
        try {con.close();} catch (SQLException e) {e.printStackTrace();}
	}
}