package com.hungry.service;

import java.util.List;

import com.hungry.beans.Cart;
import com.hungry.beans.Dishes;

public interface CartService {
void addToCart(Cart cart);
void removeFromCart(Cart cart);
List<Cart> displayCart(int U_id);
void deleteCart(int U_id);
Dishes showDishes(int D_id);
void addToCartByModify(Cart cart);
Cart queryCart(Cart cart);
}
