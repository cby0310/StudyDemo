package com.cyb.test.mytest.designpattern.flyweight14;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂
 */
public class TicketFactory {

    public static Map<String, Ticket> map = new HashMap();

    public static Ticket getTicket(String from, String to) {
        String key = from + "-" + to;
        if (map.containsKey(key)) {
            System.out.println("使用缓存");
            return map.get(key);
        } else {
            System.out.println("新建对象");
            Ticket ticket = new TrainTicket(from, to);
            map.put(key, ticket);
            return ticket;
        }
    }
}
