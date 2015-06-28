package com.webss.model;

public class Product {
	private String Name;
	private String Store;
	private String Price;
	private String StoreUrl;
	private String ImageUrl;
	
	public Product(String name, String store, String price, String storeUrl,
			String imageUrl) {
		super();
		Name = name;
		Store = store;
		Price = price;
		StoreUrl = storeUrl;
		ImageUrl = imageUrl;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getStore() {
		return Store;
	}
	public void setStore(String store) {
		Store = store;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public String getStoreUrl() {
		return StoreUrl;
	}
	public void setStoreUrl(String storeUrl) {
		StoreUrl = storeUrl;
	}
	public String getImageUrl() {
		return ImageUrl;
	}
	public void setImageUrl(String imageUrl) {
		ImageUrl = imageUrl;
	}
}
