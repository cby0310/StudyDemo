package com.cyb.test.mytest.suanfa;

public class Question100 {


    /**
     * @param array
     * @param target
     * @return
     */
    private static boolean get(int[][] array, int target) {

        int rowLength = array.length;
        int colLength = array[0].length;

        int count = 0;

        if (array[0][0] > target || array[rowLength - 1][colLength - 1] < target) {
            System.err.println("count = " + count);
            return false;
        }

        int row = 0;
        int col = colLength - 1;

        while (row < rowLength && col >= 0) {
            count++;
            if (array[row][col] > target) {
                col--;
            } else if (array[row][col] < target) {
                row++;
            } else {
                System.err.println("count = " + count);
                System.err.println(target + " in (" + row + "," + col + ")");
                return true;
            }
        }

        System.err.println("count = " + count);
        return false;
    }

    /**
     * 在一个二维数组中，每一行从左到右递增，每一列从上到下递增。输入一个数字判断是否存在这个数
     * 同3
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] array = new int[][]
                {
                        {1, 2, 8, 9},
                        {2, 4, 9, 12},
                        {4, 7, 10, 13},
                        {6, 8, 11, 15},
                };

        System.err.println(get(array, 14));
    }
}
