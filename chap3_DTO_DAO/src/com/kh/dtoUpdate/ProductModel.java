package com.kh.dtoUpdate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProductModel {
	private static Connection connection;
	
	private static ProductModel productModel = null;
	private static String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String ID = "khcafes";
	private static String PW = "khcafes";
	
	private ProductModel() {
		
	}
	
	public static ProductModel getInstance() throws SQLException {
		if(productModel == null) {
			productModel = new ProductModel();
			connection = DriverManager.getConnection(DB_URL, ID, PW);
		}
		return productModel;
	}
	public boolean updateProduct(ProductDTO product) {
		String sql = "UPDATE products SET product_name = ? WHERE product_id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1,product.getProductName());
			ps.setInt(2, product.getProductId());
			
			int rowsEffected = ps.executeUpdate();
			return rowsEffected > 0;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	

}
