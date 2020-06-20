package com.cyb.test.mytest.designpattern.proxy07.invokedynamic;

import android.os.Build;
import android.support.annotation.RequiresApi;
import org.objectweb.asm.Opcodes;

import java.io.File;
import java.io.FileOutputStream;

/**
 * 使用asm达到执行invokedynamic指令的目的
 */
public class InvokeDynamicHello {

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void main(String[] args) throws Exception {
        byte[] codes = DynamicTestDump.dump();
        Class<?> clazz = new MyClassLoader().defineClass("DynamicTest", codes);
//        clazz.getMethod("say", null).invoke(clazz.newInstance(), new Object[]{});

        //将改变后的字节码输出
        File file = new File("/Users/cyb/android/bytedance/StudyDemo/app/src/main/java/com/cyb/test/mytest/designpattern/proxy07/invokedynamic/cyb.class");
        file.createNewFile();
        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(codes);
    }


    private static class MyClassLoader extends ClassLoader implements Opcodes {
        public Class<?> defineClass(String name, byte[] b) {
            return super.defineClass(name, b, 0, b.length);
        }
    }
}
