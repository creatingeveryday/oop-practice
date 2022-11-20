package com.ex.oop.shoppingmall.discountcondition;

import com.ex.oop.shoppingmall.customer.Customer;
import com.ex.oop.shoppingmall.item.Item;
import com.ex.oop.shoppingmall.item.ItemCategory;

public class CategorySameCondition implements DiscountCondition {

    private ItemCategory itemCategory;

    public CategorySameCondition(ItemCategory itemCategory) {
        this.itemCategory = itemCategory;
    }

    @Override
    public boolean isSatisfiedBy(Customer customer, Item item) {
        return item.isSameCategory(itemCategory);
    }
}
