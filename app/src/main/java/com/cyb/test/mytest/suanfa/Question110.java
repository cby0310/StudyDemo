package com.cyb.test.mytest.suanfa;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Question110 {


    /**
     * 获取礼物的最大价值
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] arrays = new int[][]{
                {1, 3, 10, 3, 3, 3},
                {1, 5, 1, 5, 1, 5},
                {4, 2, 1, 5, 1, 3},
                {1, 5, 1, 5, 1, 5},
                {1, 5, 1, 5, 1, 5},
                {1, 5, 1, 5, 1, 5},
                {1, 5, 1, 5, 1, 5},
                {1, 5, 1, 5, 1, 5},
                {1, 5, 1, 5, 1, 5},
                {1, 5, 1, 5, 1, 5},
        };
        Question110 question110 = new Question110();
//        System.err.println(question110.getMaxValue(arrays));
        System.err.println();
        question110.getAllPath(arrays);
    }

    /**
     * https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/solution/mian-shi-ti-47-li-wu-de-zui-da-jie-zhi-dong-tai-gu/
     *
     * @param arrays
     * @return
     */
    private int getMaxValue(int[][] arrays) {
        int row = arrays.length;
        int column = arrays[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i > 0 && j > 0) {
                    arrays[i][j] += Math.max(arrays[i - 1][j], arrays[i][j - 1]);
                } else if (i == 0 && j > 0) {
                    arrays[i][j] += arrays[i][j - 1];
                } else if (i > 0 && j == 0) {
                    arrays[i][j] += arrays[i - 1][j];
                }
            }
        }

        return arrays[row - 1][column - 1];
    }


    /**
     * 打印出所有到右下角的路径
     *
     * @param arrays
     */
    private void getAllPath(int[][] arrays) {
        ArrayList a = new ArrayList();
        a.add(arrays[0][0]);
        dfs2(arrays, 0, 0, a);
    }

    private void dfs(int[][] arrays, int i, int j, ArrayList path) {
        if (i == arrays.length - 1 && j == arrays[0].length - 1) {
            System.err.println("0 ：" + path);
            return;
        }

        if (i + 1 < arrays.length && j + 1 < arrays[0].length) {//可向右或者向下
            path.add(arrays[i][j + 1]);
            dfs(arrays, i, j + 1, path); //向右
            path.remove(path.size() - 1);

            path.add(arrays[i + 1][j]);
            dfs(arrays, i + 1, j, path); //向下
            path.remove(path.size() - 1);
        } else if (j + 1 < arrays[0].length) { //只能向右
            path.add(arrays[i][j + 1]);
            dfs(arrays, i, j + 1, path); //向右
            path.remove(path.size() - 1);
        } else if (i + 1 < arrays.length) { //只能向下
            path.add(arrays[i + 1][j]);
            dfs(arrays, i + 1, j, path); //向下
            path.remove(path.size() - 1);
        }
    }

    private void dfs2(int[][] arrays, int i, int j, ArrayList<Integer> path) {
        if (i == arrays.length - 1 && j == arrays[0].length - 1) {
            int sum = 0;
            for (int a : path) {
                sum += a;
            }
            System.err.println("path ：" + path + " , value : " + sum);
            return;
        }

        if (j + 1 < arrays[0].length) { //检查是否向右
            path.add(arrays[i][j + 1]);
            dfs2(arrays, i, j + 1, path); //向右
            path.remove(path.size() - 1);
        }

        if (i + 1 < arrays.length) { //检查是否向下
            path.add(arrays[i + 1][j]);
            dfs2(arrays, i + 1, j, path); //向下
            path.remove(path.size() - 1);
        }

    }
}
