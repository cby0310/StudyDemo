package com.cyb.test.mytest.suanfa;

public class Question104 {


    /**
     * 递归回溯
     *
     * @param head1
     * @param head2
     * @return
     */
    private Node mergeList(Node head1, Node head2) {

        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        Node temp = head1.val > head2.val ? head2 : head1;//找到最小的一个
        if (head1.val > head2.val) {
            temp.next = mergeList(head1, head2.next);
        } else {
            temp.next = mergeList(head1.next, head2);
        }

        return temp;
    }


    /**
     * 遍历方式:关键点是找到now和next节点、空判断
     *
     * @param head1
     * @param head2
     * @return
     */
    private Node mergeList1(Node head1, Node head2) {

        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        Node head = head1.val > head2.val ? head2 : head1;//找到最小的节点,它一定是最终链表的头结点
        Node now = head;//这里的now不一定是真正的开始处理的节点

        //找到下一个较大的节点，他一定是下一个要指向的节点
        Node next = head1.val > head2.val ? head1 : head2;

        //调整一下now的位置
        while (now.next != null && now.next.val < next.val) {
            now = now.next;
        }

        while (next != null) {
            Node temp = now.next;

            now.next = next;
            now = next;

            next = temp;

            while (now.next != null && next != null && now.next.val < next.val) {
                now = now.next;
            }
        }

        return head;
    }


    /**
     * 反转链表
     *
     * @param args
     */
    public static void main(String[] args) {
        Question104 question104 = new Question104();
        Node node1 = new Node(7);
        Node node2 = new Node(5, node1);
        Node node3 = new Node(3, node2);
        Node head1 = new Node(3, node3);

        Node node4 = new Node(8);
        Node node5 = new Node(6, node4);
        Node node6 = new Node(4, node5);
        Node head2 = new Node(2, node6);

        Node t1 = head1;
        while (t1 != null) {
            System.out.print(t1.val + " ");
            t1 = t1.next;
        }
        System.out.println();

        Node t2 = head2;
        while (t2 != null) {
            System.out.print(t2.val + " ");
            t2 = t2.next;
        }
        System.out.println();

        Node head = question104.mergeList1(head1, head2);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
