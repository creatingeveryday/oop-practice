package com.ex.oop.shoppingmall.discountpolicy.item;

import com.ex.oop.shoppingmall.customer.Customer;
import com.ex.oop.shoppingmall.currency.Money;
import com.ex.oop.shoppingmall.item.Item;

public interface ItemDiscountPolicy {
    Money calculateDiscountAmount(Customer customer, Item item);

}
