package com.ex.oop.shoppingmall;

import com.ex.oop.shoppingmall.currency.Money;
import com.ex.oop.shoppingmall.customer.Customer;
import com.ex.oop.shoppingmall.customer.UserLevel;
import com.ex.oop.shoppingmall.discountcondition.CategorySameCondition;
import com.ex.oop.shoppingmall.discountcondition.UserLevelAboveCondition;
import com.ex.oop.shoppingmall.discountcondition.UserLevelSameCondition;
import com.ex.oop.shoppingmall.discountpolicy.item.AmountItemDiscountPolicy;
import com.ex.oop.shoppingmall.discountpolicy.item.PercentItemDiscountPolicy;
import com.ex.oop.shoppingmall.item.Item;
import com.ex.oop.shoppingmall.item.ItemCategory;

public class HelloShop {


    public static void main(String[] args) {

        Customer john = new Customer("john", UserLevel.GOLD);
        Customer jack = new Customer("jack", UserLevel.VIP);
        Customer tom = new Customer("tom", UserLevel.VVIP);

        ItemCategory book = ItemCategory.BOOK;
        ItemCategory food = ItemCategory.FOOD;

        AmountItemDiscountPolicy book1000wonAboveVIP = new AmountItemDiscountPolicy(Money.wons(1000),
                new UserLevelAboveCondition(UserLevel.VIP),
                new CategorySameCondition(ItemCategory.BOOK));


        PercentItemDiscountPolicy food7percentAboveVIP = new PercentItemDiscountPolicy(0.07,
                new UserLevelAboveCondition(UserLevel.VIP),
                new CategorySameCondition(ItemCategory.FOOD));

        PercentItemDiscountPolicy food15percentForVVIP = new PercentItemDiscountPolicy(0.15,
                new UserLevelSameCondition(UserLevel.VVIP),
                new CategorySameCondition(ItemCategory.FOOD));


        Item objectBook = new Item(1, book, "오브젝트", Money.wons(13000), book1000wonAboveVIP);

        Item cleanCodeBook = new Item(2, book, "클린코드", Money.wons(20000), book1000wonAboveVIP);

        Item bread = new Item(3, food, "빵", Money.wons(7000), food7percentAboveVIP);

        Item apple = new Item(4, food, "사과", Money.wons(9000), food15percentForVVIP);


        // 아이템을 장바구니에 담고 표시.
        john.putItemInCart(cleanCodeBook, 2);
        john.putItemInCart(bread, 1);
        john.putItemInCart(apple, 10);
        System.out.println(john.showCart());

        jack.putItemInCart(cleanCodeBook, 2);
        jack.putItemInCart(bread, 1);
        jack.putItemInCart(apple, 10);
        System.out.println(jack.showCart());

        tom.putItemInCart(cleanCodeBook, 2);
        tom.putItemInCart(bread, 1);
        tom.putItemInCart(apple, 10);
        System.out.println(tom.showCart());


        System.out.println(tom.getCart().buy());


        // TODO 추후 포인트 기능
        // TODO 추후 쿠폰 기능
        // TODO 추후 DB 연결


//        System.out.println(UserLevel.VIP.compareTo(UserLevel.VIP));  // 0
//        System.out.println(UserLevel.GOLD.compareTo(UserLevel.VIP)); // -1
//        System.out.println(UserLevel.VVIP.compareTo(UserLevel.VIP)); // 1
//
//
//        System.out.println(UserLevel.VVIP.compare(UserLevel.GOLD, UserLevel.VIP)); // -1
//        System.out.println(UserLevel.VVIP.compare(UserLevel.VIP, UserLevel.VIP)); // 0
//        System.out.println(UserLevel.VVIP.compare(UserLevel.VVIP, UserLevel.VIP)); // 1

    }
}
