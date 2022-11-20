package com.ex.oop.shoppingmall.discountcondition;

import com.ex.oop.shoppingmall.customer.Customer;
import com.ex.oop.shoppingmall.item.Item;

public interface DiscountCondition {
    boolean isSatisfiedBy(Customer customer, Item item);
}
