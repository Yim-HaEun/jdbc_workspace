package com.kh.userVODAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BankMain {

	public static void main(String[] args) {
		BankMain bm = new BankMain();
		bm.updateMinus();
		
	}
	
	public void updateMinus() {
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khbank";
		String dbPassWord = "khbank";
			
		Connection connection = DriverManager.getConnection(jdbcURL, dbUserName, dbPassWord);
		BankDAO bankDAO = new BankDAO(connection);
			
		String sql = "UPDATE BANK SET balance = balance -? WHERE account_id = ?"+
				"VALUES(?,?)";
				try {
					PreparedStatement st = connection.prepareStatement(sql);
					st.setDouble(1,bankDAO.getBalance());
					st.setInt(2, bankDAO.getAccount_id());
							
					int rows = st.executeUpdate();
	
				} catch (SQLException e) {
							// TODO Auto-generated catch block
					e.printStackTrace();
				}

	}

}
