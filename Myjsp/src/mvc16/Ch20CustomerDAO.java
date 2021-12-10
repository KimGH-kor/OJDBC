package mvc16;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class Ch20CustomerDAO {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public Ch20CustomerDAO() {
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

	public ArrayList<Ch20CustomerDTO> custlist(int currentPage, int rowNum) throws ServletException {
		ArrayList<Ch20CustomerDTO> list = new ArrayList<>();
		try {
			String sql = "select *" + "from ( select rownum as no    " + "            , o.*             "
					+ "       from ( select *        " + "              from   customer "
					+ "              order  by code) " + "            o )               "
					+ "where  no     >= ?            " + "and    rownum <= ?            ";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, (currentPage - 1) * rowNum + 1);
			pstmt.setInt(2, rowNum + 1);
			rs = pstmt.executeQuery();

			Ch20CustomerDTO cst = null;
			while (rs.next()) {
				cst = new Ch20CustomerDTO();
				cst.setCode(rs.getInt("code"));
				cst.setName(rs.getString("name"));
				cst.setEmail(rs.getString("email"));
				cst.setTel(rs.getString("tel"));
				cst.setWeight(rs.getDouble("weight"));

				list.add(cst);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			throw new ServletException(e);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			;
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			;
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
				}
			;

		}
		return list;
	}

	public Ch20CustomerDTO custInfo(String cmd) {
		Ch20CustomerDTO dto = null;
		
		try {
			String sql = "SELECT * FROM CUSTOMER WHERE CODE = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cmd);
			rs = pstmt.executeQuery();
			dto = new Ch20CustomerDTO();
			while(rs.next()) {
				dto.setCode(rs.getInt("code"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setTel(rs.getString("tel"));
				dto.setWeight(rs.getDouble("weight"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto;
	}

	public void UpdateUser(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String sql = "SELECT * FROM CUSTOMER WHERE CODE = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("code"));
			rs = pstmt.executeQuery();
			
			if(!rs.next()) {
				return;
			}
			System.out.println(request.getParameter("code"));
			System.out.println(request.getParameter("name"));
			System.out.println(request.getParameter("email"));
			System.out.println(request.getParameter("tel"));
			System.out.println(request.getParameter("weight"));
			
			sql = "UPDATE CUSTOMER SET CODE = ?, NAME = ?, EMAIL = ?, TEL = ?, WEIGHT = ? WHERE CODE = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("code"));
			pstmt.setString(2, request.getParameter("name"));
			pstmt.setString(3, request.getParameter("email"));
			pstmt.setString(4, request.getParameter("tel"));
			pstmt.setString(5, request.getParameter("weight"));
			pstmt.setString(6, request.getParameter("code"));
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}