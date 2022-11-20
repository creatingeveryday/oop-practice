package com.ex.oop.shoppingmall;

import com.ex.oop.shoppingmall.coupon.Coupon;
import com.ex.oop.shoppingmall.item.Item;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;

public class Event {
    private String subject;
    private List<Coupon> couponList;
    private List<Item> itemList;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private DayOfWeek dayOfWeek;

    public Event(String subject,
                 List<Coupon> couponList,
                 List<Item> itemList,
                 LocalDateTime startTime, LocalDateTime endTime, DayOfWeek dayOfWeek) {

        this.subject = subject;
        this.couponList = couponList;
        this.itemList = itemList;
        this.startTime = startTime;
        this.endTime = endTime;
        this.dayOfWeek = dayOfWeek;
    }
}
