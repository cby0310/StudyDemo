package com.cyb.test.mytest.suanfa;

public class Question107 {

    private String serilazeStr = "";

    /**
     * 序列化
     *
     * @param root
     */
    private void serilaze(BinaryTree root) {
        if (root == null) {
            serilazeStr += "null,";
            return;
        }
        serilazeStr += root.val + ",";
        serilaze(root.left);
        serilaze(root.right);
    }


    private int index = 0;

    /**
     * 反序列化
     */
    private BinaryTree deserilaze(String str) {
        String[] modes = str.split(",");
        index = 0;
        BinaryTree root = deserilazeCore(modes);
        return root;
    }


    private BinaryTree deserilazeCore(String[] modes) {
        if (index >= modes.length) {
            return null;
        }

        int val;
        String valStr = modes[index];
        index++;
        if (valStr.equals("null")) {
            return null;
        } else {
            val = Integer.parseInt(valStr);
        }

        BinaryTree root = new BinaryTree(val, null, null);
        root.left = deserilazeCore(modes);
        root.right = deserilazeCore(modes);
        return root;
    }

    /**
     * 序列化和反序列化二叉树
     *
     * @param args
     */
    public static void main(String[] args) {
        BinaryTree node1 = new BinaryTree(1, null, null);
        BinaryTree node2 = new BinaryTree(2, null, null);
        BinaryTree node3 = new BinaryTree(3, node1, node2);

        BinaryTree node4 = new BinaryTree(4, null, null);
        BinaryTree node5 = new BinaryTree(5, null, null);
        BinaryTree node6 = new BinaryTree(6, node4, node5);

        BinaryTree root = new BinaryTree(7, node3, node6);
        root.prePrint(root);
        System.err.println();

        Question107 question107 = new Question107();
        question107.serilaze(root);
        System.err.println(question107.serilazeStr);

        BinaryTree root1 = question107.deserilaze(question107.serilazeStr);
        root1.prePrint(root1);
    }
}
