package com.kh.dtoUpdateEX;

public class ProductDTO {
	//��ǰ�� �̸��� �Է��� ������ �����غ��ô�.
	
		private String productName;
		private double Price;
		
		public ProductDTO() {
			
		}
		public ProductDTO(String productName, double Price ) {
			this.productName = productName;
			this.Price = Price;
		}
		
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public double getPrice() {
			return Price;
		}
		public void setPrice(double Price) {
			this.Price = Price;
		}

}
