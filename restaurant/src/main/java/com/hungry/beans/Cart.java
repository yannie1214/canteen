package com.hungry.beans;

public class Cart {
private Integer D_id;
private Integer U_id;
private Integer Quantity;
public Integer getD_id() {
	return D_id;
}
public void setD_id(Integer d_id) {
	D_id = d_id;
}
public Integer getU_id() {
	return U_id;
}
public void setU_id(Integer u_id) {
	U_id = u_id;
}
public Integer getQuantity() {
	return Quantity;
}
public void setQuantity(Integer quantity) {
	Quantity = quantity;
}
public Cart() {
	super();
	// TODO Auto-generated constructor stub
}
public Cart(Integer d_id, Integer u_id, Integer quantity) {
	super();
	D_id = d_id;
	U_id = u_id;
	Quantity = quantity;
}
}
