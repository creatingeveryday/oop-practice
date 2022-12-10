package com.ex.oop.shoppingmall.discountcondition.item;

import com.ex.oop.shoppingmall.item.Item;
import com.ex.oop.shoppingmall.item.ItemCategory;

public class CategorySameCondition implements ItemDiscountCondition {

    private ItemCategory itemCategory;

    public CategorySameCondition(ItemCategory itemCategory) {
        this.itemCategory = itemCategory;
    }

    @Override
    public boolean isSatisfiedBy(Item item) {
        return item.isSameCategory(itemCategory);
    }
}
