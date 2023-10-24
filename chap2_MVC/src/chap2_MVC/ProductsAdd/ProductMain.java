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
		
		//��� ��ǰ ����Ʈ ��������
		List<ProductDTO> products = controller.getAllProducts();
		view.showProductList(products);
		
		//�������� ��� ��������
		double totalPrice = controller.calculateTotalPrice(products);
		view.showTotalPrice(totalPrice);
	}
	
	public void getAllcarts() {
		ProductDAO dao = new ProductDAO();
		ProductController controller = new ProductController(dao);
		ProductView view = new ProductView();
	
		//��ٱ��� ��ǰ ����Ʈ ��������
		List<ProductDTO> carts = controller.getCart();
		view.showCartList(carts);
		
		//���� ��ٱ��� ��� ��������
		double totalPrice = controller.calculateCart(carts);
		view.showTotalPrice(totalPrice);
	}

}
