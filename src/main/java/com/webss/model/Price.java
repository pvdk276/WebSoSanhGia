package com.webss.model;

import java.sql.Date;

import com.google.gson.annotations.Expose;

public class Price {
	private int productid;
	@Expose
	private Date priceDate;
	@Expose
	private int price;
	
	public Price(int productid, Date priceDate, int price){
		this.setProductid(productid);
		this.setPriceDate(priceDate);
		this.setPrice(price);
	}
	
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public Date getPriceDate() {
		return priceDate;
	}
	public void setPriceDate(Date priceDate) {
		this.priceDate = priceDate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
