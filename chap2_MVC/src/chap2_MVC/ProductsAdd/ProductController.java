package chap2_MVC.ProductsAdd;

import java.util.List;

public class ProductController {
	private ProductDAO dao;
	
	public ProductController(ProductDAO dao) {
		this.dao =dao;
	}
	//�� ���� ��� 
	public double calculateTotalPrice(List<ProductDTO> products) {
		double totalPrice = 0;
		//totalPrice=0�� ���� : ���� for ���� Ȱ���Ͽ� ������ ������ ���̱� ����
		for(ProductDTO totalP : products) {
			totalPrice += totalP.getPrice();
		}
		return totalPrice;
	}
	
	//��� ��ǰ ����Ʈ
	public List<ProductDTO> getAllProducts(){
		return dao.getAllProducts();
	}
	//��ٱ��� �� ���� ���
	public double calculateCart(List<ProductDTO> carts) {
		double totalPrice = 0;
		for(ProductDTO totalc : carts) {
			totalPrice += totalc.getPrice();
		}
		return totalPrice;
	}
	//��ٱ��� ����Ʈ
	public List<ProductDTO> getCart(){
		return dao.getCart();
	}
}
