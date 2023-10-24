package chap2_MVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class cafeModel {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "khcafes";
	String password = "khcafes";
	public void insertcafe(String name, String address , String phoneNumber, String operatingHours) {
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			String sql = "INSERT INTO cafes (c_name,c_address,phone_number,operating_hours) "
					+"VALUES(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,name);
			ps.setString(2,address);
			ps.setString(3, phoneNumber);
			ps.setString(4,operatingHours);
			
			ps.executeUpdate();
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateMenu(String description,int menuId, int cafeId) {
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			String sql = "UPDATE menu SET description = ? WHERE menu_id =? AND cafe_id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, description);
			st.setInt(2, menuId);
			st.setInt(3, cafeId);
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}					//매개변수 추가하기
	

	public void updateCafe(int cafeId, String OP_hours) {
		//카페 운영시간 수정하기
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			String sql = "UPDATE cafes SET operating_hours = ? WHERE cafe_id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, OP_hours);
			st.setInt(2,cafeId);
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void deleteCafe(/*매개변수 자리*/ int cafeId) {
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			String sql = "DELETE FROM cafes WHERE cafe_id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, cafeId);
			
			st.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void deleteMenu(/*매개변수 (파라미터) 추가*/ int cafeID) {

		try {
			Connection con = DriverManager.getConnection(url, username, password);
			String sql = "DELETE FROM menu WHERE cafe_id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, cafeID);
			st.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
}
