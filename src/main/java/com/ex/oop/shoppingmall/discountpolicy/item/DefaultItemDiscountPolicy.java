package com.ex.oop.shoppingmall.discountpolicy.item;

import com.ex.oop.shoppingmall.customer.Customer;
import com.ex.oop.shoppingmall.currency.Money;
import com.ex.oop.shoppingmall.discountcondition.DiscountCondition;
import com.ex.oop.shoppingmall.item.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DefaultItemDiscountPolicy implements ItemDiscountPolicy {
    private List<DiscountCondition> discountConditionList = new ArrayList<>();

    public DefaultItemDiscountPolicy(DiscountCondition... discountConditionList) {
        this.discountConditionList = Arrays.asList(discountConditionList);
    }

    @Override
    public Money calculateDiscountAmount(Customer customer, Item item) {
        if (this.discountConditionList.size() == 0) {
            Money discountAmount = getDiscountAmount(customer, item);
            return discountAmount;
        }

        for (DiscountCondition each : this.discountConditionList) {
            if (!each.isSatisfiedBy(customer, item)) {
                return Money.ZERO;
            }
        }

        return getDiscountAmount(customer, item);
    }

    abstract protected Money getDiscountAmount(Customer customer, Item item);
}
