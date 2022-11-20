package com.ex.oop.shoppingmall.discountcondition;

import com.ex.oop.shoppingmall.customer.Customer;
import com.ex.oop.shoppingmall.customer.UserLevel;
import com.ex.oop.shoppingmall.item.Item;

public class UserLevelAboveCondition implements DiscountCondition {

    private UserLevel userLevel;

    public UserLevelAboveCondition(UserLevel userLevel) {
        this.userLevel = userLevel;
    }

    @Override
    public boolean isSatisfiedBy(Customer customer, Item item) {
        return customer.isUserLevelSameOrHigher(userLevel);
    }
}
