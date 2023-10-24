package com.kh.userVODAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BankMain {
//update
	public static void main(String[] args) {
		
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khbank";
		String dbPassWord = "khbank";
			
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, dbUserName, dbPassWord);
			Scanner sc = new Scanner(System.in);
			System.out.println("������ ID�� �Է��ϼ��� : ");
			int fromAccountId = sc.nextInt();
			System.out.println("���۹��� id�� �Է��ϼ���.: ");
			int toAccountId = sc.nextInt();
			
			System.out.println("������ �ݾ��� �Է�: ");
			double amount = sc.nextDouble();
			
			PreparedStatement a = connection.prepareStatement("UPDATE BANK SET balance -? WHERE account_id = ?");
			a.setDouble(1, amount);
			a.setInt(2, fromAccountId);
			a.executeUpdate();
			connection.commit();	
			
			PreparedStatement b = connection.prepareStatement("UPDATE BANK SET balance +? WHERE account_id = ? ");
					b.setDouble(1, amount);
					b.setInt(2, fromAccountId);
					b.executeUpdate();
					connection.commit();	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
