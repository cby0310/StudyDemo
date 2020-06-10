package com.cyb.test.mytest.designpattern.proxy07.invokedynamic;

import android.os.Build;
import android.support.annotation.RequiresApi;
import org.objectweb.asm.util.ASMifier;


/**
 * 使用asm将class文件生成以java管理的形式
 *
 * @author IcyFenix
 */
public class ASMClassCodeTest {

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void main(String[] args0) throws Throwable {
        try {
            String[] args = new String[1];
            args[0] = "/Users/cyb/android/bytedance/StudyDemo/app/src/main/java/com/cyb/test/mytest/designpattern/proxy07/invokedynamic/DynamicTest.class";
            ASMifier.main(args);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
