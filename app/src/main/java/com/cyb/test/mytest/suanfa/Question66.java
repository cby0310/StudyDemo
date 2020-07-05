package com.cyb.test.mytest.suanfa;

import java.util.Arrays;

public class Question66 {
    /**
     * 题：设计一个函数用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中任意一格开始，
     * 每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再进入该格子。（路径中不能有重复格子）
     * 思路分析：回溯法
     * 1、定义和矩阵同样大小数组来记录该格子是否已经遍历
     * 2、从（0,0） 开始，选择上下左右任意一点为下一路径，不能超过数组长度
     * 3、递归：下一步可以选择上、下、左、右任意一格。
     * 4、剪枝：与目前字符串当前需要的字符不匹配、已走过该格子、超过格子边界
     * 5、出现任意一种解即返回 true
     * @return
     */
    public boolean exist(char[][] board, String word) {

        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) { //确定起点
                boolean exist = hasPath(board, word, i, j, 0);
                if (exist) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean hasPath(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }

        int row = board.length;
        int col = board[0].length;

        boolean hasPath = false;
        if (i >= 0 && i < row && j >= 0 && j < col && board[i][j] == word.charAt(index)) {
            char temp = board[i][j];
            board[i][j] = '/';
            hasPath = hasPath(board, word, i - 1, j, index + 1) ||
                    hasPath(board, word, i + 1, j, index + 1) ||
                    hasPath(board, word, i, j - 1, index + 1) ||
                    hasPath(board, word, i, j + 1, index + 1);
            board[i][j] = temp;
        }

        return hasPath;
    }

    public static void main(String[] args) {
        Question66 q = new Question66();
        char[][] matrix = {
                {'a', 'b', 'c', 'e'},
                {'s', 'f', 'e', 's'},
                {'a', 'd', 'E', 'e'}
        };
        System.out.println(q.exist(matrix, "abceseEef"));
    }
}
