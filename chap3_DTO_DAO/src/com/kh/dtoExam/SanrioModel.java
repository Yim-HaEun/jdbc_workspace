package com.kh.dtoExam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SanrioModel {
	private Connection connection;
	
	public SanrioModel(Connection connection) {
		this.connection = connection;
	}
	public List<sanrioDTO> getSanrios(){
		List<sanrioDTO> sanrios = new ArrayList<>();
		//sqlƒı∏Æ ¿€º∫
		String query = "SELECT * FROM sanrio";
		try {
			PreparedStatement st = connection.prepareStatement(query);
			ResultSet result = st.executeQuery();
			
			while(result.next()) {
				sanrioDTO sanrio = new sanrioDTO();
				sanrio.setsId(result.getInt("s_id"));
				sanrio.setsName(result.getString("s_name"));
				sanrio.setsName(result.getString("s_character"));
				sanrio.setsName(result.getString("s_color"));
				sanrio.setsName(result.getString("s_kind"));
				
				sanrios.add(sanrio);				
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
