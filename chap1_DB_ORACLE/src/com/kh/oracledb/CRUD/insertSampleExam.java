package com.kh.oracledb.CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class insertSampleExam {

	public static void main(String[] args) {
		

	}
	static void insertBank() {
		String driver = "oracle.jdbc.driver.OracleDriver"; //드라이버 연결 
		//2.오라클 내 컴퓨터 연결 : 데이터베이스 연결 정보
		//								나의 IP주소: port 번호
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
		String user = "khbank";
		String password = "khbank";
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			//여기에 코드를 작성
			String insertQuery = "INSERT INTO BANK(account_id, account_number, account_name, balance, branch_name, last_transaction_date) "
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
