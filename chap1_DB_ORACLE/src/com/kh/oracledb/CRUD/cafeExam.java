package com.kh.oracledb.CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class cafeExam {

	public static void main(String[] args) {
		/*
		 * 1.��� ī�� ��� ��������  Statement st1 = con.createStatement();
		 * ResultSet result1 = st1.executeQuery();
		 * 2.Ư�� ī���� �޴� ��������
		 * 3.���ο�ī�� �߰��ϱ�
		 * 4.Ư�� ī���� �޴� ���� ����
		 * 5.Ư�� ī���� ���� �����ϱ�
		 * 6.Ư�� ī���� ���� �����ϱ�
		 * 7.Ư�� ī���� �޴� �� ��������
		 * 8.Ư�� ���� ���� ���� ��� �޴� ��������
		 * 9.Ư�� �޴� ���� ��������
		 * 10.��� ī���� �̸��� �ּ� ��������
		 * 11.Ư�� ī���� ��ð� ���� �� ��� Ȯ��
		 * 12.Ư�� ī���� ��ȭ��ȣ ���� �� ��� Ȯ��
		 * 
		 * */ 
		//SelectList();
		//SelectMenu();
		//InsertCafe();
		//UpdateCafeMenu();
		//UpdateCafeInfo();
		DeleteCafeInfo();
		
	}
	static void SelectList() {
		//��� ī�� ��� ��������
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafes";
		String password = "khcafes"; 
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			
			String selectQuery = "SELECT c_name FROM cafes";
			Statement st1 = con.createStatement();
			ResultSet result = st1.executeQuery(selectQuery);
			
			System.out.println("ī�� ���: ");
			
			while(result.next()) {
				String CafeName = result.getString("c_name");
				System.out.println(CafeName);
		
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void SelectMenu() {
		//Ư�� ī���� �޴� ��������
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafes";
		String password = "khcafes";
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String selectQuery = " SELECT menu_name FROM menu m JOIN cafes c ON m.cafe_id= c.cafe_id WHERE c.c_name = ?";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			
			
			selectState.setString(1,"�λ�÷Ƴ�");
			
			ResultSet result = selectState.executeQuery();
			while(result.next()) {

				String menuName = result.getString("menu_name");
				
				System.out.println(  " �޴��̸� : " + menuName);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	static void InsertCafe() {
		//���ο� ī�� �߰��ϱ�
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafes";
		String password = "khcafes";
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String insertQuery = "INSERT INTO cafes(cafe_id, c_name, c_address,phone_number ,operating_hours )"+
			"VALUES(?,?,?,?,?)";
			PreparedStatement insertState = con.prepareStatement(insertQuery);
			insertState.setInt(1, 26);
			insertState.setString(2,"�Ķ� ��");
			insertState.setString(3, "����� ������ ����� 123");
			insertState.setString(4, "02-123-4567");
			insertState.setString(5,"��-��: 08:30-20:30, �ָ�: 09:00-19:00");
			
			int rows = insertState.executeUpdate();
			System.out.println(rows + "�߰���");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
	}
	
	static void UpdateCafeMenu() {
		//Ư��ī���� �޴� ���� ����
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String uesrname = "khcafes";
		String password = "khcafes";
		
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, uesrname, password);
	
			String updateQuery = "UPDATE menu  SET price = ? WHERE cafe_id = ? ";
			PreparedStatement updatePS = con.prepareStatement(updateQuery);
			
			updatePS.setDouble(1, 6.6);
			updatePS.setInt(2, 5);
		
			int rowUpdate = updatePS.executeUpdate();
			System.out.println(rowUpdate + "������Ʈ �Ǿ����ϴ�.");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	static void UpdateCafeInfo() {
		//Ư�� ī���� ���� �����ϱ� (�̻��߾��)
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String uesrname = "khcafes";
		String password = "khcafes";
		
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, uesrname, password);
			String updateQuery = "UPDATE cafes SET c_address = ? , phone_number = ? WHERE cafe_id = ?";
			PreparedStatement updatePS = con.prepareStatement(updateQuery);
			
			updatePS.setString(1,"���� �϶����� Ĺ��Ʈ��Ʈ");
			updatePS.setString(2, "8089558888");
			updatePS.setInt(3,10);
			
			int rowsUpdate = updatePS.executeUpdate();
			System.out.println(rowsUpdate +"������Ʈ �ƽ��ϴ�.");
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	static void DeleteCafeInfo() {
		//Ư�� ī���� ���� �����ϱ�
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String uesrname = "khcafes";
		String password = "khcafes";
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, uesrname, password);
			String deleteQuery = "DELETE  FROM cafes CASCADE WHERE cafe_id = ? ";
			PreparedStatement deletePS = con.prepareStatement(deleteQuery);
			deletePS.setInt(1, 5);
			
			int rowsDelete = deletePS.executeUpdate();
			System.out.println(rowsDelete + "�����Ǿ����ϴ�.");
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
