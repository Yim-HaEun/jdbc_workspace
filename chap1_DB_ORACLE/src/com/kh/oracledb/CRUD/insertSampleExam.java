package com.kh.oracledb.CRUD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertSampleExam {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver"; //드라이버 연결 
		//2.오라클 내 컴퓨터 연결 : 데이터베이스 연결 정보
		//								나의 IP주소: port 번호
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
		String user = "khbank";
		String password = "khbank";
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			//여기에 코드 작성
			String insertSQL = "INSERT INTO BANK (account_id, account_number, account_name ,balance ,branch_name,last_transaction_date)" 
			+ "VALUES (?,?,?,?,?,TO_DATE(?,'YYYY-MM-DD'))";
			
			PreparedStatement ps = con.prepareStatement(insertSQL);
			
			
			
			insertBank(ps,16,"임하은","110489627262","0","sh",Date.valueOf("2023-10-19"));
			insertBank(ps,17,"ㄱㄱㄱ","110489627262","0","sh",Date.valueOf("2023-10-19"));
			insertBank(ps,18,"ㄴㄴㄴ","110489627262","0","sh",Date.valueOf("2023-10-19"));
			ps.close();

			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void insertBank(PreparedStatement ps, int account_id, String account_name, String account_number,
			String balance, String branch_name, Date last_transaction_date) throws SQLException{
		
		ps.setInt(1,account_id);
		ps.setString(2,account_number);
		ps.setString(3, account_name);
		ps.setString(4,balance);
		ps.setString(5,branch_name);
		ps.setDate(6,last_transaction_date);
	
		int rowsInsert = ps.executeUpdate();
		System.out.println(rowsInsert + "row 추가됨");
			
			
	}

}
