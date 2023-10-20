package com.kh.dtoUpdateEX;

import java.sql.SQLException;
import java.util.Scanner;

public class ProductView {
	public void updateProduct() {
		Scanner scan = new Scanner(System.in);
		System.out.println("제품의 이름을 받아 가격을 업데이트합니다.");
		System.out.println("제품명 입력 :");
		String productName = scan.next();
		
		System.out.println("가격 수정 : ");
		double Price = scan.nextDouble();
		
		ProductDTO  newProductPrice = new ProductDTO(productName, Price);
		ProductModel productModel;
		
		boolean success = false;
		try {
			productModel = ProductModel.getInstance();
			success = productModel.updateProduct(newProductPrice);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (success) {
			System.out.println("제품 가격이 성공적으로 변경되었습니다.");
		}else {
			System.out.println("제품 가격 업데이트 중 오류 발생");
		}
		scan.close();
		
		
	}
	

}
