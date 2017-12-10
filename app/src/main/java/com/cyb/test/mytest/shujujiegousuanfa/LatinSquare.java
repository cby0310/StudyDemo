package com.cyb.test.mytest.shujujiegousuanfa;

/**
 * Created by pc on 2017/12/10.
 */

public class LatinSquare {
    public static void main(String[] args) {
        latinSquare(15);
    }

    /**
     * 拉丁矩阵：使方阵中的每一行和每一列中数字1到N只出现一次
     * <p>
     * 1 2 3 4 5
     * 2 3 4 5 1
     * 3 4 5 1 2
     * 4 5 1 2 3
     * 5 1 2 3 4
     * <p>
     * 2 3 4 5 1
     * 3 4 5 1 2
     * 4 5 1 2 3
     * 5 1 2 3 4
     * 1 2 3 4 5
     * <p>
     * 3 4 5 1 2
     * 4 5 1 2 3
     * 5 1 2 3 4
     * 1 2 3 4 5
     * 2 3 4 5 1
     * <p>
     * 4 5 1 2 3
     * 5 1 2 3 4
     * 1 2 3 4 5
     * 2 3 4 5 1
     * 3 4 5 1 2
     * <p>
     * 5 1 2 3 4
     * 1 2 3 4 5
     * 2 3 4 5 1
     * 3 4 5 1 2
     * 4 5 1 2 3
     * <p>
     * 求余实现，也可以通过循环链表实现
     *
     * @param n
     */
    public static void latinSquare(int n) {
        int i, j, k, t;
        for (j = 0; j < n; j++)//输出n个方阵
        {
            for (i = 0; i < n; i++)//输出每个方阵
            {
                t = (i + j) % n;//确定第i个方阵的第一个元素
                for (k = 0; k < n; k++)//环形输出每一行
                    System.err.print((k + t) % n + 1 + " ");
                System.err.println();
            }
            System.err.println();
        }
    }
}
