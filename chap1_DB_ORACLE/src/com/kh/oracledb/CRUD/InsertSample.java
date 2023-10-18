package com.kh.oracledb.CRUD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class InsertSample {
	public static void main(String[] args) {
	
		insertBank();
		
	}
	static void insertBank() {

		
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "khbank";
			String password = "khbank";
			Connection con = null; 
			
			try {
				con = DriverManager.getConnection(url,user,password);
				String insertQuery = "INSERT INTO BANK(account_id, account_number, account_name, balance, branch_name, last_transaction_date) "
						+ "VALUES(?, ?, ?, ?, ?, ?)";
				PreparedStatement insertState = con.prepareStatement(insertQuery);
				insertState.setInt(1, 14);
				insertState.setString(2, "1104827262");
				insertState.setString(3, "«œ¿∫¿”");
				insertState.setDouble(4, 1500.00);
				insertState.setString(5, "kh");
				insertState.setDate(6, Date.valueOf("2023-10-16"));
				
				int rowsInsert = insertState.executeUpdate();
				System.out.println(rowsInsert + "rowø° √ﬂ∞°µ ");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		static void insertKhcafe() {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "khcafes";
			String password = "khcafes";
			Connection con = null;
			
			try {
				con = DriverManager.getConnection(url,user,password);
				String insertQuery = "INSERT INTO book(book_id,title,author,publication_year,isbn,genre,description,price,publication_date,created_date,updated_date,is_available)"+
				"VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement insertState = con.prepareStatement(insertQuery);
				insertState.setInt(1,21);
				insertState.setString(2, "√—±’ºË");
				insertState.setString(3, "¡¶∑πµÂ ¥Ÿ¿Ãæ∆∏ÛµÂ");
				insertState.setInt(4,2023);
				insertState.setString(5, "978-8934938833");
				insertState.setString(6, "Essay");
				insertState.setString(7,"¿Œ∞£ ªÁ»∏¿« øÓ∏Ì¿ª πŸ≤€ »˚");
				insertState.setDouble(8, 18.99);
				insertState.setDate(9, Date.valueOf("2023-05-05"));
				insertState.setDate(10,Date.valueOf("1997-10-10"));
				insertState.setDate(11,null);
				insertState.setString(12,null);
				
				int rowsInsert = insertState.executeUpdate();
				System.out.println(rowsInsert +"√ﬂ∞°µ ");
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
		
	

