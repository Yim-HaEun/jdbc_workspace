package com.kh.oracledb.CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertExam_2 {

	public static void main(String[] args) {
		// 메뉴 추가
		String jdbcurl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "khcafes";
		String password = "khcafes";
		
		try {
			Connection con = DriverManager.getConnection(jdbcurl, userName, password);
			String insertSQL = "INSERT INTO menu (menu_id,cafe_id,menu_name,price,description)"+
					"VALUES(?,?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(insertSQL);
			//menu테이블에 데이터 삽입
			insertMenu(ps,21,20,"아초샷추",5.2,"아이스초코에 샷 추가");
			insertMenu(ps,22,10,"도쿄메론크림소다",6.5,"도쿄가 생각나는 바닐라아이스크림과 체리가 올라간 메론소다입니다.");
			insertMenu(ps,23,10,"키라키라 젤리소다",7.5,"투명한 젤리가 들어가는 소다입니다.");
			
			
			
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
		System.out.println(rowsInsert + "row 추가됨");
	
	}

}
