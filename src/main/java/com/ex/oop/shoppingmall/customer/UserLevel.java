package com.ex.oop.shoppingmall.customer;

import java.util.Comparator;

public enum UserLevel implements Comparator<UserLevel> {

    GOLD(1), VIP(2), VVIP(3);

    private final int value;

    private UserLevel(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }


    @Override
    public int compare(UserLevel o1, UserLevel o2) {

        int u1Value = o1.getValue();
        int u2Value = o2.getValue();

        return Integer.compare(u1Value, u2Value);

    }
}
