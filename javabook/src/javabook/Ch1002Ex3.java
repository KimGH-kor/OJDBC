package javabook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Ch1002Ex3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "dev";
		String password = "123456";

		String sql, gubun;
		PreparedStatement pstmt;
		ResultSet rs;

		int n_code;
		String s_name, s_email, s_tel;
		double d_weight;

		int cnt;

		try {
			Class.forName(driver);
			System.out.println("Driver Loading Success~~");

			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("DB Connected...");

			while (true) {
				System.out.print("1:조건조회, 2:입력, 3:전화번호변경, 4:삭제, 5:개인 조회, 9:종료 = ");
				gubun = sc.next();

				if ("9".equals(gubun)) {
					System.out.println("종료합니다.");
					break;
				}

				if ("1".equals(gubun)) {
					sql = "SELECT * FROM CUSTOMER WHERE CODE >= ?  ORDER BY CODE";
					pstmt = con.prepareStatement(sql);
					System.out.println("조회할 회원코드를 입력하세요");
					System.out.print("코드        >>");
					n_code = sc.nextInt();
					pstmt.setInt(1, n_code);

					rs = pstmt.executeQuery();

					cnt = 0;

					while (rs.next()) {
						System.out.print(rs.getInt(1) + "\t");
						System.out.print(rs.getString(2) + "\t");
						System.out.print(rs.getString(3) + "\t");
						System.out.print(rs.getString(4) + "\t");
						System.out.println(rs.getDouble(5));
						cnt++;
					}

					if (cnt > 0) {
						System.out.println("정상 조회되었습니다.");
					} else {
						System.out.println("해당 자료가 없습니다.");
					}
					rs.close();
					pstmt.close();
				}

				if ("2".equals(gubun)) {
					sql = "SELECT * FROM CUSTOMER WHERE CODE = ?";
					pstmt = con.prepareStatement(sql);
					System.out.println("고객 정보를 입력하세요");
					System.out.print("코드         >>");
					n_code = sc.nextInt();

					pstmt.setInt(1, n_code);
					rs = pstmt.executeQuery();

					if (rs.next()) {
						System.out.println("이미 존재하는 고객번호입니다.");
						rs.close();
						pstmt.close();
						continue;
					}
					sql = "INSERT INTO CUSTOMER(CODE, NAME, EMAIL, TEL, WEIGHT)" + " VALUES("+n_code+",?,?,?,?)";
					pstmt = con.prepareStatement(sql);
					System.out.print("성명      >> ");
					s_name = sc.next();
					System.out.print("이메일     >> ");
					s_email = sc.next();
					System.out.print("전화번호      >> ");
					s_tel = sc.next();
					System.out.print("체중      >> ");
					d_weight = sc.nextDouble();

					pstmt.setString(1, s_name);
					pstmt.setString(2, s_email);
					pstmt.setString(3, s_tel);
					pstmt.setDouble(4, d_weight);

					cnt = pstmt.executeUpdate();

					if (cnt > 0) {
						System.out.println("정상 처리되었습니다.");
					} else {
						System.out.println("오류가 발생하였습니다.");
					}

					pstmt.close();
				}

				if ("3".equals(gubun)) {
					sql = "SELECT * FROM CUSTOMER WHERE CODE = ?";
					pstmt = con.prepareStatement(sql);
					System.out.println("전화번호를 변경할 회원코드를 입력하세요");
					System.out.print("코드         >>");
					n_code = sc.nextInt();

					pstmt.setInt(1, n_code);
					rs = pstmt.executeQuery();

					if (!rs.next()) {
						System.out.println("존재하지 않는 고객입니다.");
						rs.close();
						pstmt.close();
						continue;
					}
					
					sql = "UPDATE CUSTOMER SET TEL = ? WHERE CODE = "+n_code;
					pstmt = con.prepareStatement(sql);
					System.out.print("변경할 전화번호 >>");
					s_tel = sc.next();

					pstmt.setString(1, s_tel);

					cnt = pstmt.executeUpdate();

					if (cnt > 0) {
						System.out.println("정상 처리되었습니다.");
					} else {
						System.out.println("오류가 발생하였습니다.");
					}

					pstmt.close();
				}

				if ("4".equals(gubun)) {
					sql = "SELECT * FROM CUSTOMER WHERE CODE = ?";
					pstmt = con.prepareStatement(sql);
					System.out.println("삭제할 회원코드를 입력하세요");
					System.out.print("코드         >>");
					n_code = sc.nextInt();

					pstmt.setInt(1, n_code);
					rs = pstmt.executeQuery();

					if (!rs.next()) {
						System.out.println("존재하지 않는 고객입니다.");
						rs.close();
						pstmt.close();
						continue;
					}

					sql = "DELETE FROM CUSTOMER WHERE CODE = " + n_code;

					pstmt = con.prepareStatement(sql);
					cnt = pstmt.executeUpdate();

					if (cnt > 0) {
						System.out.println("정상 처리되었습니다.");
					} else {
						System.out.println("오류가 발생하였습니다.");
					}

					rs.close();
					pstmt.close();
				}
				
				if ("5".equals(gubun)) {
					sql = "SELECT * FROM CUSTOMER WHERE CODE = ?";
					pstmt = con.prepareStatement(sql);
					System.out.println("조회할 회원코드를 입력하세요");
					System.out.print("조회할 코드        >>");
					n_code = sc.nextInt();
					pstmt.setInt(1, n_code);

					rs = pstmt.executeQuery();

					cnt = 0;

					while (rs.next()) {
						System.out.println("code   = "+rs.getInt(1) + "\t");
						System.out.println("name   = "+rs.getString(2) + "\t");
						System.out.println("email  = "+rs.getString(3) + "\t");
						System.out.println("tel    = "+rs.getString(4) + "\t");
						System.out.println("weight = "+rs.getDouble(5));
						cnt++;
					}

					if (cnt > 0) {
						System.out.println("MSG    = 정상 조회되었습니다.");
					} else {
						System.out.println("해당 자료가 없습니다.");
					}
					rs.close();
					pstmt.close();
				}

			}

			con.close();
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
