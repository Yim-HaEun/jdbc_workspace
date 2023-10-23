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
		//1. DB연결 URL, USERNAME, PASSWORD
		UserMain um = new UserMain();
		
		//um.selectAll();
		um.selectScanner();
		um.insertRun();
	}
	//boolean idTrue = checkId(userId);
	public boolean checkEmail(String email) throws SQLException {
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafes";
		String dbPassWord = "khcafes";

		Connection connection = DriverManager.getConnection(jdbcURL, dbUserName, dbPassWord);
		
		String sql = "SELECT COUNT(*) FROM userinfo WHERE email = ? ";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, email);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			int count = rs.getInt(1);
			return count > 0; //1이상이면 true
		}		
		return false;
		
	}
	public boolean checkId(int userId) throws SQLException{
		//1.db연결
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafes";
		String dbPassWord = "khcafes";

		Connection connection = DriverManager.getConnection(jdbcURL, dbUserName, dbPassWord);
			
		//2.SQL
		String sql = "SELECT * FROM USERINFO WHERE user_id = ?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setInt(1, userId);
		//3.if 활용해서 Result.next()
			
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			int id = rs.getInt(1);
			//return >0 1 이상이면 일치
			return id > 0; //이상이면 true
				
		}
		return false; //일치하지 않을 때
	}

	public void selectScanner() {
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafes";
		String dbPassWord = "khcafes";
		
		try {
			Connection cc = DriverManager.getConnection(jdbcURL, dbUserName, dbPassWord);
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				System.out.println("USER ID 입력 : " );
				System.out.println("종료하고 싶다면 특수문자 제외 [e] 입력 : ");
				String input = sc.nextLine();
				System.out.println("USER email 입력 : " );
				String input1 = sc.nextLine();
				//만약에 e를 입력했다면 
				//if("e" == input || "E" == input) {
				if("e".equalsIgnoreCase(input)) { //대소문자 상관없이 
					System.out.println("종료");
					break; // break가 없으면 종료되지않고 "종료"만 출력됨
				}
				int userId = Integer.parseInt(input);
				String email = input1;
				//select문 출력하기
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
					//boolean ID or Email 하나가 일치하지 않는 경우 처리
					//boolean idTrue = (Integer.parseInt(input) == (userId));
					boolean idTrue = checkId(userId);
					boolean emailTrue = checkEmail(email);
					//boolean emailTrue = (input1 == (email));
					if(!idTrue && emailTrue) {
						System.out.println("일치하지않는 User ID입니다.");
						System.out.println();
					}else if (idTrue && !emailTrue) {
						System.out.println("일치하지 않는 User Email입니다.");
						System.out.println();
					}
					else {
					System.out.println("일치하는 User Id와 email을 찾을 수 없습니다.");
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
			
			System.out.println("이름을 입력해주세요");
			String userName = sc.next();
			
			System.out.println("마지막으로 이메일 작성해주세요.");
			String email = sc.next();
			
			System.out.println("등록 날짜 : ");
			Date regDate = new Date(); // 현재 날짜와 시간을 사용한다는 의미
			
			//DB에 담기위해 인스턴스 생성 후 작성받은 정보 저장하기
			UserVO newUser = new UserVO();
			newUser.setUserId(userId);
			newUser.setUserName(userName);
			newUser.setEmail(email);
			newUser.setRegDate(regDate);
			
			//데이터가 정상적으로 들어갔는지 boolean으로 확인
			if(userDao.createUser(newUser)) {//true
				System.out.println("유저가 성공적으로 등록되었습니다.");
			}else {
				System.out.println("유저 등록에 실패하였습니다.");
			}
			//연결 닫기
			connection.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
