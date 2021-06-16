package com.hungry.beans;

public class Dishes {
	private Integer dishes_id;
	private Double dishes_price;
	private String dishes_name;
	private String dishes_describe;
	private String photo;
	private String dishes_cname;
		
	public Dishes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dishes(Integer dishes_id, Double dishes_price, String dishes_name, String dishes_describe, String photo,
			String dishes_cname) {
		super();
		this.dishes_id = dishes_id;
		this.dishes_price = dishes_price;
		this.dishes_name = dishes_name;
		this.dishes_describe = dishes_describe;
		this.photo = photo;
		this.dishes_cname = dishes_cname;
	}
	public Dishes(double dishes_price, String dishes_name, String dishes_describe,
			String dishes_cname, String photo) {
		super();
		this.dishes_price = dishes_price;
		this.dishes_name = dishes_name;
		this.dishes_describe = dishes_describe;
		this.dishes_cname = dishes_cname;
		this.photo = photo;
	}
	
	public Integer getDishes_id() {
		return dishes_id;
	}

	public void setDishes_id(Integer dishes_id) {
		this.dishes_id = dishes_id;
	}

	public Double getDishes_price() {
		return dishes_price;
	}

	public void setDishes_price(Double dishes_price) {
		this.dishes_price = dishes_price;
	}

	public String getDishes_name() {
		return dishes_name;
	}

	public void setDishes_name(String dishes_name) {
		this.dishes_name = dishes_name;
	}

	public String getDishes_describe() {
		return dishes_describe;
	}

	public void setDishes_describe(String dishes_describe) {
		this.dishes_describe = dishes_describe;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String dishes_photo) {
		this.photo = dishes_photo;
	}


	public String getDishes_cname() {
		return dishes_cname;
	}
	public void setDishes_cname(String dishes_cname) {
		this.dishes_cname = dishes_cname;
	}
	
	
	@Override
	public String toString() {
		return "Dish[id=" + dishes_id + ", name=" + dishes_name + ", dishes_cname=" +dishes_cname 
				+ ", price=" + dishes_price + "]";
	}
	
}
