package com.cyb.test.mytest.designpattern.builder02;

/**
 * Created by pc on 2017/9/23.
 * <p>
 * 建造者模式：创建型,   一步一步创建一个复杂对象，对外隐藏构建细节
 * <p>
 * 将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。
 * 在这里为什么用Builder模式呢
 * 1.因为他具有良好的封装性，可以使客户端不用知道产品内部组成的细节
 * 2.建造者独立，容易扩展
 * 3.由于具体的建造者是独立的，因此可以对建造过程逐步细化，而不对其他的模块产生任何影响
 * 使用建造模式的场合：
 * 1.创建一些复杂的对象时，这些对象的内部组成构件间的建造顺序是稳定的，但是对象的内部组成构件面临着复杂的变化。
 * 2.要创建的复杂对象的算法，独立于该对象的组成部分，也独立于组成部分的装配方法时。
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
