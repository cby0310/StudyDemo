package com.cyb.test.mytest.suanfa;

public class Question106 {

    public void mirrorTree(BinaryTree A) {
        if (A == null || (A.left == null && A.right == null)) {
            return;
        }

        BinaryTree temp = A.left;
        A.left = A.right;
        A.right = temp;

        mirrorTree(A.left);
        mirrorTree(A.right);
    }


    /**
     * 对称的二叉树
     *
     * @param args
     */
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
    }
}
