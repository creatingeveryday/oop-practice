package com.ex.oop.shoppingmall.item;

import com.ex.oop.shoppingmall.customer.Customer;
import com.ex.oop.shoppingmall.discountpolicy.item.ItemDiscountPolicy;
import com.ex.oop.shoppingmall.currency.Money;

public class Item {
    private long itemId;
    private ItemCategory category;
    private String itemName;
    private Money price; // 정가
    private ItemDiscountPolicy itemDiscountPolicy;

    private int stock;

    public Item(long itemId, ItemCategory category, String itemName, Money price, ItemDiscountPolicy itemDiscountPolicy) {
        this.itemId = itemId;
        this.category = category;
        this.itemName = itemName;
        this.price = price;
        this.itemDiscountPolicy = itemDiscountPolicy;
    }

    public Item(ItemCategory category, String itemName, Money price, ItemDiscountPolicy itemDiscountPolicy) {
        this.category = category;
        this.itemName = itemName;
        this.price = price;
        this.itemDiscountPolicy = itemDiscountPolicy;
    }

    public Money getItemPrice() {
        return this.price;
    }

    public Money calculateItemPrice(Customer customer) {
        Money discountedItemPrice = this.price.minus(itemDiscountPolicy.calculateDiscountAmount(customer, this));
        return discountedItemPrice;
    }

    public boolean isSameCategory(ItemCategory itemCategory){
        return this.category == itemCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        return getItemId() == item.getItemId();
    }

    @Override
    public int hashCode() {
        return (int) (getItemId() ^ (getItemId() >>> 32));
    }

    public long getItemId() {
        return itemId;
    }

    @Override
    public String toString() {
        return "Item{" +
                "category=" + category +
                ", itemName='" + itemName + '\'' +
                ", price=" + price +
                '}';
    }
}
