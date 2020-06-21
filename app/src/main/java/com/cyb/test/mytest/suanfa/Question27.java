package com.cyb.test.mytest.suanfa;

public class Question27 {
    /**
     * 输入一棵二叉搜索树将其转换为排序的链表。不能创建任何任何新的节点，只能转变后的双向链表。
     * 转换后的顺序与二叉树的中序遍历顺序一致
     * left 指向上一节点、right 指向下一节点
     * 按照中序遍历顺序遍历，
     *
     * @param tree
     * @return
     */
    public BinaryTree convert(BinaryTree tree) {
        convertNode(tree, null);
        BinaryTree head = tree;
        while (head != null && head.left != null) {
            head = head.left;
        }
        return head;
    }

    /**
     * left 指向子节点，右节点指向父节点
     * 当 node 左节点为空，则 left 指向 null
     * 若 node.left 不为空，则上一节点为子树排序后末尾节点
     * lastNode 不为空，则 lastNode 右节点指回 node
     * node.right 不为空，则 node.right 为下一遍历节点
     *
     * @param node
     * @param lastNode
     */
    public BinaryTree convertNode(BinaryTree node, BinaryTree lastNode) {
        if (node == null) {
            return null;
        }
        BinaryTree current = node;
        if (current.left != null) {
            lastNode = convertNode(current.left, lastNode);
        }
        current.left = lastNode;
        if (lastNode != null) {
            lastNode.right = current;
        }
        lastNode = current;
        if (current.right != null) {
            lastNode = convertNode(current.right, lastNode);
        }
        return lastNode;
    }


    BinaryTree pre, head;

    /**
     * 真™牛逼，利用中序遍历、找准pre和cur节点  思路是真牛逼
     */
    private BinaryTree treeToDoubleList(BinaryTree root) {
        if (root == null) {
            return null;
        }

        dfs(root);
        //这是pre指向最后一个节点
        head.left = pre;
        pre.right = head;

        return head;
    }

    /**
     * 中序遍历
     *
     * @param node
     */
    private void dfs(BinaryTree node) {
        if (node == null) {
            return;
        }

        dfs(node.left);

        if (pre != null) {
            pre.right = node;
        } else { //第一次处理的节点
            head = node;
        }
        node.left = pre;
        pre = node;

        dfs(node.right);

    }


    public static void main(String[] args) {
        Question27 q = new Question27();
        BinaryTree node1 = new BinaryTree(1, null, null);
        BinaryTree node3 = new BinaryTree(3, null, null);
        BinaryTree node2 = new BinaryTree(2, node1, node3);
        BinaryTree head = q.treeToDoubleList(node2);
        while (head != null) {
            System.out.print(head.val + ",");
            head = head.right;
        }
    }
}
