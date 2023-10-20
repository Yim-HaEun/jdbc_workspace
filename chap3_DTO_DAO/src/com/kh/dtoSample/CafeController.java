package com.kh.dtoSample;

import java.sql.Connection;
import java.util.List;

//model�� view�� �������ִ� �߰� �ٸ�
public class CafeController {
	//�ʵ�
	private cafeModel model;//�� �������
	private CafeView view;//�� �������
	
	
	//�Ķ���͸� �ۼ��� ������
	public CafeController(Connection con, CafeView view){
		this.model = new cafeModel(con);
		this.view = view;
		
	}
	//��� �޼���
	public void displayALLCafes() {
		List<cafeDTO> cafes = model.getCafes();
		view.displayCafes(cafes);
	}
}
