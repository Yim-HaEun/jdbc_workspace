package com.kh.oracledb.CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class deleteSample {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String uesrname = "khbank";
		String password = "khbank";
		
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, uesrname, password);
			String deleteQuery = "DELETE FROM BANK WHERE account_id = ?";
			PreparedStatement deletePs = con.prepareStatement(deleteQuery);
			
			deletePs.setDouble(1, 2);
			
			int rowsUpdate = deletePs.executeUpdate();
			System.out.println(rowsUpdate + "삭제 되었습니다.");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
