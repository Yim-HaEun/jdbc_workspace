package com.kh.MVC.shopping;

import java.util.List;
import java.util.Scanner;


public class ProductMain {

	public static void main(String[] args) {
		ProductDAO dao = new ProductDAO();
		ProductController controller = new ProductController(dao);
		ProductView view = new ProductView();
		
		Scanner sc = new Scanner(System.in);
		//쇼핑카트 인스턴스 생성자리
		ShoppingCart cart = new ShoppingCart();
		
		int choice = sc.nextInt();
		
		switch(choice) {
		//모든 제품 리스트 가져오기
			case 1:
				List<ProductDTO> products = controller.getAllProducts();
				view.showProductList(products);
				
			case 2: //최종 가격 계산 가져오기
				double totalPrice = controller.calculateTotalPrice(products);
				view.showTotalPrice(totalPrice);
				
			case 3: //제품 추가
				System.out.println("장바구니에 추가할 제품의 ID를 입력하세요 :");
				//제품 아이디 입력받기
				int productId = sc.nextInt();
				//향상된 for문과 if문을 활용해서 제품 담기
				for(ProductDTO p : products) {
					if(p.getProduct_id() == productId) {
						//카트에 추가
						cart.addCart(p);
						System.out.println(p.getProduct_name()+ "장바구니에 담았습니다.");
						break;
						
					}
				}
				
			case 4: //제거
			
				System.out.println("장바구니에서 제거할 제품의 ID를 입력하세요 : ");
				int removeProductId = sc.nextInt();
				//향상된 for문
				for(ProductDTO r : cart.getCartList()/*장바구니 목록 */) {
					if(r.getProduct_id() == removeProductId) {
						cart.removeGoods(r);
						break;
					}
				}
			
			case 5: //결제
				UserPay pay = new UserPay(cart);
				boolean payResult = pay.payment();
				if(payResult) {
					//카트 비우기
					
				}
				break;
				
			default:
				System.out.println("잘못된 선택입니다.");
			
			
		
		//제품 추가
		//제거
		//

		}
	}

}
