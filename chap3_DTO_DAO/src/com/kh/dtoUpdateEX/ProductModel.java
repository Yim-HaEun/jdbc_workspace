package com.kh.dtoUpdateEX;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//제품의 이름을 입력해 가격을 변경해봅시다.
public class ProductModel {
	private static Connection connection;
	
	private static ProductModel productModel = null;
	private static String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String username = "khcafes";
	private static String password = "khcafes";
	
	private ProductModel() {
		
	}
	public static ProductModel getInstance() throws SQLException {
		if(productModel == null) {
			productModel = new ProductModel();
			connection = DriverManager.getConnection(DB_URL, username, password);
		}
		return productModel;
	}
	public boolean updateProduct(ProductDTO product) {
		String sql = "UPDATE products SET price = ? WHERE product_name = ?"+
	"VALUES(?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setDouble(1, product.getPrice());
			ps.setString(2,product.getProductName());
			
			int rowsEffected = ps.executeUpdate();
			return rowsEffected > 0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}

}
