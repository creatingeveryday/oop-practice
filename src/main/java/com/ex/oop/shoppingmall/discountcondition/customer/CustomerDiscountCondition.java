package com.ex.oop.shoppingmall.discountcondition.customer;

import com.ex.oop.shoppingmall.customer.Customer;
import com.ex.oop.shoppingmall.discountcondition.DiscountCondition;

public interface CustomerDiscountCondition extends DiscountCondition {

    public boolean isSatisfiedBy(Customer customer);
}
