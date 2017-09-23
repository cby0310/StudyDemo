package com.cyb.test.mytest.designpattern.builder;

/**
 * Created by pc on 2017/9/23.
 * <p>
 * 建造者模式：创建型
 * <p>
 * 将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。
 * 在这里为什么用Builder模式呢
 * 1.因为他具有良好的封装性，可以使客户端不用知道产品内部组成的细节
 * <p>
 * 2.建造者独立，容易扩展
 */

public class Test {
    public static void main(String[] args) {
        MyDialog myDialog = new MyDialog.Builder("title", "cancel", "ok")
                .buildBackCancelAble(true)
                .buildTouchCancelAble(true)
                .create();
        System.err.println(myDialog.toString());
    }
}
