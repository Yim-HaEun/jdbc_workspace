package com.kh.dtoSample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		//connection�� ������ ���� �ۼ�
		//url username password
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "khcafes";
		String password = "khcafes";
		
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			//�ν��Ͻ� �����Ͽ� �� �ʱ�ȭ
			CafeView veiw = new CafeView();
			
			//�ν��Ͻ� �����Ͽ� ��Ʈ�ѷ� �ʱ�ȭ
			CafeController controller = new CafeController(con, veiw);
			
			//ī�� ���� ǥ���ϴ� �޼��� ��������
			controller.displayALLCafes();
			
			//connection.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
