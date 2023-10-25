package com.kh.MVC.shopping;

import java.util.List;


public class ProductController {
	private ProductDAO dao;
		
		public ProductController(ProductDAO dao) {
			this.dao = dao;
		}
		//총 가격 계산 
		public double calculateTotalPrice(List<ProductDTO> products) {
			double totalPrice = 0;
			//totalPrice=0인 이유 : 향상된 for 문을 활용하여 가격을 더해줄 것이기 때문
			for(ProductDTO totalP : products) {
				totalPrice += totalP.getPrice();
			}
			return totalPrice;
		}
		//모든 제품 리스트
		public List<ProductDTO> getAllProducts(){
			return dao.getAllProducts();
		}
		

}
