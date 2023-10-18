package com.kh.oracledb.CRUD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class selectExam {
	public static void main(String[] args) {
		SelectAll();
		//SelectOne();
	}
	static void SelectAll() {
		//1.����̹� ���� : Oracle JDBC ����̹� Ŭ���� �̸�
		String driver = "oracle.jdbc.driver.OracleDriver";
		//2.����Ŭ �� ��ǻ�� ���� : �����ͺ��̽� ���� ����
		//								���� IP�ּ�: port ��ȣ
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "sanrio";
		String password = "sanrio";
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			
			String selectQuery = "SELECT * FROM sanriofriends";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			ResultSet result = selectState.executeQuery();
			while(result.next()) {
				int Sanrio_ID = result.getInt("s_id");
				String Sanrio_Name = result.getString("s_name");
				String Sanrio_Character = result.getString("s_character");
				String Sanrio_Color = result.getString("s_color");
				String Sanrio_Kind = result.getString("s_kind");
				
				System.out.println("�긮�� ��ȣ : " + Sanrio_Name + " �긮�� ĳ���� �̸� : "+ Sanrio_Name);
				System.out.println("���� : " + Sanrio_Character + "  ���� : " + Sanrio_Color);
				System.out.println("��ü : " + Sanrio_Kind);
				System.out.println("");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	static void SelectOne() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "sanrio";
		String password = "sanrio";
		
		try {
			Connection con = DriverManager.getConnection(url,user,password);
			
			//WHERE���� ����� ���� �߰�
			String selectQuery = "SELECT * FROM sanriofriends WHERE s_name in(?,?) ";
			
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			
			String[] targetAN = {"������","�ѱ���"};
			selectState.setString(1, targetAN[0]);
			selectState.setString(2, targetAN[1]);
			
			ResultSet result = selectState.executeQuery();
			if(!result.isBeforeFirst()) { //�����Ͱ� ������
				System.out.println("�����ϴ� �����Ͱ� �����ϴ�.");
			}
			while(result.next()) {
				int sanID = result.getInt("s_id");
				String sanName = result.getString("s_name");
				String sanCharacter = result.getString("s_character");
				String sanColor = result.getString("s_color");
				String sanKind = result.getString("s_kind");

				System.out.println("�긮�� ��ȣ : " + sanID+ "  �긮�� �̸� : " + sanName);
				System.out.println("���� : " + sanCharacter);
				System.out.println("���� : " + sanColor + "  ��ü : " + sanKind);

				System.out.println("");
				} 
			}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}

