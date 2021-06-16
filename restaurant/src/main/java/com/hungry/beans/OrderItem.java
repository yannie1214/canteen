package com.hungry.beans;

public class OrderItem {
	
	private int order_id;
	
	private int order_num;
	
	private int dishes_id;
	private Dishes dishes;

	public int getOrder_id() {
		return order_id;
	}
	
	

	public int getDishes_id() {
		return dishes_id;
	}



	public void setDishes_id(int dishes_id) {
		this.dishes_id = dishes_id;
	}





	public Dishes getDishes() {
		return dishes;
	}



	public void setDishes(Dishes dishes) {
		this.dishes = dishes;
	}



	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderItem(int order_num, int dishes_id) {
		super();
		this.order_num = order_num;
		this.dishes_id = dishes_id;
		
	}
	

	public OrderItem(int order_num, int dishes_id, Dishes dishes) {
		super();
		this.order_num = order_num;
		this.dishes_id = dishes_id;
		this.dishes = dishes;
	}


	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getOrder_num() {
		return order_num;
	}

	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}

	
	

}
