package com.ex.oop.shoppingmall.order;

import com.ex.oop.shoppingmall.cart.Cart;
import com.ex.oop.shoppingmall.currency.Money;
import com.ex.oop.shoppingmall.customer.Customer;

public class Order {
    private Customer customer;
    private Cart cart;
    private Money totalPaymentAmount;

    public Order(Customer customer, Cart cart, Money totalPaymentAmount) {
        this.customer = customer;
        this.cart = cart;
        this.totalPaymentAmount = totalPaymentAmount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer.getName() +
                "\n cart=" + cart.showCart() +
                "\n totalPaymentAmount=" + totalPaymentAmount +
                '}';
    }
}
