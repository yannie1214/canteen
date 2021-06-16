package com.hungry.beans;

public class starAssessItem {
private Dishes dishes;
private float starLevel;
public Dishes getDishes() {
	return dishes;
}
public void setDishes(Dishes dishes) {
	this.dishes = dishes;
}
public float getStarLevel() {
	return starLevel;
}
public void setStarLevel(float starLevel) {
	this.starLevel = starLevel;
}
public starAssessItem() {
	super();
	// TODO Auto-generated constructor stub
}
public starAssessItem(Dishes dishes, float starLevel) {
	super();
	this.dishes = dishes;
	this.starLevel = starLevel;
}
public String toString() {
	  return dishes.toString()+"startLevel="+starLevel;
	}
}
