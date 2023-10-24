package com.kh.oracledb.CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class updateExam {

	public static void main(String[] args) {
		//����̹� ����� �е��� ���� ���� 
		//String driver = "oracle.jdbc.driver.OracleDriver";
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "khbank";
		String password = "khbank";
		
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, username, password);
			
			//������ ������ �ܾ� �����ϱ�
			
			String updateQuery = "UPDATE bank SET balance = ? WHERE account_name = ?";
			PreparedStatement updatePS = con.prepareStatement(updateQuery);
			
			updatePS.setDouble(1, 2000.00);
			updatePS.setString(2, "������");
		
			int rowsUpdate = updatePS.executeUpdate();
			System.out.println(rowsUpdate + "������Ʈ �Ǿ����ϴ�.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
