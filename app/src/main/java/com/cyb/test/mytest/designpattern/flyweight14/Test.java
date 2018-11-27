package com.cyb.test.mytest.designpattern.flyweight14;

/**
 * Flyweight,轻量级的意思。享元模式用来尽可能减少内存量的使用，适用于可能存在大量重复对象的场景，来缓存可共享的对象，
 * 达到对象共享，避免创建过多对象从而频繁gc的问题。
 * 角色：
 * 1.抽象基类或者接口
 * 2.具体享元对象
 * 3.享元工厂
 */
public class Test {

    /**
     * 享元模式中部分对象可共享称为内部状态，部分不可共享称为外部状态。
     * 分别对象例子中的from和to、price和bunk
     *
     * @param args
     */
    public static void main(String[] args) {
        Ticket ticket = TicketFactory.getTicket("杭州", "濮阳");
        ticket.showTicketInfo("上铺");

        Ticket ticket1 = TicketFactory.getTicket("杭州", "濮阳");
        ticket1.showTicketInfo("中铺");

        Ticket ticket2 = TicketFactory.getTicket("杭州", "濮阳0");
        ticket2.showTicketInfo("下铺");

        Ticket ticket3 = TicketFactory.getTicket("杭州", "濮阳");
        ticket3.showTicketInfo("下铺");
    }
}
