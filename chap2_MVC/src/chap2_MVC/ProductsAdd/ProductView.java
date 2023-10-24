package chap2_MVC.ProductsAdd;
import java.util.List;
public class ProductView {
	

	public void showProductList(List<ProductDTO> products /*제품 리스트 파라미터 추가*/) {
		for(ProductDTO p : products) { //p=product
			System.out.println("제품명 : " + p.getProduct_name());
			System.out.println("가격 : " + p.getPrice());
			System.out.println("=============================");
		}
	}	
		//제품 최종 가격 메서드
	public void showTotalPrice(double totalprice) {
		System.out.println("총 가격 : " + totalprice);
		
	}public void showCartList(List<ProductDTO> carts) {
		for(ProductDTO pd :carts) {
			System.out.println("제품명 : " + pd.getProduct_name());
			System.out.println("가격 : " + pd.getPrice());
			System.out.println("---------------------------");
		}
	}
}
	
