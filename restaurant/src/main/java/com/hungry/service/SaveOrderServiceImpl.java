package com.hungry.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hungry.beans.Cart;
import com.hungry.beans.Category;
import com.hungry.beans.Dishes;
import com.hungry.beans.Order;
import com.hungry.beans.OrderItem;
import com.hungry.dao.DishesDao;
import com.hungry.dao.ISaveOrderDao;

@Service
public class SaveOrderServiceImpl implements IOrderService {
	@Autowired
		private ISaveOrderDao dao;
		
		public void setDao(ISaveOrderDao dao) {
			this.dao = dao;
		}

		public void saveOrder(String totalAmount, String aNum_id, Integer uid) {
			Order order = new Order();
			//格式化标签
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			StringBuffer sb = new StringBuffer();
			sb.append("PO-").append(sdf.format(new Date())).append(uid);
			//设置订单编号，OR-yyyyMMddHHmmss-UserId 年月份时分秒
			order.setOrder_code(sb.toString());
			String Order_code = order.getOrder_code();
			//设置下单时间
			order.setCreate_date(new Date());
			Date Create_date = order.getCreate_date();

			//指定用户信息
			order.setUser_id(uid);
			Integer Uid = order.getUser_id();
			//指定订单总金额
			order.setAmount(Double.valueOf(totalAmount));
			double Amount = order.getAmount();
			System.out.println(Create_date+"  "+Order_code+"  "+Uid+"  "+Amount);
			dao.saveOrder(order);
			
			int order_id = order.getId();
			
			//保存订单之后获取订单id，插入至订单明细中#2_1#1_1==>2_1#1_1
			aNum_id = aNum_id.substring(1);
			//按照#进行切分{2_1,1_1}
			String[] aInfos = aNum_id.split("#");
			
			for(String info :aInfos) {
				//获取商品id和购买数量
				String[] id_num = info.split("_");
				OrderItem item = new OrderItem();
				item.setDishes_id(Integer.valueOf(id_num[1]));
				item.setOrder_num(Integer.valueOf(id_num[0]));
				/*
				 * item.setDishes_id(Integer.valueOf(id_num[0]));
				 * item.setOrder_num(Integer.valueOf(id_num[1]));
				 */
				item.setOrder_id(order_id);
				dao.saveItem(item);
			    int	D_id=Integer.valueOf(id_num[1]);
			    int U_id=uid;
			    Cart cart=new Cart(D_id,U_id,0);
			    dao.deleteCart(cart);
		    
//			    int sales_volume=dao.querySales(D_id);
//			    int dishes_sales=Integer.valueOf(id_num[0])+sales_volume;
//				dao.updateSales(dishes_sales,D_id);	
			    	
			     //截取年月
			    String year=String.format("%tY", Create_date);
			    String month=String .format("%tm", Create_date); 
			    int amount=Integer.valueOf(id_num[0]);
			     //查询销量表中是否有某菜的某个月的记录
			    int count=dao.queryRecord(D_id, year, month);
			     //有记录则直接更新数量
			    if(count!=0) {
			    	//查询已有销量
			    	int exist_sales=dao.querySales(D_id, year, month);
			    	//设置新销量
			    	int sales=amount+exist_sales;
			    	dao.updateSales(sales, D_id, year, month);
			    }else {			       
			    	//无记录则设置添加新的记录			    	
			    	dao.addDishesSales(D_id, year, month, amount);
			    }
		      
	    
			}			
		}

	}