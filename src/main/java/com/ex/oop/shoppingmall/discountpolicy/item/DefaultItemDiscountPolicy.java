package com.ex.oop.shoppingmall.discountpolicy.item;

import com.ex.oop.shoppingmall.currency.Money;
import com.ex.oop.shoppingmall.customer.Customer;
import com.ex.oop.shoppingmall.discountcondition.DiscountCondition;
import com.ex.oop.shoppingmall.discountcondition.customer.CustomerDiscountCondition;
import com.ex.oop.shoppingmall.discountcondition.item.ItemDiscountCondition;
import com.ex.oop.shoppingmall.item.Item;

import java.util.Arrays;
import java.util.List;

public abstract class DefaultItemDiscountPolicy implements ItemDiscountPolicy {

    private List<DiscountCondition> discountConditionList;

    public DefaultItemDiscountPolicy(DiscountCondition... discountConditionList) {
        this.discountConditionList = Arrays.asList(discountConditionList);
    }

    @Override
    public Money calculateDiscountAmount(Customer customer, Item item) {

        for (DiscountCondition each : this.discountConditionList) {
            //item 할인 조건 체크
            if (each instanceof ItemDiscountCondition) {
                ItemDiscountCondition itemDiscountCondition = (ItemDiscountCondition) each;
                if (!itemDiscountCondition.isSatisfiedBy(item)) {
                    return Money.ZERO;
                }
            }
        }

        for (DiscountCondition each : this.discountConditionList) {
            // user 할인 조건 체크
            if (each instanceof CustomerDiscountCondition) {
                CustomerDiscountCondition customerDiscountCondition = (CustomerDiscountCondition) each;
                if (!customerDiscountCondition.isSatisfiedBy(customer)) {
                    return Money.ZERO;
                }
            }
        }

        return getDiscountAmount(customer, item); // 할인 조건을 모두 만족하는 경우
    }

    abstract protected Money getDiscountAmount(Customer customer, Item item);
}
