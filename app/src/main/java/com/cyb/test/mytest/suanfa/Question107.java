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

//        Question107 question107 = new Question107();
//        question107.serilaze(root);
//        System.err.println(question107.serilazeStr);
//
//        BinaryTree root1 = question107.deserilaze(question107.serilazeStr);
//        root1.prePrint(root1);

        Codec codec = new Codec();
        String s = codec.serialize(root);
        System.err.println(s);
        BinaryTree tree = codec.deserialize(s);
        tree.prePrint(tree);
    }
}

class Codec {

    int index = 0; //一定要用全局的
    // Encodes a tree to a single string.
    public String serialize(BinaryTree root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }

    public void dfs(BinaryTree root, StringBuilder sb){
        sb.append(root == null ? "null," : root.val + ",");
        if(root == null){
            return;
        }

        dfs(root.left, sb);
        dfs(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public BinaryTree deserialize(String data) {
        if(data == null || data.length() <= 0){
            return null;
        }

        String[] strs = data.split(",");
        return create(strs);
    }

    public BinaryTree create(String[] strs){
        if(index >= strs.length){
            return null;
        }

        BinaryTree root = (strs[index].equals("null") ? null : new BinaryTree(Integer.parseInt(strs[index])));

        index++;

        if (root != null) {
            root.left = create(strs);
            root.right = create(strs);
        }

        return root;
    }
}
