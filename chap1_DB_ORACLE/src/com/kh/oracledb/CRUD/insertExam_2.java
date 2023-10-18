package com.kh.oracledb.CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertExam_2 {

	public static void main(String[] args) {
		// �޴� �߰�
		String jdbcurl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "khcafes";
		String password = "khcafes";
		
		try {
			Connection con = DriverManager.getConnection(jdbcurl, userName, password);
			String insertSQL = "INSERT INTO menu (menu_id,cafe_id,menu_name,price,description)"+
					"VALUES(?,?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(insertSQL);
			//menu���̺� ������ ����
			insertMenu(ps,21,20,"���ʼ���",5.2,"���̽����ڿ� �� �߰�");
			insertMenu(ps,22,10,"����޷�ũ���Ҵ�",6.5,"���찡 �������� �ٴҶ���̽�ũ���� ü���� �ö� �޷мҴ��Դϴ�.");
			insertMenu(ps,23,10,"Ű��Ű�� �����Ҵ�",7.5,"������ ������ ���� �Ҵ��Դϴ�.");
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	static void insertMenu(PreparedStatement ps, int menu_id, int cafe_id, String menu_name, double price, String description) throws SQLException {
		ps.setInt(1, menu_id);
		ps.setInt(2, cafe_id);
		ps.setString(3, menu_name);
		ps.setDouble(4, price);
		ps.setString(5, description);
		
		int rowsInsert = ps.executeUpdate();
		System.out.println(rowsInsert + "row �߰���");
	
	}

}
