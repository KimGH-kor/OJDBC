package ch11_11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import ch11_11.DTO.CustomerDTO;

public class Main {
	public Main() {
		int n_code;
		CustomerDTO dto = null;
		
		n_code = input();
		dto = model(n_code);
		output(dto);
	}
	//학번 입력 받는곳
	public static int input() {
		int n_code;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("조회할 회원코드를 입력하세요");
		System.out.print("조회할 코드        >>");
		n_code = sc.nextInt();
		
		return n_code;
	}
	
	//DB다뤄서 고객정보 배출 
	public static CustomerDTO model(int n_code) {
		CustomerDTO dto = null;
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "dev";
		String password = "123456";
		
		String sql;
		PreparedStatement pstmt;
		ResultSet rs;
		
		try {
			Class.forName(driver);
			System.out.println("드라이브 로딩");
			Connection con = DriverManager.getConnection(url,user,password);
			System.out.println("드라이브 연결");
			
			sql = "SELECT * FROM CUSTOMER WHERE CODE = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, n_code);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new CustomerDTO(rs.getInt("CODE"),rs.getString("NAME"),rs.getString("EMAIL"),rs.getString("TEL"),rs.getDouble("WEIGHT"));
			}
			return dto;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	//저장된 데이터 출력
	public static void output(CustomerDTO dto) {
		if (dto != null) {
			System.out.println("code   = " +dto.getN_code()+ "\t");
			System.out.println("name   = " +dto.getS_name() + "\t");
			System.out.println("email  = " +dto.getS_email() + "\t");
			System.out.println("tel    = " +dto.getS_tel() + "\t");
			System.out.println("weight = " +dto.getD_weight());
			System.out.println("MSG    = 정상 조회되었습니다.");
		} else {
			System.out.println("해당 자료가 없습니다.");
		}
	}
}
