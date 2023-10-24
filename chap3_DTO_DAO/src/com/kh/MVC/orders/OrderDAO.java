package com.kh.MVC.orders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDAO {
	private Connection connection;
	String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "khcafes";
	String password = "khcafes";
	
	public OrderDAO(){
		try {
			connection = DriverManager.getConnection(dburl, username, password);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public List<OrderDTO> getAllOrders(){
		List<OrderDTO> orders = new ArrayList<>();
		try {
			PreparedStatement st = connection.prepareStatement("SELECT * FROM orders");
			ResultSet  result = st.executeQuery();
			
			while(result.next()) {
				int order_id = result.getInt("order_id");
				int menu_id = result.getInt("menu_id");
				Date order_date = result.getDate("order_date");
				int quantity = result.getInt("quantity");
				double total_price = result.getDouble("total_price");
				
				OrderDTO order = new OrderDTO(order_id, menu_id, order_date,quantity,total_price);
				orders.add(order);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orders;
			
	}
}
