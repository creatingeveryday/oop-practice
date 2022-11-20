package com.ex.oop.shoppingmall.customer;

import com.ex.oop.shoppingmall.Cart;
import com.ex.oop.shoppingmall.coupon.Coupon;
import com.ex.oop.shoppingmall.currency.Money;
import com.ex.oop.shoppingmall.item.Item;
import com.ex.oop.shoppingmall.point.Point;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private long userId;
    private String longinId;
    private String password;
    private String name;
    private UserLevel userLevel;

    private Money cash;
    private Point point;
    private List<Coupon> couponList;

    private Cart cart;

    public Customer(String name, UserLevel userLevel) {
        this.name = name;
        this.userLevel = userLevel;
        this.cart = new Cart(this, new ArrayList<>());
    }

    public void putItemInCart(Item item) {
        this.cart.saveItem(item);
    }

    public void putSelectedItemsInCart(List<Item> itemList) {
        // TODO
    }

    public String showCart() {
        return "\n[" + this.name + "의 장바구니]\n"
                + this.cart.showCart();
    }

    public boolean isUserLevelSameOrHigher(UserLevel userLevel) {
        return this.userLevel.compare(this.userLevel, userLevel) >= 0;
    }

    public boolean isUserLevelSame(UserLevel userLevel) {
        return this.userLevel == userLevel;
    }


    public UserLevel getUserLevel() {
        return userLevel;
    }

    public String getName() {
        return name;
    }

    public Cart getCart() {
        return cart;
    }
}
