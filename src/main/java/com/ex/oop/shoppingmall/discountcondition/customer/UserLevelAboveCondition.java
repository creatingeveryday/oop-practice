package com.ex.oop.shoppingmall.discountcondition.customer;

import com.ex.oop.shoppingmall.customer.Customer;
import com.ex.oop.shoppingmall.customer.UserLevel;

public class UserLevelAboveCondition implements CustomerDiscountCondition {

    private UserLevel userLevel;

    public UserLevelAboveCondition(UserLevel userLevel) {
        this.userLevel = userLevel;
    }

    @Override
    public boolean isSatisfiedBy(Customer customer) {
        return customer.isUserLevelSameOrHigher(userLevel);
    }
}
