package com.kh.dtoUpdateEX;

import java.sql.SQLException;
import java.util.Scanner;

public class ProductView {
	public void updateProduct() {
		Scanner scan = new Scanner(System.in);
		System.out.println("��ǰ�� �̸��� �޾� ������ ������Ʈ�մϴ�.");
		System.out.println("��ǰ�� �Է� :");
		String productName = scan.next();
		
		System.out.println("���� ���� : ");
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
			System.out.println("��ǰ ������ ���������� ����Ǿ����ϴ�.");
		}else {
			System.out.println("��ǰ ���� ������Ʈ �� ���� �߻�");
		}
		scan.close();
		
		
	}
	

}
