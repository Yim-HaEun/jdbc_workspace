package com.kh.dtoSample;

import java.util.List;

public class CafeView {
	//view���� �ַ� void �޼��带 ����Ѵ�.
	public void displayCafes(List<cafeDTO> cafes) {
		for(cafeDTO c : cafes) {//���� for������ �ϳ��� ������ cafes�� �ְڴ�.
			System.out.println("Cafe Id : " + c.getCafeId());
			System.out.println("Cafe Name : " + c.getCafeName());
			System.out.println("Address : "+ c.getAddress());
			System.out.println("Phone Number : " + c.getOperatingHours());
			System.out.println();
		}
	}
}
