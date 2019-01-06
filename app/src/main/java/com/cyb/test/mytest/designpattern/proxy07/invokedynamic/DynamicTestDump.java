package com.cyb.test.mytest.designpattern.proxy07.invokedynamic;

import android.os.Build;
import android.support.annotation.RequiresApi;
import org.objectweb.asm.*;

import java.lang.invoke.CallSite;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class DynamicTestDump implements Opcodes {

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static byte[] dump() throws Exception {

        ClassWriter cw = new ClassWriter(0);
        FieldVisitor fv;
        MethodVisitor mv;
        AnnotationVisitor av0;

        cw.visit(52, ACC_PUBLIC + ACC_SUPER, "invokedynamic/DynamicTest", null, "java/lang/Object", null);

        {
            mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
            mv.visitInsn(RETURN);
            mv.visitMaxs(1, 1);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "say", "()V", null, null);
            mv.visitCode();

//            mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
//            mv.visitLdcInsn("Hi2222");
//            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
//            mv.visitInsn(RETURN);
//            mv.visitMaxs(2, 1);

            MethodType mt = MethodType.methodType(CallSite.class, MethodHandles.Lookup.class, String.class,
                    MethodType.class);
            Handle bootstrap = new Handle(Opcodes.H_INVOKESTATIC, "com/cyb/test/mytest/designpattern/proxy07/invokedynamic/Bootstrap", "bootstrap",
                    mt.toMethodDescriptorString());
            mv.visitInvokeDynamicInsn("dynamicInvoke", "()V", bootstrap);
            mv.visitInsn(RETURN);
            mv.visitMaxs(0, 1);


            mv.visitEnd();
        }
        cw.visitEnd();

        return cw.toByteArray();
    }

}