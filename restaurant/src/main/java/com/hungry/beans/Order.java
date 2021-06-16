package com.hungry.beans;

import java.util.Date;
import java.util.List;

public class Order {
	
	private int id;
	
	private int user_id;
	
	private int Status;
	
	private int payStatus;
	
	private String order_code;
	
	private Date create_date;
	
	private Date send_date;
	
	private double amount;
	
	private List<OrderItem> items;
	
	

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int user_id, int status, int payStatus, String order_code, Date create_date, Date send_date,
			double amount, List<OrderItem> items) {
		super();
		this.user_id = user_id;
		Status = status;
		this.payStatus = payStatus;
		this.order_code = order_code;
		this.create_date = create_date;
		this.send_date = send_date;
		this.amount = amount;
		this.items = items;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}



	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

	public int getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(int payStatus) {
		this.payStatus = payStatus;
	}

	public String getOrder_code() {
		return order_code;
	}

	public void setOrder_code(String order_code) {
		this.order_code = order_code;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Date getSend_date() {
		return send_date;
	}

	public void setSend_date(Date send_date) {
		this.send_date = send_date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", user_id=" + user_id + ", Status=" + Status + ", payStatus=" + payStatus
				+ ", order_code=" + order_code + ", create_date=" + create_date + ", send_date=" + send_date
				+ ", amount=" + amount + "]";
	}
	
	
	
	

}
