package com.hungry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hungry.beans.Cart;
import com.hungry.beans.Dishes;
import com.hungry.dao.CartDao;
@Service
public class CartServiceImpl implements CartService{
	@Autowired
private CartDao dao;
public void setDao(CartDao dao) {
	this.dao = dao;
}
	public void addToCart(Cart cart) {
		// TODO Auto-generated method stub
		dao.insertDishes(cart);
	}


	public void removeFromCart(Cart cart) {
		// TODO Auto-generated method stub
		dao.deleteDishes(cart);
	}


	public List<Cart> displayCart(int U_id) {
		// TODO Auto-generated method stub
		List<Cart> cList=null;
		cList=dao.selectCartByUid(U_id);
		return cList;
	}


	@Override
	public Dishes showDishes(int D_id) {
		// TODO Auto-generated method stub
		Dishes d1=new Dishes();
		d1=dao.findById(D_id);
		return d1;
	}



	public Cart queryCart(Cart cart) {
		// TODO Auto-generated method stub
		Cart c=new Cart();
		c=dao.selectCart(cart);
		return c;
	}


	@Override
	public void addToCartByModify(Cart cart) {
		// TODO Auto-generated method stub
		dao.updateQuantity(cart);
	}
	@Override
	public void deleteCart(int U_id) {
		dao.deleteCart(U_id);
		
	}


}