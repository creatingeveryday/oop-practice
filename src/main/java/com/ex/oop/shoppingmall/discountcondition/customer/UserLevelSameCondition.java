package com.ex.oop.shoppingmall.discountcondition.customer;

import com.ex.oop.shoppingmall.customer.Customer;
import com.ex.oop.shoppingmall.customer.UserLevel;

public class UserLevelSameCondition implements CustomerDiscountCondition {

    private UserLevel userLevel;

    public UserLevelSameCondition(UserLevel userLevel) {
        this.userLevel = userLevel;
    }

    @Override
    public boolean isSatisfiedBy(Customer customer) {
        return customer.isUserLevelSame(userLevel);
    }
}
