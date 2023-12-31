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
		double cartTotalPrice = cart.cartTotalPrice(); //카트 안에 최종 결제 금액 메서드 추가하기
		
		try {
			connection  = DriverManager.getConnection(url, username, password);
			//나부자씨의 계좌 잔액 가져오기
			String balanceUser = "SELECT balance FROM BANK WHERE account_name = '나부자'";
			PreparedStatement st = connection.prepareStatement(balanceUser);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				double balance = rs.getDouble("balance");
				//만약에 잔액이 장바구니 총액보다 적다면
				if(balance < cartTotalPrice) {
					System.out.println("잔액이 부족합니다.");
					return false;
				}
				double newBalance = balance - cartTotalPrice;
				//내가 가지고 있는 잔액에서 장바구니 총액을 빼줘야함
				//잔액 업데이트 하기
				String updateBalance = "UPDATE bank SET balance = ? WHERE account_name = '가나다'";
				PreparedStatement upst = connection.prepareStatement(updateBalance);
				upst.setDouble(1, newBalance);
				upst.executeUpdate();
				
				System.out.println("결제 완료. 남은 잔액: " + newBalance);
				return true;
			}else {
				System.out.println("계좌를 찾을 수 없습니다.");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return false;
	}

}
