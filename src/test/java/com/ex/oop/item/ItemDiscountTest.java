package com.ex.oop.item;

import com.ex.oop.shoppingmall.currency.Money;
import com.ex.oop.shoppingmall.customer.Customer;
import com.ex.oop.shoppingmall.customer.UserLevel;
import com.ex.oop.shoppingmall.discountcondition.customer.UserLevelAboveCondition;
import com.ex.oop.shoppingmall.discountcondition.customer.UserLevelSameCondition;
import com.ex.oop.shoppingmall.discountcondition.item.CategorySameCondition;
import com.ex.oop.shoppingmall.discountpolicy.item.AmountItemDiscountPolicy;
import com.ex.oop.shoppingmall.discountpolicy.item.PercentItemDiscountPolicy;
import com.ex.oop.shoppingmall.item.Item;
import com.ex.oop.shoppingmall.item.ItemCategory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemDiscountTest {

    private final Customer goldMember = new Customer("john", UserLevel.GOLD);
    private final Customer vipMember = new Customer("jack", UserLevel.VIP);
    private final Customer vvipMember = new Customer("tom", UserLevel.VVIP);

    @Test
    @DisplayName("카테고리 특정금액 할인 테스트")
    public void categoryAmountDiscountTest() {

        AmountItemDiscountPolicy book1000won = new AmountItemDiscountPolicy(Money.wons(1000),
                new CategorySameCondition(ItemCategory.BOOK));

        Item book = new Item(1, ItemCategory.BOOK, "책", Money.wons(10000), book1000won);

        assertEquals(book.getItemPrice(), Money.wons(10000));
        assertEquals(book.calculateItemPrice(goldMember), Money.wons(9000));
        assertEquals(book.calculateItemPrice(vipMember), Money.wons(9000));
        assertEquals(book.calculateItemPrice(vvipMember), Money.wons(9000));
    }

    @Test
    @DisplayName("카테고리 퍼센트 할인 테스트")
    public void categoryPercentDiscountTest() {

        PercentItemDiscountPolicy book5percent = new PercentItemDiscountPolicy(0.05,
                new CategorySameCondition(ItemCategory.BOOK));

        Item book = new Item(1, ItemCategory.BOOK, "오브젝트", Money.wons(10000), book5percent);

        assertEquals(book.getItemPrice(), Money.wons(10000));
        assertEquals(book.calculateItemPrice(goldMember), Money.wons(9500));
        assertEquals(book.calculateItemPrice(vipMember), Money.wons(9500));
        assertEquals(book.calculateItemPrice(vvipMember), Money.wons(9500));
    }

    @Test
    @DisplayName("회원 등급 특정금액 할인 테스트")
    public void levelAmountDiscountTest() {

        AmountItemDiscountPolicy aboveVip1000won = new AmountItemDiscountPolicy(Money.wons(1000),
                new UserLevelAboveCondition(UserLevel.VIP));

        Item book = new Item(1, ItemCategory.BOOK, "오브젝트", Money.wons(10000), aboveVip1000won);

        assertEquals(book.getItemPrice(), Money.wons(10000));
        assertEquals(book.calculateItemPrice(goldMember), Money.wons(10000));
        assertEquals(book.calculateItemPrice(vipMember), Money.wons(9000));
        assertEquals(book.calculateItemPrice(vvipMember), Money.wons(9000));

    }

    @Test
    @DisplayName("회원 등급 퍼센트 할인 테스트")
    public void levelPercentDiscountTest() {

        PercentItemDiscountPolicy aboveVip1000won = new PercentItemDiscountPolicy(0.1,
                new UserLevelAboveCondition(UserLevel.VIP));

        Item book = new Item(1, ItemCategory.BOOK, "오브젝트", Money.wons(10000), aboveVip1000won);

        assertEquals(1, book.getItemId());
        assertEquals(book.getItemPrice(), Money.wons(10000));
        assertEquals(book.calculateItemPrice(goldMember), Money.wons(10000));
        assertEquals(book.calculateItemPrice(vipMember), Money.wons(9000));
        assertEquals(book.calculateItemPrice(vvipMember), Money.wons(9000));

    }

    @Test
    @DisplayName("할인조건 여러개 동시 만족 테스트")
    public void multipleDiscountTest() {

        AmountItemDiscountPolicy book1000wonAboveVIP = new AmountItemDiscountPolicy(Money.wons(1000),
                new UserLevelAboveCondition(UserLevel.VIP),
                new CategorySameCondition(ItemCategory.BOOK));

        Item book = new Item(1, ItemCategory.BOOK, "오브젝트", Money.wons(10000), book1000wonAboveVIP);

        assertEquals(book.getItemPrice(), Money.wons(10000));
        assertEquals(book.calculateItemPrice(goldMember), Money.wons(10000));
        assertEquals(book.calculateItemPrice(vipMember), Money.wons(9000));
        assertEquals(book.calculateItemPrice(vvipMember), Money.wons(9000));


        PercentItemDiscountPolicy food10percentSameVVIP = new PercentItemDiscountPolicy(0.1,
                new UserLevelSameCondition(UserLevel.VVIP),
                new CategorySameCondition(ItemCategory.FOOD));

        Item food = new Item(2, ItemCategory.FOOD, "사과", Money.wons(50000), food10percentSameVVIP);

        assertEquals(food.getItemPrice(), Money.wons(50000));
        assertEquals(food.calculateItemPrice(goldMember), Money.wons(50000));
        assertEquals(food.calculateItemPrice(vipMember), Money.wons(50000));
        assertEquals(food.calculateItemPrice(vvipMember), Money.wons(45000));

    }
}
