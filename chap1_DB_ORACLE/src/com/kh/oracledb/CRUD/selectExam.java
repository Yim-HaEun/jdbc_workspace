package com.kh.oracledb.CRUD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class selectExam {
	public static void main(String[] args) {
		SelectAll();
		//SelectOne();
	}
	static void SelectAll() {
		//1.드라이버 연결 : Oracle JDBC 드라이버 클래스 이름
		String driver = "oracle.jdbc.driver.OracleDriver";
		//2.오라클 내 컴퓨터 연결 : 데이터베이스 연결 정보
		//								나의 IP주소: port 번호
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "sanrio";
		String password = "sanrio";
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			
			String selectQuery = "SELECT * FROM sanriofriends";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			ResultSet result = selectState.executeQuery();
			while(result.next()) {
				int Sanrio_ID = result.getInt("s_id");
				String Sanrio_Name = result.getString("s_name");
				String Sanrio_Character = result.getString("s_character");
				String Sanrio_Color = result.getString("s_color");
				String Sanrio_Kind = result.getString("s_kind");
				
				System.out.println("산리오 번호 : " + Sanrio_Name + " 산리오 캐릭터 이름 : "+ Sanrio_Name);
				System.out.println("성격 : " + Sanrio_Character + "  색상 : " + Sanrio_Color);
				System.out.println("정체 : " + Sanrio_Kind);
				System.out.println("");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	static void SelectOne() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "sanrio";
		String password = "sanrio";
		
		try {
			Connection con = DriverManager.getConnection(url,user,password);
			
			//WHERE절을 사용해 조건 추가
			String selectQuery = "SELECT * FROM sanriofriends WHERE s_name in(?,?) ";
			
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			
			String[] targetAN = {"포차코","한교동"};
			selectState.setString(1, targetAN[0]);
			selectState.setString(2, targetAN[1]);
			
			ResultSet result = selectState.executeQuery();
			if(!result.isBeforeFirst()) { //데이터가 없을때
				System.out.println("존재하는 데이터가 없습니다.");
			}
			while(result.next()) {
				int sanID = result.getInt("s_id");
				String sanName = result.getString("s_name");
				String sanCharacter = result.getString("s_character");
				String sanColor = result.getString("s_color");
				String sanKind = result.getString("s_kind");

				System.out.println("산리오 번호 : " + sanID+ "  산리오 이름 : " + sanName);
				System.out.println("성격 : " + sanCharacter);
				System.out.println("색깔 : " + sanColor + "  정체 : " + sanKind);

				System.out.println("");
				} 
			}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}

