package com.cyb.test.mytest.suanfa;

public class Question105 {

    public boolean isSubStructure(BinaryTree A, BinaryTree B) {
        if (A == null || B == null) return false;
        return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean dfs(BinaryTree A, BinaryTree B) {
        if (B == null) return true;
        if (A == null) return false;
        return A.val == B.val && dfs(A.left, B.left) && dfs(A.right, B.right);
    }

    /**
     * 树的子结构 https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/comments/
     *
     * @param args
     */
    public static void main(String[] args) {
    }
}
