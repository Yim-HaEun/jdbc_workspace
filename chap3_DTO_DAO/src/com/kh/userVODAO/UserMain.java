package com.kh.userVODAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UserMain {

	public static void main(String[] args) {
		//1. DB���� URL, USERNAME, PASSWORD
		UserMain um = new UserMain();
		
		//um.selectAll();
		um.selectScanner();
		um.insertRun();
	}
	public void selectScanner() {
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafes";
		String dbPassWord = "khcafes";
		
		try {
			Connection cc = DriverManager.getConnection(jdbcURL, dbUserName, dbPassWord);
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				System.out.println("USER ID �Է� : " );
				System.out.println("�����ϰ� �ʹٸ� Ư������ ���� [e] �Է� : ");
				String input = sc.nextLine();
				System.out.println("USER email �Է� : " );
				String input1 = sc.nextLine();
				//���࿡ e�� �Է��ߴٸ� 
				//if("e" == input || "E" == input) {
				if("e".equalsIgnoreCase(input)) { //��ҹ��� ������� 
					System.out.println("����");
					break; // break�� ������ ��������ʰ� "����"�� ��µ�
				}
				int userId = Integer.parseInt(input);
				String email = input1;
				//select�� ����ϱ�
				String sql = "SELECT* FROM USERINFO WHERE user_id = ? AND email = ? ";
				PreparedStatement st = cc.prepareStatement(sql);
				st.setInt(1, userId);
				st.setString(2,email);
				
				ResultSet rs= st.executeQuery();
				
				//selectOne if
				if(rs.next()) {
					System.out.println("user ID : " + rs.getInt("user_id"));
					System.out.println("user NAME : "  + rs.getString("username"));
					System.out.println("EMAIL : " + rs.getString("email"));
					System.out.println("Registration Date : " + rs.getDate("reg_date"));
				}else {
					//boolean ID or Email �ϳ��� ��ġ���� �ʴ� ��� ó��
					boolean idTrue = (Integer.parseInt(input) == (userId));
					boolean emailTrue = (input1 == (email));
					if(!idTrue && emailTrue) {
						System.out.println("��ġ�����ʴ� User ID�Դϴ�.");
					}else if (idTrue && !emailTrue) {
						System.out.println("��ġ���� �ʴ� User Email�Դϴ�.");
					}
					else {
					System.out.println("��ġ�ϴ� User Id�� email�� ã�� �� �����ϴ�.");
					System.out.println();
				}
			}
			
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		
	}
 
	public void selectAll() {
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafes";
		String dbPassWord = "khcafes";
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, dbUserName, dbPassWord);
			UserDAO userDAO = new UserDAO(connection);
			List<UserVO> users = userDAO.getAllUsers();
			for(UserVO u : users) {
				System.out.println("USER ID : " + u.getUserId());
				System.out.println("USER NAME : " + u.getUserName());
				System.out.println("USER EMAIL : " + u.getEmail());
				System.out.println("USER REGISTRATION DATE : " + u.getRegDate());
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void insertRun() {
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafes";
		String dbPassWord = "khcafes";
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, dbUserName, dbPassWord);
			UserDAO userDao = new UserDAO(connection);
			
			Scanner sc = new Scanner(System.in);
			System.out.println("User ID : " );
			int userId = sc.nextInt();
			
			System.out.println("�̸��� �Է����ּ���");
			String userName = sc.next();
			
			System.out.println("���������� �̸��� �ۼ����ּ���.");
			String email = sc.next();
			
			System.out.println("��� ��¥ : ");
			Date regDate = new Date(); // ���� ��¥�� �ð��� ����Ѵٴ� �ǹ�
			
			//DB�� ������� �ν��Ͻ� ���� �� �ۼ����� ���� �����ϱ�
			UserVO newUser = new UserVO();
			newUser.setUserId(userId);
			newUser.setUserName(userName);
			newUser.setEmail(email);
			newUser.setRegDate(regDate);
			
			//�����Ͱ� ���������� ������ boolean���� Ȯ��
			if(userDao.createUser(newUser)) {//true
				System.out.println("������ ���������� ��ϵǾ����ϴ�.");
			}else {
				System.out.println("���� ��Ͽ� �����Ͽ����ϴ�.");
			}
			//���� �ݱ�
			connection.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
