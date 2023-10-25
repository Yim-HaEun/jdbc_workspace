package com.kh.MVC.shopping;

public class ProductDTO {
	private int product_id;
	private String product_name;
	private String category;
	private Double price;
	private int stock_quantity;
	
	//»ý¼ºÀÚ
	
	public ProductDTO(int product_id, String product_name, String category, Double price, int stock_quantity) {
		this.product_id = product_id;
		this.product_name = product_name;
		this.category = category;
		this.price = price;
		this.stock_quantity = stock_quantity;
		
	}
	
	
	public ProductDTO(int product_id, String product_name, Double price) {
		this.product_id = product_id;
		this.product_name = product_name;
		this.price = price;
	}

	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getStock_quantity() {
		return stock_quantity;
	}
	public void setStock_quantity(int stock_quantity) {
		this.stock_quantity = stock_quantity;
	}


}
