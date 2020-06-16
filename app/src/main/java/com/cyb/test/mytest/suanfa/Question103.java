package com.cyb.test.mytest.suanfa;

public class Question103 {


    private Node reverseList(Node head) {

        Node next = null;
        Node now = head;
        Node temp;

        while (now != null) {
            temp = now.next;
            now.next = next;
            next = now;
            now = temp;
        }

        return next;
    }

    /**
     * 反转链表
     *
     * @param args
     */
    public static void main(String[] args) {
        Question103 q = new Question103();
        Node node1 = new Node(1);
        Node node2 = new Node(2, node1);
        Node node3 = new Node(3, node2);
        Node node4 = new Node(4, node3);
        Node node5 = new Node(5, node4);
        Node node6 = new Node(6, node5);

        Node head = node6;
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }

        System.out.println();

        Node head2 = q.reverseList(node6);

        while (head2 != null) {
            System.out.print(head2.val + " ");
            head2 = head2.next;
        }
    }
}
