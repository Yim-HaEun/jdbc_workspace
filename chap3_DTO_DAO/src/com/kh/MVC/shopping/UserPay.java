package com.kh.MVC.shopping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserPay {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "khbank";
	String password = "khbank";
	
	ShoppingCart cart;
	
	public UserPay(ShoppingCart cart) {
		this.cart = cart;
	}
	public boolean payment() {
		Connection connection = null;
		double cartTotalPrice = cart.cartTotalPrice(); //īƮ �ȿ� ���� ���� �ݾ� �޼��� �߰��ϱ�
		
		try {
			connection  = DriverManager.getConnection(url, username, password);
			//�����ھ��� ���� �ܾ� ��������
			String balanceUser = "SELECT balance FROM BANK WHERE account_name = '������'";
			PreparedStatement st = connection.prepareStatement(balanceUser);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				double balance = rs.getDouble("balance");
				//���࿡ �ܾ��� ��ٱ��� �Ѿ׺��� ���ٸ�
				if(balance < cartTotalPrice) {
					System.out.println("�ܾ��� �����մϴ�.");
					return false;
				}
				double newBalance = balance - cartTotalPrice;
				//���� ������ �ִ� �ܾ׿��� ��ٱ��� �Ѿ��� �������
				//�ܾ� ������Ʈ �ϱ�
				String updateBalance = "UPDATE bank SET balance = ? WHERE account_name = '������'";
				PreparedStatement upst = connection.prepareStatement(updateBalance);
				upst.setDouble(1, newBalance);
				upst.executeUpdate();
				
				System.out.println("���� �Ϸ�. ���� �ܾ�: " + newBalance);
				return true;
			}else {
				System.out.println("���¸� ã�� �� �����ϴ�.");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return false;
	}

}
