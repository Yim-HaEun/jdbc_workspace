package com.kh.dtoUpdate;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ProductView {
	public void updateProduct() {
		Scanner sc = new Scanner(System.in);
		System.out.println("업데이트 할 정보 입력");
		System.out.println("제품 번호 ");
		int productId = sc.nextInt();
		
		System.out.println("변경할 제품 이름 : ");
		String productName = sc.next();
		
		ProductDTO newProductName = new ProductDTO(productId, productName);
		ProductModel productModel;
		
		boolean success = false;
		try {
			productModel = ProductModel.getInstance();
			success = productModel.updateProduct(newProductName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(success) {
			System.out.println("제품 이름이 성공적으로 변경되었습니다.");
		}else {
			System.out.println("제품 업데이트 중 오류가 발생했습니다.");
		}
		sc.close();
		
	}


}
