package com.cyb.test.mytest.designpattern.flyweight14;

import java.util.Random;

/**
 * 具体享元对象
 */
public class TrainTicket implements Ticket {
    public String from;//始发站
    public String to;//目的地
    public String bunk;//铺位
    public int price;//价钱


    public TrainTicket(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void showTicketInfo(String bunk) {
        this.bunk = bunk;
        price = new Random().nextInt(300) + 100;
        System.out.println("TrainTicket{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", bunk='" + bunk + '\'' +
                ", price=" + price +
                '}');
    }

}
