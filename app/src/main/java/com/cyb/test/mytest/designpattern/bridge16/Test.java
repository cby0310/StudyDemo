package com.cyb.test.mytest.designpattern.bridge16;

/**
 * 桥接模式，链接两地的枢纽
 * 将抽象部分和实现部分分离（抽象部分和实现部分实际上对应的是两个独立变化的维度，并不一定是抽象或者实现），使他们都可以独立地进行变化
 * https://www.runoob.com/w3cnote/bridge-pattern2.html
 */

public class Test {

    public static void main(String[] args) {
        //以咖啡为例，大杯加糖、大杯不加糖、小杯加糖、小杯不加糖，实际上是两种维度的变化，杯和糖，他们就是两个独立变化的维度
        //例子中AbstractCoffee对应于UML中间"抽象"部分，CoffeeAdditives对应于右侧"实现"部分，AbstractCoffee是client
        //访问CoffeeAdditives的桥梁

        CoffeeAdditives sugar = new Sugar();//改为Ordinary就变成了原味
        AbstractCoffee abstractCoffee = new LargeCoffee(sugar);
        abstractCoffee.makeCoffee();

        CoffeeAdditives ordinary = new Ordinary();
        AbstractCoffee abstractCoffee1 = new SmallCoffee(ordinary);
        abstractCoffee1.makeCoffee();
    }

}
