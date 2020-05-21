package com.cyb.test.mytest.designpattern.decorator13;

import android.app.Activity;

/*
 * Context的实现就是一个典型的装饰器模式：
 * 1.Context是抽象组件
 * 2.ContextImpl是Context的真正实现者，是具体组件，是要被增强的对象
 * 3.ContextWrapper实现了Context，并且内部引用着一个Context对象mBase，有点像是代理（实际为ContextImpl，在ActivityThread中通过Activity的
 * attach方法赋值），不过是装饰器，Application和Service继承于它
 * 4.ContextThemeWrapper是更具体的装饰器，进行了增强，Activity继承于它
 *
 * ContextImpl实例数量 = Activity + Service + Application
 * Context实例数量 = 2*ContextImpl数量 ??? 本身一个 + 引用一个，so double啊
 */
public class AndroidCase extends Activity {
}
