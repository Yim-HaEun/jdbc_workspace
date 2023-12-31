package chap2_MVC.ProductsAdd;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductDAO {


	private Connection connection;
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "khcafes";
	String password = "khcafes";
	
	public ProductDAO() {
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public List<ProductDTO> getAllProducts(){
		List<ProductDTO> products = new ArrayList<>();
		try {
			PreparedStatement st = connection.prepareStatement("SELECT * FROM products");
			ResultSet result = st.executeQuery();
			
			while(result.next()) {
				int product_id = result.getInt("product_id");
				String product_name = result.getString("product_name");
				String category = result.getString("category");
				Double price = result.getDouble("price");
				int stock_quantity = result.getInt("stock_quantity");
				
				ProductDTO product = new ProductDTO(product_id, product_name, category, price, stock_quantity);
				products.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}

	public List<ProductDTO> getCart() {
		// TODO Auto-generated method stub
		List<ProductDTO> carts = new ArrayList<>();
		try {
			connection = DriverManager.getConnection(url, username, password);
			Scanner sc = new Scanner(System.in);
			while(true) { //id를 입력받아 장바구니에 제품을 담기
				System.out.println("제품 id 입력: ");
				System.out.println("종료하고 싶다면 특수문자 제외 [e] 입력: ");
				String input = sc.next();
				
				if("e".equalsIgnoreCase(input)) {
					System.out.println("장바구니 담기 끝");
					
					break;
				}
				int product_id = Integer.parseInt(input);
				String sql = "SELECT product_name, price FROM products WHERE product_id = ? ";
				PreparedStatement st = connection.prepareStatement(sql);
				st.setInt(1, product_id);

				ResultSet rs = st.executeQuery();

				while(rs.next()) {
					String product_name =rs.getString("product_name");
					double price = rs.getDouble("price");
					
					System.out.println("제품명 : " + rs.getString("product_name"));
					System.out.println("가격 : " + rs.getDouble("price"));
				
				ProductDTO cart = new ProductDTO(product_id, product_name, price);
					carts.add(cart);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return carts;
	}
	
}

