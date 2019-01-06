package com.cyb.test.mytest.designpattern.proxy07.invokedynamic;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.lang.invoke.*;

/**
 *
 */
public class Bootstrap {

    private static void hello() {
        System.out.println("InvokeDynamicHello!");
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static CallSite bootstrap(MethodHandles.Lookup caller, String name, MethodType type) throws NoSuchMethodException, IllegalAccessException {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        Class thisClass = lookup.lookupClass();
        MethodHandle mh = lookup.findStatic(thisClass, "hello", MethodType.methodType(void.class));
        return new ConstantCallSite(mh.asType(type));
    }
}