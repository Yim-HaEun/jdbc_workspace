package com.kh.MVC.shopping;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	//ArrayList
	private List<ProductDTO> cartList;
	
	//����īƮ ������
	public ShoppingCart() {
		cartList = new ArrayList<>();
	}
		
	//��ٱ��� ��� �������� get�޼��� ����
	public List<ProductDTO> getCartList(){
		return cartList;
	
	}
	//��ٱ��Ͽ� �߰��� �޼��� ����
	public void addCart(/*�Ķ���� �� �߰�*/ProductDTO product) {
		cartList.add(product);
		System.out.println(product.getProduct_name()+ "��ٱ��Ͽ� �߰��߽��ϴ�.");
		
		
	}
	//��ٱ��Ͽ��� ��ǰ�� ������ �޼��� ����
	public void removeGoods(ProductDTO product) {
		if (cartList.remove(product)) {
			System.out.println("��ٱ��Ͽ��� �����߽��ϴ�.");
		
		}else {
			System.out.println("��ٱ��Ͽ� �ش� ��ǰ�� �����ϴ�.");
		}
		
	}
	//��ٱ��� ���� ���� �ݾ� �޼���
	public double cartTotalPrice() {
		double totalPrice = 0;
		//���� for���� �̿��ؼ� ���� �߰�
		for(ProductDTO c : cartList) {
			totalPrice += c.getPrice();
			
		}
		return totalPrice;
	}

}