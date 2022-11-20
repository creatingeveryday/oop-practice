package com.ex.oop.shoppingmall.discountpolicy.item;

import com.ex.oop.shoppingmall.customer.Customer;
import com.ex.oop.shoppingmall.currency.Money;
import com.ex.oop.shoppingmall.discountcondition.DiscountCondition;
import com.ex.oop.shoppingmall.item.Item;

public class AmountItemDiscountPolicy extends DefaultItemDiscountPolicy {

    private Money discountAmount;

    public AmountItemDiscountPolicy(Money discountAmount, DiscountCondition... discountConditionList) {
        super(discountConditionList);
        this.discountAmount = discountAmount;
    }

    @Override
    public Money getDiscountAmount(Customer customer, Item item) {
        return discountAmount;
    }
}
