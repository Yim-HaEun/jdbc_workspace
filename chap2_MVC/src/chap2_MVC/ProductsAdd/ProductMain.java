package chap2_MVC.ProductsAdd;

import java.util.List;

public class ProductMain {

	public static void main(String[] args) {
		ProductMain pm = new ProductMain();
		//pm.getAll();
		pm.getAllcarts();
	}
	public void getAll() {
		// TODO Auto-generated method stub
		ProductDAO dao = new ProductDAO();
		ProductController controller = new ProductController(dao);
		ProductView view = new ProductView();
		
		//모든 제품 리스트 가져오기
		List<ProductDTO> products = controller.getAllProducts();
		view.showProductList(products);
		
		//최종가격 계산 가져오기
		double totalPrice = controller.calculateTotalPrice(products);
		view.showTotalPrice(totalPrice);
	}
	
	public void getAllcarts() {
		ProductDAO dao = new ProductDAO();
		ProductController controller = new ProductController(dao);
		ProductView view = new ProductView();
	
		//장바구니 제품 리스트 가져오기
		List<ProductDTO> carts = controller.getCart();
		view.showCartList(carts);
		
		//최종 장바구니 계산 가져오기
		double totalPrice = controller.calculateCart(carts);
		view.showTotalPrice(totalPrice);
	}

}
