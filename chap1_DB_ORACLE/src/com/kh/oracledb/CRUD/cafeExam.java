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
		 * 1.모든 카페 목록 가져오기  Statement st1 = con.createStatement();
		 * ResultSet result1 = st1.executeQuery();
		 * 2.특정 카페의 메뉴 가져오기
		 * 3.새로운카페 추가하기
		 * 4.특정 카페의 메뉴 가격 변경
		 * 5.특정 카페의 정보 수정하기
		 * 6.특정 카페의 정보 삭제하기
		 * 7.특정 카페의 메뉴 수 가져오기
		 * 8.특정 가격 범위 내의 모든 메뉴 가져오기
		 * 9.특정 메뉴 정보 가져오기
		 * 10.모든 카페의 이름과 주소 가져오기
		 * 11.특정 카페의 운영시간 변경 및 결과 확인
		 * 12.특정 카페의 전화번호 변경 및 결과 확인
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
		//모든 카페 목록 가져오기
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafes";
		String password = "khcafes"; 
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			
			String selectQuery = "SELECT c_name FROM cafes";
			Statement st1 = con.createStatement();
			ResultSet result = st1.executeQuery(selectQuery);
			
			System.out.println("카페 목록: ");
			
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
		//특정 카페의 메뉴 가져오기
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafes";
		String password = "khcafes";
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String selectQuery = " SELECT menu_name FROM menu m JOIN cafes c ON m.cafe_id= c.cafe_id WHERE c.c_name = ?";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			
			
			selectState.setString(1,"부산시렵네");
			
			ResultSet result = selectState.executeQuery();
			while(result.next()) {

				String menuName = result.getString("menu_name");
				
				System.out.println(  " 메뉴이름 : " + menuName);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	static void InsertCafe() {
		//새로운 카페 추가하기
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafes";
		String password = "khcafes";
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String insertQuery = "INSERT INTO cafes(cafe_id, c_name, c_address,phone_number ,operating_hours )"+
			"VALUES(?,?,?,?,?)";
			PreparedStatement insertState = con.prepareStatement(insertQuery);
			insertState.setInt(1, 26);
			insertState.setString(2,"파란 병");
			insertState.setString(3, "서울시 강남구 역삼로 123");
			insertState.setString(4, "02-123-4567");
			insertState.setString(5,"월-금: 08:30-20:30, 주말: 09:00-19:00");
			
			int rows = insertState.executeUpdate();
			System.out.println(rows + "추가됨");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
	}
	
	static void UpdateCafeMenu() {
		//특정카페의 메뉴 가격 변경
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
			System.out.println(rowUpdate + "업데이트 되었습니다.");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	static void UpdateCafeInfo() {
		//특정 카페의 정보 수정하기 (이사했어요)
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String uesrname = "khcafes";
		String password = "khcafes";
		
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, uesrname, password);
			String updateQuery = "UPDATE cafes SET c_address = ? , phone_number = ? WHERE cafe_id = ?";
			PreparedStatement updatePS = con.prepareStatement(updateQuery);
			
			updatePS.setString(1,"도쿄 하라주쿠 캣스트리트");
			updatePS.setString(2, "8089558888");
			updatePS.setInt(3,10);
			
			int rowsUpdate = updatePS.executeUpdate();
			System.out.println(rowsUpdate +"업데이트 됐습니다.");
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	static void DeleteCafeInfo() {
		//특정 카페의 정보 삭제하기
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String uesrname = "khcafes";
		String password = "khcafes";
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, uesrname, password);
			String deleteQuery = "DELETE  FROM cafes CASCADE WHERE cafe_id = ? ";
			PreparedStatement deletePS = con.prepareStatement(deleteQuery);
			deletePS.setInt(1, 5);
			
			int rowsDelete = deletePS.executeUpdate();
			System.out.println(rowsDelete + "삭제되었습니다.");
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
