package chap2_MVC.ProductsAdd;
import java.util.List;
public class ProductView {
	

	public void showProductList(List<ProductDTO> products /*��ǰ ����Ʈ �Ķ���� �߰�*/) {
		for(ProductDTO p : products) { //p=product
			System.out.println("��ǰ�� : " + p.getProduct_name());
			System.out.println("���� : " + p.getPrice());
			System.out.println("=============================");
		}
	}	
		//��ǰ ���� ���� �޼���
	public void showTotalPrice(double totalprice) {
		System.out.println("�� ���� : " + totalprice);
		
	}public void showCartList(List<ProductDTO> carts) {
		for(ProductDTO pd :carts) {
			System.out.println("��ǰ�� : " + pd.getProduct_name());
			System.out.println("���� : " + pd.getPrice());
			System.out.println("---------------------------");
		}
	}
}
	
