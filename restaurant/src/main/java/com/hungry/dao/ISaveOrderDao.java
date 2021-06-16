package com.hungry.dao;


import org.apache.ibatis.annotations.Param;

import com.hungry.beans.Cart;
import com.hungry.beans.Order;
import com.hungry.beans.OrderItem;

public interface ISaveOrderDao {

	void saveOrder(Order order);

	void saveItem(OrderItem item);
	void deleteCart(Cart cart);
	
//	//查询已有销量
//	int querySales(Integer dishes_id);	
//	//更新销量
//	void updateSales(Integer dishes_sales,Integer dishes_id);

	//查询销量表中是否有某菜的某个月的记录
	int queryRecord(Integer dishes_id,String year,String month);
	//查询已有销量
	int querySales(Integer dishes_id,String year,String month);		
	//更新销量
	void updateSales(Integer sales,Integer dishes_id,String year,String month);
	//添加某菜的销量记录
	void addDishesSales(Integer dishes_id,String year,String month,Integer sales);
	
}
