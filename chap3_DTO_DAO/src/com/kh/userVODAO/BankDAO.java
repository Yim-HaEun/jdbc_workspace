package com.kh.userVODAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BankDAO {
	private Connection connection;
	public BankDAO(Connection connection) {
		this.connection = connection;
	}
	public boolean updateBank(BankVO bank) {
		String sql = "UPDATE BANK SET balance = balance -? WHERE account_id = ?"+
	"VALUES(?,?)";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setDouble(1,bank.getBalance());
			st.setInt(2, bank.getAccount_id());
			
			int rows = st.executeUpdate();
			return rows>0;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}

}
