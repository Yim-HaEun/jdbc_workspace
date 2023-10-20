package com.kh.dtoUpdate;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ProductView {
	public void updateProduct() {
		Scanner sc = new Scanner(System.in);
		System.out.println("������Ʈ �� ���� �Է�");
		System.out.println("��ǰ ��ȣ ");
		int productId = sc.nextInt();
		
		System.out.println("������ ��ǰ �̸� : ");
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
			System.out.println("��ǰ �̸��� ���������� ����Ǿ����ϴ�.");
		}else {
			System.out.println("��ǰ ������Ʈ �� ������ �߻��߽��ϴ�.");
		}
		sc.close();
		
	}


}
