package com.kh.MVC.orders;

import java.util.List;

public class OrderController {
	private OrderDAO dao;
	
	public OrderController(OrderDAO dao) {
		this.dao = dao;
		
	}
	//총 가격 계산
	public double calculateTotalPrice(List<OrderDTO> orders) {
		double totalPrice = 0;
		for(OrderDTO totalp : orders) {
			totalPrice += totalp.getTotal_price();
			
		}
		return totalPrice;
	}
	
	//모든 제품 리스트
	public List<OrderDTO> getAllOrders(){
		return dao.getAllOrders();
	}
	

}
