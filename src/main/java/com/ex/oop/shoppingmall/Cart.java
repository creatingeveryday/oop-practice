package com.ex.oop.shoppingmall;

import com.ex.oop.shoppingmall.currency.Money;
import com.ex.oop.shoppingmall.customer.Customer;
import com.ex.oop.shoppingmall.item.Item;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Cart {
    private Customer customer;
//    private List<Item> itemList;
    private Set<Item> itemList; // linkedHashSet 중복방지, 순서 유지

    public Cart(Customer customer, List<Item> itemList) {
        this.customer = customer;
//        this.itemList = itemList;
        this.itemList = new LinkedHashSet<>(itemList);
    }

    public void saveItem(Item item) {
        this.itemList.add(item);
    }

    public Order buy() {
        return new Order(customer, this, calculateTotalPaymentAmount());
    }

    public String showCart() {
        String cart = "";
        for (Item item : this.itemList) {
            cart += item.toString()+"\n";
        }

        cart += "총 금액   : " + this.calculateTotalCartItemAmount();
        cart += "\n총 결제금액: " + this.calculateTotalPaymentAmount();
        return cart;
    }

    public Money calculateTotalCartItemAmount() {
        Money total = Money.ZERO;

        for (Item item : this.itemList) {
            total = total.plus(item.getItemPrice());
        }

        return total;
    }

    private Money calculateTotalPaymentAmount() {
        Money total = Money.ZERO;

        for (Item item : this.itemList) {
            Money discounted = item.calculateItemPrice(this.customer);
            total = total.plus(discounted);
        }

        return total;

    }

    public Customer getCustomer() {
        return customer;
    }
}
