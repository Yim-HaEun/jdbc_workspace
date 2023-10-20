package com.kh.dtoSample;

import java.util.List;

public class CafeView {
	//view에는 주로 void 메서드를 사용한다.
	public void displayCafes(List<cafeDTO> cafes) {
		for(cafeDTO c : cafes) {//향상된 for문으로 하나씩 가져와 cafes에 넣겠다.
			System.out.println("Cafe Id : " + c.getCafeId());
			System.out.println("Cafe Name : " + c.getCafeName());
			System.out.println("Address : "+ c.getAddress());
			System.out.println("Phone Number : " + c.getOperatingHours());
			System.out.println();
		}
	}
}
