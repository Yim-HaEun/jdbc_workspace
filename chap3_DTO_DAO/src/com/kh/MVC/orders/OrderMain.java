package com.kh.MVC.orders;

import java.util.List;

public class OrderMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OrderMain om = new OrderMain();
		om.printTotal();
	}
	public void printTotal() {
		OrderDAO dao = new OrderDAO();
		OrderController controller = new OrderController(dao);
		OrderView view = new OrderView();
		
		//모든 제품 리스트 가져오기
		List<OrderDTO> orders = controller.getAllOrders();
		view.showOrderList(orders);
		
		//최종 가격 계산 가져오기
		double totalPrice = controller.calculateTotalPrice(orders);
		view.showTotalPrice(totalPrice);
				
	}
	
}


