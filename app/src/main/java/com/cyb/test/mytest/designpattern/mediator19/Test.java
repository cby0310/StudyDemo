package com.cyb.test.mytest.designpattern.mediator19;

/**
 * 中介者模式，和事佬
 * 将多对多的关系变为多对一的关系，就像房地产中介，汇总各个买房卖房的信息
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
//        test.addTwoNumbers(null, null);
        test.lengthOfLongestSubstring(" ggg");
    }


    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        char[] array = s.toCharArray();
        for (int a = 0; a < array.length; a++) {
            StringBuilder sb = new StringBuilder();
            sb.append(array[a]);
            for (int b = a + 1; b < array.length; b++) {
                if (sb.indexOf(new String(array[b] + "")) < 0) {
                    sb.append(array[b]);
                } else {
                    break;
                }
            }
            if (sb.length() > maxLength)
                maxLength = sb.length();
        }
        return maxLength;
    }

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = new ListNode(1);
        l2 = new ListNode(9);
        l2.next = new ListNode(9);


        ListNode header = new ListNode(0);
        ListNode curr = header;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        int carry = 0;
        while (temp1 != null || temp2 != null) {
            if (temp1 == null) {
                temp1 = new ListNode(0);
            }
            if (temp2 == null) {
                temp2 = new ListNode(0);
            }
            //可优化为：
            // int x = (p != null) ? p.val : 0;
            // int y = (q != null) ? q.val : 0;
            int sum = temp1.val + temp2.val;
            curr.next = new ListNode(carry + (sum % 10));
            curr = curr.next;

            temp1 = temp1.next;
            temp2 = temp2.next;

            carry = sum / 10;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return header.next;
    }
}
