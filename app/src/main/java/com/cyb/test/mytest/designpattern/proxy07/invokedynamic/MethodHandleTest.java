package com.cyb.test.mytest.designpattern.proxy07.invokedynamic;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;


/**
 * https://blog.csdn.net/a_dreaming_fish/article/details/50635651
 * JSR 292 MethodHandle基础用法演示
 * 将java方法的调用动态起来，和反射相比有几个区别的地方：
 * <p>
 * 1.Reflection API的设计目标是只为Java语言服务的，而MethodHandle则设计为可服务于所有Java虚拟机之上的语言。
 * 2.Reflection是在模拟Java代码层次的方法调用，而MethodHandle是在模拟字节码层次的方法调用
 * 3.Reflection是重量级，而MethodHandle是轻量级
 * 4.由于MethodHandle是对字节码的方法指令调用的模拟，那理论上虚拟机在这方面做的各种优化（如方法内联），在MethodHandle上也应当可以采用类似思路去支持（但目前实现还不完善）。而通过反射去调用方法则不行
 *
 * @author IcyFenix
 */
public class MethodHandleTest {
    static class ClassA {
        public void println(String s) {
            System.out.println("ClassA ： " + s);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void main(String[] args) throws Throwable {
//        Object obj = System.err;
        Object obj = new ClassA();
        // 无论obj最终是哪个实现类，下面这句都能正确调用到println方法。
        getPrintlnMH(obj).invokeExact("啦啦啦啦");
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private static MethodHandle getPrintlnMH(Object reveiver) throws Throwable {
        // MethodType：代表“方法类型”，包含了方法的返回值（methodType()的第一个参数）和具体参数（methodType()第二个及以后的参数）。
        MethodType mt = MethodType.methodType(void.class, String.class);
        // lookup()方法来自于MethodHandles.lookup，这句的作用是在指定类中查找符合给定的方法名称、方法类型，并且符合调用权限的方法句柄。
        // 因为这里调用的是一个虚方法，按照Java语言的规则，方法第一个参数是隐式的，代表该方法的接收者，也即是this指向的对象，这个参数以前是放在参数列表中进行传递，现在提供了bindTo()方法来完成这件事情。
        return MethodHandles.lookup().findVirtual(reveiver.getClass(), "println", mt).bindTo(reveiver);
    }
}
