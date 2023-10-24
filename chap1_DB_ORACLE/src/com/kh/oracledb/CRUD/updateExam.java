package com.kh.oracledb.CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class updateExam {

	public static void main(String[] args) {
		//드라이버 연결된 분들은 생략 가능 
		//String driver = "oracle.jdbc.driver.OracleDriver";
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "khbank";
		String password = "khbank";
		
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, username, password);
			
			//임하은 계좌의 잔액 변경하기
			
			String updateQuery = "UPDATE bank SET balance = ? WHERE account_name = ?";
			PreparedStatement updatePS = con.prepareStatement(updateQuery);
			
			updatePS.setDouble(1, 2000.00);
			updatePS.setString(2, "임하은");
		
			int rowsUpdate = updatePS.executeUpdate();
			System.out.println(rowsUpdate + "업데이트 되었습니다.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
