package com.kh.oracledb.CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class insertSampleExam {

	public static void main(String[] args) {
		

	}
	static void insertBank() {
		String driver = "oracle.jdbc.driver.OracleDriver"; //����̹� ���� 
		//2.����Ŭ �� ��ǻ�� ���� : �����ͺ��̽� ���� ����
		//								���� IP�ּ�: port ��ȣ
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
		String user = "khbank";
		String password = "khbank";
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			//���⿡ �ڵ带 �ۼ�
			String insertQuery = "INSERT INTO BANK(account_id, account_number, account_name, balance, branch_name, last_transaction_date) "
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
