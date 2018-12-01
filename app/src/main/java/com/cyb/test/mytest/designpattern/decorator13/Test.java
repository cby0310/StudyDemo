package com.cyb.test.mytest.designpattern.decorator13;

/***
 * 装饰器模式，又称为包装模式。可以动态地扩展功能
 * 这个模式和代理模式很像，很容易把装饰当成代理，装饰器模式是以客户端透明的方式
 * 扩展对象的功能，是继承关系的一种替代方案；而代理模式是给一个对象一个代理，由代理对象控制原有对象的引用。
 * 最主要的一个区别就是增强功能，装饰器有增强。
 *
 * 装饰器模式，又名包装模式 Context、ContextImpl、ContextWrapper、ContextThemeWrapper、
 * Activity、Application、Service
 */
public class Test {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        component.operate();
        System.out.println();

        Decorator decoratorA = new ConcreteDecoratorA(component);
        decoratorA.operate();
        System.out.println();

        Decorator decoratorB = new ConcreteDecoratorB(component);
        decoratorB.operate();
        System.out.println();
    }
}
