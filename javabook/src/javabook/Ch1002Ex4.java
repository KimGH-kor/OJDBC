package javabook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Ch1002Ex4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "dev";
		String password = "123456";

		String sql;
		PreparedStatement pstmt;
		ResultSet rs;

		int n_code;

		try {
			Class.forName(driver);
			System.out.println("Driver Loading Success~~");

			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("DB Connected...");
			sql = "SELECT * FROM CUSTOMER WHERE CODE = ?";
			pstmt = con.prepareStatement(sql);
			System.out.println("조회할 회원코드를 입력하세요");
			System.out.print("조회할 코드        >>");
			n_code = sc.nextInt();
			pstmt.setInt(1, n_code);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				System.out.println("code   = " + rs.getInt("CODE") + "\t");
				System.out.println("name   = " + rs.getString("NAME") + "\t");
				System.out.println("email  = " + rs.getString("EMAIL") + "\t");
				System.out.println("tel    = " + rs.getString("TEL") + "\t");
				System.out.println("weight = " + rs.getDouble("WEIGHT"));
				System.out.println("MSG    = 정상 조회되었습니다.");
			} else {
				System.out.println("해당 자료가 없습니다.");
			}
			rs.close();
			pstmt.close();

			con.close();
			sc.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
