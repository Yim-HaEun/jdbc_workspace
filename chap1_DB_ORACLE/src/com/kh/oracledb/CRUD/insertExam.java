package com.kh.oracledb.CRUD;
//cafe insert 작성해서 여러 카페 추가하기

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertExam {
	public static void main(String[] args) {
		String jdbcurl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "khcafes";
		String password = "khcafes";
		
		Connection con;
		try {
			con = DriverManager.getConnection(jdbcurl,userName,password);
			String insertSQL = "INSERT INTO cafes (cafe_id, c_name, c_address,phone_number,operating_hours)" + 
					"VALUES(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(insertSQL);
			
			insertcafes(ps,20,"스타바","강원도 춘천시 방송길77", "033-1111-2222","매일: 07:00-20:30");
			insertcafes(ps,21,"티몰튼","서울시 강남구 역삼로77", "02-1111-2222","매일: 06:30-21:00");
			insertcafes(ps,22,"코슷타","서울시 강남구 역삼로 11", "02-0000-2222","매일: 07:00-19:30");
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
	}
	static void insertcafes(PreparedStatement ps, int cafe_id, String c_name, String c_address, String phone_number,String operating_hours) throws SQLException{
		ps.setInt(1, cafe_id);
		ps.setString(2, c_name);
		ps.setString(3,c_address);
		ps.setString(4, phone_number);
		ps.setString(5, operating_hours);
		
		int rowsInsert = ps.executeUpdate();
		System.out.println(rowsInsert + "row 추가됨");
	
	}

}
