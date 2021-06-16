package com.hungry.dao;

import java.util.List;

import com.hungry.beans.Cart;
import com.hungry.beans.Dishes;

public interface CartDao {
void insertDishes(Cart cart);
Dishes findById(Integer dishes_id);
List<Cart> selectCartByUid(int U_id);
void deleteDishes(Cart cart);
Dishes selectDishesById(int d_id);
Cart selectCart(Cart cart);
void updateQuantity(Cart cart);
void deleteCart(int U_id);
}
