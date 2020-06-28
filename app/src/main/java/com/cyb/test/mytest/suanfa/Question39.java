package com.cyb.test.mytest.suanfa;

public class Question39 {
    /**
     * 输入一棵二叉树，求二叉树的深度，即从根节点到叶节点的最长路径
     *
     * @return
     */
    private int getTreeDepth(BinaryTree binaryTree) {
        if (binaryTree == null) {
            return 0;
        }

        int left = getTreeDepth(binaryTree.left);
        int right = getTreeDepth(binaryTree.right);

        return Math.max(left + 1, right + 1);
    }

    /**
     * 判断一颗树是否为平衡二叉树，即左右子树深度差不能为大于 1
     * 这种方法会重复计算底层的子树的高度，有更高效的方法
     *
     * @return
     */
    public boolean isBalanced(BinaryTree root) {
        if (root == null) return true;
        return Math.abs(getTreeDepth(root.left) - getTreeDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }


    /**
     * 我就是更高效的方法，后续遍历树
     *
     * @return
     */
    public boolean isBalanced2(BinaryTree root) {
        return recur(root) != -1;
    }

    private int recur(BinaryTree root) {
        if (root == null) return 0;

        int left = recur(root.left);
        if (left == -1) return -1;

        int right = recur(root.right);
        if (right == -1) return -1;

        return Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;
    }

    public static void main(String[] args) {
        Question39 q = new Question39();

        BinaryTree leftLeft = new BinaryTree(20, null, null);
        BinaryTree left = new BinaryTree(2, leftLeft, null);
        BinaryTree right = new BinaryTree(3, null, null);
        BinaryTree root = new BinaryTree(1, left, right);
        System.out.println(q.getTreeDepth(root));
        System.err.println(q.isBalanced2(root));
    }
}
