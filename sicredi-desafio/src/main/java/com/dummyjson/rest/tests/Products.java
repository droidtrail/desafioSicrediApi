package com.dummyjson.rest.tests;

public class Products {
	private Integer id;
	private String title;
	private String description;
	private Integer price;
	private Float discountPercentage;
	private Float rating;
	private Integer stock;
	private String brand;
	private String category;
	private String thumbnail;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Float getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(double d) {
		this.discountPercentage = (float) d;
	}
	public Float getRating() {
		return rating;
	}
	public void setRating(double d) {
		this.rating = (float) d;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
}
