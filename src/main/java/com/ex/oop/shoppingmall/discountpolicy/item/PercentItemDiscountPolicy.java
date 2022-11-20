package com.ex.oop.shoppingmall.discountpolicy.item;

import com.ex.oop.shoppingmall.customer.Customer;
import com.ex.oop.shoppingmall.currency.Money;
import com.ex.oop.shoppingmall.discountcondition.DiscountCondition;
import com.ex.oop.shoppingmall.item.Item;

public class PercentItemDiscountPolicy extends DefaultItemDiscountPolicy {
    private double percent;

    public PercentItemDiscountPolicy(double percent, DiscountCondition... discountConditionList) {
        super(discountConditionList);
        this.percent = percent;
    }

    @Override
    public Money getDiscountAmount(Customer customer, Item item) {
        return item.getItemPrice().times(percent);
    }
}
