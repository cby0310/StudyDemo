package com.cyb.test.mytest.suanfa;

public class Question115 {


    /**
     * 打印从1到最大的n位数：考虑大数的问题，其实考察的全排列
     *
     * @param args
     */
    public static void main(String[] args) {
        Question115 question115 = new Question115();
        question115.printNumbers(2);
    }


    int n;
    StringBuilder stringBuilder = new StringBuilder();
    char[] num;
    char[] numChars = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public void printNumbers(int n) {
        this.n = n;
        num = new char[this.n];
        dfs(0);

        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
        System.err.println(stringBuilder.toString());
    }

    private void dfs(int i) {
        if (i == this.n) {
            stringBuilder.append(Integer.parseInt(String.valueOf(num)) + ",");
            return;
        }

        for (char c : numChars) {
            num[i] = c; //固定第i位字符
            dfs(i + 1);
        }
    }

    private String getStr(char[] num) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : num) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

}
