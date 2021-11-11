package TEST;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Student {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "dev";
		String password = "123456";

		String sql, gubun;
		PreparedStatement pstmt;
		ResultSet rs;

		String s_clss, s_seq;
		int n_kor, n_eng, n_mat;



		try {
			Class.forName(driver);
			System.out.println("Driver Loading Success~~");

			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("DB Connected...");

			while (true) {
				int cnt = 0;
				System.out.print("1:학번순 전체조회, 2:입력, 3:점수변경, 4:삭제, 9:종료 = ");
				gubun = sc.next();

				if ("9".equals(gubun)) {
					System.out.println("종료합니다.");
					break;
				}

				if ("1".equals(gubun)) {
					sql = "SELECT * FROM SCORE ORDER BY CLSS ASC";
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery();

					while (rs.next()) {
						System.out.print(rs.getString(1) + "\t");
						System.out.print(rs.getString(2) + "\t");
						System.out.print(rs.getInt(3) + "\t");
						System.out.print(rs.getInt(4) + "\t");
						System.out.println(rs.getInt(5));
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
					sql = "SELECT * FROM SCORE WHERE CLSS = ? AND SEQ = ?";
					pstmt = con.prepareStatement(sql);
					System.out.println("성적 정보를 입력하세요");
					System.out.print("반         >>");
					s_clss = sc.next();
					System.out.print("번호         >>");
					s_seq = sc.next();

					pstmt.setString(1, s_clss);
					pstmt.setString(2, s_seq);
					rs = pstmt.executeQuery();

					if (rs.next()) {
						System.out.println("이미 존재하는 반 번호입니다.");
						rs.close();
						pstmt.close();
						continue;
					}
					
					sql = "INSERT INTO SCORE(CLSS, SEQ, KOR, ENG, MAT) VALUES(?,?,?,?,?)";
					pstmt = con.prepareStatement(sql);
					System.out.print("국어      >> ");
					n_kor = sc.nextInt();
					System.out.print("영어     >> ");
					n_eng = sc.nextInt();
					System.out.print("수학      >> ");
					n_mat = sc.nextInt();
					
					pstmt.setString(1, s_clss);
					pstmt.setString(2, s_seq);
					pstmt.setInt(3, n_kor);
					pstmt.setInt(4, n_eng);
					pstmt.setInt(5, n_mat);
					

					cnt = pstmt.executeUpdate();

					if (cnt > 0) {
						System.out.println("정상 처리되었습니다.");
					} else {
						System.out.println("오류가 발생하였습니다.");
					}

					pstmt.close();
				}

				if ("3".equals(gubun)) {
					sql = "SELECT * FROM SCORE WHERE CLSS = ? AND SEQ = ?";
					pstmt = con.prepareStatement(sql);
					System.out.println("성적을 변경할 학번을 입력하세요");
					System.out.print("반         >>");
					s_clss = sc.next();
					System.out.print("번호         >>");
					s_seq = sc.next();

					pstmt.setString(1, s_clss);
					pstmt.setString(2, s_seq);
					rs = pstmt.executeQuery();

					if (!rs.next()) {
						System.out.println("없는 반 번호입니다.");
						rs.close();
						pstmt.close();
						continue;
					}
					
					sql = "UPDATE SCORE SET KOR = ?, ENG = ?, MAT =? WHERE CLSS = "+s_clss+" AND SEQ = "+s_seq;
					pstmt = con.prepareStatement(sql);
					System.out.println("수정 성적을 입력하세요 .");
					System.out.print("국어     >>");
					n_kor = sc.nextInt();
					System.out.print("영어     >>");
					n_eng = sc.nextInt();
					System.out.print("수학     >>");
					n_mat = sc.nextInt();
					

					pstmt.setInt(1, n_kor);
					pstmt.setInt(2, n_eng);
					pstmt.setInt(3, n_mat);

					cnt = pstmt.executeUpdate();

					if (cnt > 0) {
						System.out.println("정상 처리되었습니다.");
					} else {
						System.out.println("오류가 발생하였습니다.");
					}

					pstmt.close();
				}

				if ("4".equals(gubun)) {
					sql = "SELECT * FROM SCORE WHERE CLSS = ? AND SEQ = ?";
					pstmt = con.prepareStatement(sql);
					System.out.println("삭제할 학번을 입력하세요");
					System.out.print("반         >>");
					s_clss = sc.next();
					System.out.print("번호         >>");
					s_seq = sc.next();

					pstmt.setString(1, s_clss);
					pstmt.setString(2, s_seq);
					rs = pstmt.executeQuery();

					if (!rs.next()) {
						System.out.println("없는 반 번호입니다.");
						rs.close();
						pstmt.close();
						continue;
					}

					sql = "DELETE FROM SCORE WHERE CLSS = "+s_clss+" AND SEQ = "+s_seq;

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

			}

			con.close();
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
