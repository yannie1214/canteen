package com.hungry.beans;

public class Category {
	public Category(Integer dishes_cid, String dishes_cname) {
		super();
		this.dishes_cid = dishes_cid;
		this.dishes_cname = dishes_cname;
	}
	private Integer dishes_cid;
	private String dishes_cname;
	
	public Category(String name) {
		this.dishes_cname=name;
	}
	
	public Integer getDishes_cid() {
		return dishes_cid;
	}
	public void setDishes_cid(Integer dishes_cid) {
		this.dishes_cid = dishes_cid;
	}
	public String getDishes_cname() {
		return dishes_cname;
	}
	public void setDishes_cname(String dishes_cname) {
		this.dishes_cname = dishes_cname;
	}
	
	
}
