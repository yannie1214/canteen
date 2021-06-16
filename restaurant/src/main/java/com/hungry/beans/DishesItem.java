package com.hungry.beans;

public class DishesItem {
private Dishes dishes;
private int Quantity;
public Dishes getDishes() {
	return dishes;
}
public void setDishes(Dishes dishes) {
	this.dishes = dishes;
}
public int getQuantity() {
	return Quantity;
}
public void setQuantity(int quantity) {
	Quantity = quantity;
}
public DishesItem(Dishes dishes, int quantity) {
	super();
	this.dishes = dishes;
	Quantity = quantity;
}
public DishesItem() {
	super();
	// TODO Auto-generated constructor stub
}
public String toString() {
	return dishes.toString()+"quantity="+Quantity;
}
}
