package com.ex.oop.shoppingmall.cart;

import com.ex.oop.shoppingmall.currency.Money;
import com.ex.oop.shoppingmall.customer.Customer;
import com.ex.oop.shoppingmall.item.Item;

public class CartItem {

    private Item item;
    private int quantity;

    public CartItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    //상품의 총 가격 계산

    public Money getCartItemPrice() {
        return this.item.getItemPrice().times(quantity);
    }

    public Money calculateCartItemPrice(Customer customer) {
        return this.item.calculateItemPrice(customer).times(quantity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartItem cartItem = (CartItem) o;

        return item.equals(cartItem.item);
    }

    @Override
    public int hashCode() {
        return item.hashCode();
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "item=" + item +
                ", quantity=" + quantity +
                '}';
    }


}
