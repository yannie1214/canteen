package com.hungry.beans;

public class StarAssess {
private Integer dishesId;
private float starLevel;
private int number;//ÿ����Ʒ�ܹ������۵Ĵ���

public Integer getDishesId() {
	return dishesId;
}
public void setDishesId(Integer dishesId) {
	this.dishesId = dishesId;
}
public float getStarLevel() {
	return starLevel;
}
public void setStarLevel(float starLevel) {
	this.starLevel = starLevel;
}
public StarAssess() {
	super();
	// TODO Auto-generated constructor stub
}
public int getNumber() {
	return number;
}
public void setNumber(int number) {
	this.number = number;
}
public StarAssess(Integer dishesId, float starLevel, int number) {
	super();
	this.dishesId = dishesId;
	this.starLevel = starLevel;
	this.number = number;
}
public String toString() {
  return "dishesId="+dishesId+"startLevel="+starLevel;
}

}
