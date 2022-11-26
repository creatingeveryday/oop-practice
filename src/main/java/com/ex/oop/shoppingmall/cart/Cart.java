package com.ex.oop.shoppingmall.cart;

import com.ex.oop.shoppingmall.Order;
import com.ex.oop.shoppingmall.currency.Money;
import com.ex.oop.shoppingmall.customer.Customer;
import com.ex.oop.shoppingmall.item.Item;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Cart {
    private Customer customer;
    private Set<CartItem> itemList; // linkedHashSet 중복방지, 순서 유지

    public Cart(Customer customer) {
        this.customer = customer;
        this.itemList = new LinkedHashSet<>();
    }

    public Cart(Customer customer, List<CartItem> cartItemList) {
        this.customer = customer;
        this.itemList = new LinkedHashSet<>(cartItemList);
    }

    public void saveItem(Item item, int quantity) {
        CartItem cartItem = new CartItem(item, quantity);
        this.itemList.add(cartItem);
    }

    public Order buy() {
        return new Order(customer, this, calculateTotalPaymentAmount());
    }

    public String showCart() {
        String cart = "";
        for (CartItem cartItem : this.itemList) {
            cart += cartItem.toString() + "\n";
        }

        cart += "총 금액   : " + this.calculateTotalCartItemAmount();
        cart += "\n총 결제금액: " + this.calculateTotalPaymentAmount();
        return cart;
    }

    public Money calculateTotalCartItemAmount() {
        Money total = Money.ZERO;

        for (CartItem cartItem : this.itemList) {
            total = total.plus(cartItem.getCartItemPrice());
        }

        return total;
    }

    private Money calculateTotalPaymentAmount() {
        Money total = Money.ZERO;

        for (CartItem cartItem : this.itemList) {
            Money paymentAmount = cartItem.calculateCartItemPrice(this.customer);
            total = total.plus(paymentAmount);
        }

        return total;
    }

    public Customer getCustomer() {
        return customer;
    }
}
