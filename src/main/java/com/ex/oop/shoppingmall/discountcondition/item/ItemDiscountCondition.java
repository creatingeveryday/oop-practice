package com.ex.oop.shoppingmall.discountcondition.item;

import com.ex.oop.shoppingmall.discountcondition.DiscountCondition;
import com.ex.oop.shoppingmall.item.Item;

public interface ItemDiscountCondition extends DiscountCondition {

    boolean isSatisfiedBy(Item item);
}
