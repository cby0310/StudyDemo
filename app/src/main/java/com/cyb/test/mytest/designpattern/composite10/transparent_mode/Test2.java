package com.cyb.test.mytest.designpattern.composite10.transparent_mode;

/**
 * 透明的组合模式，将抽象进行到底
 */
public class Test2 {
    public static void main(String[] args) {
        //叶子构件
        Component2 beidianCaiwu = new Leaf2("beidianCaiwu");
        Component2 beidianGongguan = new Leaf2("beidianGongguan");
        //枝干
        Component2 beidian = new Composite2("beidian");

        beidian.addChild(beidianCaiwu);
        beidian.addChild(beidianGongguan);
        //枝干
        Component2 beibeiGroup = new Composite2("beibeiGroup");
        //叶子
        Component2 beibeiCaiwu = new Leaf2("beibeiCaiwu");

        beibeiGroup.addChild(beibeiCaiwu);
        beibeiGroup.addChild(beidian);

        beibeiGroup.doSomething();
    }
}
