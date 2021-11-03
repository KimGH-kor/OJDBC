package javabook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Ch1002Ex2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "dev";
		String password = "123456";
		
		String sql,gubun;
		PreparedStatement pstmt;
		ResultSet rs;
		
		int n_code;
		String s_name, s_email, s_tel;
		double d_weight;
		
		int cnt;
		
		try {
			Class.forName(driver);
			System.out.println("Driver Loading Success~~");
			
			Connection con = DriverManager.getConnection(url,user,password);
			System.out.println("DB Connected...");
			
			while(true) {
				System.out.print("1:전체조회, 2:입력, 3:전화번호변경, 4:삭제, 9:종료 = ");
				gubun = sc.next();
				
				if("9".equals(gubun)) {
					System.out.println("종료합니다.");
					break;
				}
				
				if("1".equals(gubun)) {
					sql = "SELECT * FROM CUSTOMER ORDER BY CODE";
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery();
					
					cnt = 0;
					
					while(rs.next()) {
						System.out.print(rs.getInt(1)+"\t");
						System.out.print(rs.getString(2)+"\t");
						System.out.print(rs.getString(3)+"\t");
						System.out.print(rs.getString(4)+"\t");
						System.out.println(rs.getDouble(5));
						cnt++;
					}
					
					if(cnt>0) {
						System.out.println("정상 조회되었습니다.");
					}else {
						System.out.println("해당 자료가 없습니다.");
					}
					rs.close();
					pstmt.close();
				}
				
				if("2".equals(gubun)) {
					sql = "INSERT INTO CUSTOMER(code, name, email, tel, weight)"+
							" VALUES(?,?,?,?,?)";
					pstmt = con.prepareStatement(sql);
					System.out.println("고객 정보를 입력하세요");
					System.out.print("코드      >> ");
					n_code = sc.nextInt();
					System.out.print("성명      >> ");
					s_name = sc.next();
					System.out.print("이메일     >> ");
					s_email = sc.next();
					System.out.print("전화번호      >> ");
					s_tel = sc.next();
					System.out.print("체중      >> ");
					d_weight = sc.nextDouble();
					
					pstmt.setInt(1, n_code);
					pstmt.setString(2, s_name);
					pstmt.setString(3, s_email);
					pstmt.setString(4, s_tel);
					pstmt.setDouble(5, d_weight);
					
					cnt = pstmt.executeUpdate();
					
					if(cnt > 0) {
						System.out.println("정상 처리되었습니다.");
					}else {
						System.out.println("오류가 발생하였습니다.");
					}
					
					pstmt.close();
				}
				
				if("3".equals(gubun)) {
					sql = "UPDATE CUSTOMER SET tel = ? WHERE code = ?";
					pstmt = con.prepareStatement(sql);
					System.out.println("전화번호를 변경할 회원코드를 입력하세요");
					System.out.print("코드          >>");
					n_code = sc.nextInt();
					System.out.print("변경할 전화번호 >>");
					s_tel = sc.next();
					
					pstmt.setString(1, s_tel);
					pstmt.setInt(2, n_code);
					
					cnt = pstmt.executeUpdate();
					
					if(cnt > 0) {
						System.out.println("정상 처리되었습니다.");
					}else {
						System.out.println("오류가 발생하였습니다.");
					}
					
					pstmt.close();
				}
				
				if("4".equals(gubun)) {
					sql = "DELETE FROM CUSTOMER WHERE code = ?";
					pstmt = con.prepareStatement(sql);
					System.out.println("삭제할 회원코드를 입력하세요");
					System.out.print("코드         >>");
					n_code = sc.nextInt();
					
					pstmt.setInt(1, n_code);
					
					cnt = pstmt.executeUpdate();
					
					if(cnt > 0) {
						System.out.println("정상 처리되었습니다.");
					}else {
						System.out.println("오류가 발생하였습니다.");
					}
					
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
