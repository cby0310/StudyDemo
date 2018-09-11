package com.cyb.test.mytest.jvm;

import java.io.File;

/**
 * Created by pc on 2018/8/25.
 */

public class FileSizePrint {
    public static void main(String[] args) {

//        C:\Program Files---->>>>3.84932
//        C:\Program Files (x86)---->>>>2.1438718
//        C:\Users---->>>>36.524944
//        C:\Windows---->>>>31.918976

        FileSizePrint fileSizePrint = new FileSizePrint();
//        fileSizePrint.analyse("C:\\Program Files");
//        fileSizePrint.analyse("C:\\Program Files (x86)");
//        fileSizePrint.analyse("C:\\Users");
        fileSizePrint.analyse("D:\\");
    }

    private void analyse(final String path) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                System.err.println("begin begin ----> " + path);//2147483647
                File file = new File(path);

                for (File file1 : file.listFiles()) {
                    if (file1.isHidden() || !file1.isDirectory()) continue;
                    float sizeInG = getTotalSizeOfFilesInDir(file1) / ONE_G;
                    if (sizeInG >= 1)
                        System.err.println(file1.getAbsolutePath() + "---->>>>" + sizeInG);
                }
                System.err.println("end  end ----> " + path);
            }
        }.start();

    }


    private static final float ONE_G = 1024 * 1024 * 1024;


    // 递归方式 计算文件的大小
    private long getTotalSizeOfFilesInDir(final File file) {
        if (file.isFile())
            return file.length();
        final File[] children = file.listFiles();
        long total = 0;
        if (children != null)
            for (final File child : children)
                total += getTotalSizeOfFilesInDir(child);
        return total;
    }

    private void print(File file) {
        if (file == null) return;

        if (file.isDirectory()) {
            float sizeInG = file.length() / ONE_G;
            if (sizeInG > 2)
                System.err.println(file.getAbsolutePath() + "---->>>>" + sizeInG);
            if (file.listFiles() == null) return;
            for (File file1 : file.listFiles())
                print(file1);
        } else {
//            System.err.println(file.getName() + ":" + file.length());
        }
    }
}
