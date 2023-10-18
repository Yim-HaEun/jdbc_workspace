package com.kh.oracledb.CRUD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class selectSample {
	
	public static void main(String[] args) {
		//SelectALl();
		//Selectkhcafe();
		Selectsanrio_world();
		//SelectOne();
		//SelectIfkhcafe();
	}
		
	static void SelectALl(){
			// 1.드라이버 연결 : Oracle JDBC 드라이버 클래스 이름
		String driver = "oracle.jdbc.driver.OracleDriver";
			//2.오라클 내 컴퓨터 연결 : 데이터베이스 연결 정보
			//								나의 IP주소: port 번호
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "khbank";
		Connection con = null;
			
			try {
				//연결을 사용하여 쿼리 실행 또는 데이터베이스 작업 수행
				con = DriverManager.getConnection(url, user, password);
				System.out.println("데이터베이스 연결 성공 !");
				
				//SELECT 쿼리
				String selectQuery = "SELECT * FROM BANK";
				PreparedStatement selectState = con.prepareStatement(selectQuery);
				ResultSet result = selectState.executeQuery();
				//result.next() : result 객체에서 다음 행(row)으로 이동, 
				//다음 행이 있으면 true 반환, 그렇지 않으면 false
				while(result.next()) {
					//khbank에 있는 bank 테이블	결과 집합에서 account_id를 가져옴
					int accountID = result.getInt("account_id");
					//khbank에 있는 bank테이블 결과 집합에서 account_name을 가져옴
					
					//1.함께해보기 accountNumber 출력
					String accountNumber = result.getString("account_number");
					
					String accountName = result.getString("account_name");
					double balance = result.getDouble("balance");
					//2. 함께해보기 : branchName
					String branchName = result.getString("branch_name");
					//3. 함께해보기 :java.sql import Date lastTransactionDate가져오기
					Date lastTransactionDate = result.getDate("last_transaction_date");
					
					System.out.println("ACCOUNT_ID : " + accountID + "  Account_Number : " + accountNumber);
					System.out.println("ACCOUNT_NAME : " + accountName);
					System.out.println("Branch_NAME : "+ branchName +" Balance : " + balance);
					System.out.println("Last_Transaction_Date" + lastTransactionDate);
					System.out.println("");
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		static void Selectkhcafe() {
			// 1.드라이버 연결 : Oracle JDBC 드라이버 클래스 이름
			String driver = "oracle.jdbc.driver.OracleDriver";
			//2.오라클 내 컴퓨터 연결 : 데이터베이스 연결 정보
			//								나의 IP주소: port 번호
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "khcafes";
			String password = "khcafes";
			Connection con = null; 
			try {
				con = DriverManager.getConnection(url, user, password);
				System.out.println("연결 성공 !");
				
				//SELECT 쿼리
				String selectQuery = "SELECT c_name,c_address,operating_hours FROM cafes ORDER BY cafe_id DESC";
				PreparedStatement selectState = con.prepareStatement(selectQuery);
				ResultSet result = selectState.executeQuery();
				while(result.next()) {
					//int cafeID = result.getInt("cafe_id");
					String cafeName = result.getString("c_name");
					String cafeAddress = result.getString("c_address");
					String operatingHours = result.getString("operating_hours");
					
					//System.out.println("cafe ID : " + cafeID );
					System.out.println(" cafe Name : " +cafeName);
					System.out.println("cafe Address : " + cafeAddress );
					System.out.println("Operating Hours : " + operatingHours);
					System.out.println(" ");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		static void Selectsanrio_world() {

			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "sanrio";
			String password = "sanrio";
			Connection con = null;
			try {
				con = DriverManager.getConnection(url,user,password);
				System.out.println("연결성공 !");
				//SELECT 쿼리
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

		static void SelectIf() {
					String url = "jdbc:oracle:thin:@localhost:1521:xe";
					String user = "khbank";
					String password = "khbank";
					Connection con = null; 
					
					try {
						con = DriverManager.getConnection(url,user,password);
						//where절 사용하여 조건추가
						String selectQuery = "SELECT * FROM BANK WHERE account_name in(?,?) ";
						
						PreparedStatement selectState = con.prepareStatement(selectQuery);
						
						//여기에 원하는 조건의 account_id 설정
						String[] targetAN = {"나부자","나거지"};
						selectState.setString(1, targetAN[0]);
						selectState.setString(2, targetAN[1]);
						
						/**조건 설정
						selectState.setString(1,targetAID); // 1자리값
						*/
						ResultSet result = selectState.executeQuery();
						//값 존재여부
						if(!result.isBeforeFirst()) { //데이터가 없을때
							System.out.println("존재하는 데이터가 없습니다.");
						}
						while(result.next()) {
							int a = result.getInt("account_id");
							String b = result.getString("account_number");
							String c = result.getString("account_name");
							double d = result.getDouble("balance");
							String e = result.getString("branch_name");
							Date f = result.getDate("last_transaction_date");
							
			

							System.out.println("ACCOUNT_ID : " + a);
							System.out.println("ACCOUNT_Number : " + b);
							System.out.println("ACCOUNT_Name : " + c);
							System.out.println("Balance : " + d);
							System.out.println("Branch_Name : " + e);
							System.out.println("Last_Transaction_Date : " + f);
							System.out.println("");
							
						//}else {
							//System.out.println("조건에 해당하는 데이터가 없습니다.");
						}
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		}
		static void SelectIfkhcafe() {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url ="jdbc:oracle:thin:@localhost:1521:xe";
			String user = "khcafes";
			String password = "khcafes";
			Connection con = null;
			try {
				con = DriverManager.getConnection(url,user,password);
				
				//Select 쿼리
				String selectQuery = "SELECT cafe_id, menu_name, price FROM MENU WHERE menu_id in(?,?,?)";
				
				PreparedStatement selectState = con.prepareStatement(selectQuery);
				
				int[] targetAID = {10,11,12};
				selectState.setInt(1, targetAID[0]);
				selectState.setInt(2, targetAID[1]);
				selectState.setInt(3, targetAID[2]);
				
				ResultSet result = selectState.executeQuery();
				if(!result.isBeforeFirst()) {
					System.out.println("값이 존재하지않습니다.");
				}
					while(result.next()) {
						int cafeID = result.getInt("cafe_id");
						String menuName = result.getString("menu_name");
						double Price = result.getDouble("price");
						
						System.out.println("CAFE_ID : " + cafeID + " MENU : " + menuName + "PRICE : $" +Price);
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}

}
