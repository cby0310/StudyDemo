package com.cyb.test.mytest.designpattern.composite10;

/**
 * 组合模式，也称为部分-整体模式，用户对单个对象或者组合对象的使用具有一致性。比如公司的结构，贝贝集团包含公关部，财务部，同时又包含贝店，贝店又包含
 * 子公关部，子财务部部等。其中每个部分都是一个枝干部件，贝贝集团和贝店是根结构件，部门是叶子构件。
 * 身边的例子，文件夹和文件的例子，都可以抽象为Dir，包含新建、删除、清空文件等操作方法。
 * 安卓中，View、ViewGroup、LinearLayout就是典型的组合模式，安全的组合方式，vg并没有onLayout，onDraw方法
 */
public class Test {
    public static void main(String[] args) {
        Leaf beidianCaiwu = new Leaf("beidianCaiwu");
        Leaf beidianGongguan = new Leaf("beidianGongguan");
        //这里直接使用了Component的具体实现类Composite，违背了依赖导致的原则，我们应该面向接口编程。这种组合的方式称为安全的组合模式，
        //更好的使用透明的组合模式，见transparent_mode
        Composite beidian = new Composite("beidian");
        beidian.addChild(beidianCaiwu);
        beidian.addChild(beidianGongguan);

        Composite beibeiGroup = new Composite("beibeiGroup");

        Leaf beibeiCaiwu = new Leaf("beibeiCaiwu");

        beibeiGroup.addChild(beibeiCaiwu);
        beibeiGroup.addChild(beidian);

        beibeiGroup.doSomething();
    }
}
