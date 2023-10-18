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
			// 1.����̹� ���� : Oracle JDBC ����̹� Ŭ���� �̸�
		String driver = "oracle.jdbc.driver.OracleDriver";
			//2.����Ŭ �� ��ǻ�� ���� : �����ͺ��̽� ���� ����
			//								���� IP�ּ�: port ��ȣ
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khbank";
		String password = "khbank";
		Connection con = null;
			
			try {
				//������ ����Ͽ� ���� ���� �Ǵ� �����ͺ��̽� �۾� ����
				con = DriverManager.getConnection(url, user, password);
				System.out.println("�����ͺ��̽� ���� ���� !");
				
				//SELECT ����
				String selectQuery = "SELECT * FROM BANK";
				PreparedStatement selectState = con.prepareStatement(selectQuery);
				ResultSet result = selectState.executeQuery();
				//result.next() : result ��ü���� ���� ��(row)���� �̵�, 
				//���� ���� ������ true ��ȯ, �׷��� ������ false
				while(result.next()) {
					//khbank�� �ִ� bank ���̺�	��� ���տ��� account_id�� ������
					int accountID = result.getInt("account_id");
					//khbank�� �ִ� bank���̺� ��� ���տ��� account_name�� ������
					
					//1.�Բ��غ��� accountNumber ���
					String accountNumber = result.getString("account_number");
					
					String accountName = result.getString("account_name");
					double balance = result.getDouble("balance");
					//2. �Բ��غ��� : branchName
					String branchName = result.getString("branch_name");
					//3. �Բ��غ��� :java.sql import Date lastTransactionDate��������
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
			// 1.����̹� ���� : Oracle JDBC ����̹� Ŭ���� �̸�
			String driver = "oracle.jdbc.driver.OracleDriver";
			//2.����Ŭ �� ��ǻ�� ���� : �����ͺ��̽� ���� ����
			//								���� IP�ּ�: port ��ȣ
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "khcafes";
			String password = "khcafes";
			Connection con = null; 
			try {
				con = DriverManager.getConnection(url, user, password);
				System.out.println("���� ���� !");
				
				//SELECT ����
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
				System.out.println("���Ἲ�� !");
				//SELECT ����
				String selectQuery = "SELECT * FROM sanriofriends";
				PreparedStatement selectState = con.prepareStatement(selectQuery);
				ResultSet result = selectState.executeQuery();
				while(result.next()) {
					int Sanrio_ID = result.getInt("s_id");
					String Sanrio_Name = result.getString("s_name");
					String Sanrio_Character = result.getString("s_character");
					String Sanrio_Color = result.getString("s_color");
					String Sanrio_Kind = result.getString("s_kind");
					
					System.out.println("�긮�� ��ȣ : " + Sanrio_Name + " �긮�� ĳ���� �̸� : "+ Sanrio_Name);
					System.out.println("���� : " + Sanrio_Character + "  ���� : " + Sanrio_Color);
					System.out.println("��ü : " + Sanrio_Kind);
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
						//where�� ����Ͽ� �����߰�
						String selectQuery = "SELECT * FROM BANK WHERE account_name in(?,?) ";
						
						PreparedStatement selectState = con.prepareStatement(selectQuery);
						
						//���⿡ ���ϴ� ������ account_id ����
						String[] targetAN = {"������","������"};
						selectState.setString(1, targetAN[0]);
						selectState.setString(2, targetAN[1]);
						
						/**���� ����
						selectState.setString(1,targetAID); // 1�ڸ���
						*/
						ResultSet result = selectState.executeQuery();
						//�� ���翩��
						if(!result.isBeforeFirst()) { //�����Ͱ� ������
							System.out.println("�����ϴ� �����Ͱ� �����ϴ�.");
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
							//System.out.println("���ǿ� �ش��ϴ� �����Ͱ� �����ϴ�.");
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
				
				//Select ����
				String selectQuery = "SELECT cafe_id, menu_name, price FROM MENU WHERE menu_id in(?,?,?)";
				
				PreparedStatement selectState = con.prepareStatement(selectQuery);
				
				int[] targetAID = {10,11,12};
				selectState.setInt(1, targetAID[0]);
				selectState.setInt(2, targetAID[1]);
				selectState.setInt(3, targetAID[2]);
				
				ResultSet result = selectState.executeQuery();
				if(!result.isBeforeFirst()) {
					System.out.println("���� ���������ʽ��ϴ�.");
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
