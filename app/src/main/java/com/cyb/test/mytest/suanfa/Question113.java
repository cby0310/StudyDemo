package com.cyb.test.mytest.suanfa;

import javax.crypto.Mac;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Question113 {


    /**
     * @param args
     */
    public static void main(String[] args) {
        Question113 question113 = new Question113();
        int[] arrays = question113.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (int a : arrays) {
            System.err.print(a + ",");
        }
        System.err.println();

        MaxQueue maxQueue = new MaxQueue();
        maxQueue.pushBack(1);
        maxQueue.pushBack(3);
        maxQueue.pushBack(-1);
        System.err.println("max  = " + maxQueue.maxValue());
        maxQueue.popFront();
        System.err.println("max  = " + maxQueue.maxValue());
        maxQueue.popFront();
        System.err.println("max  = " + maxQueue.maxValue());
        maxQueue.popFront();
        System.err.println("max  = " + maxQueue.maxValue());
        maxQueue.popFront();
        System.err.println("max  = " + maxQueue.maxValue());

    }


    /***
     * 获取滑动窗口的最大值，k是滑动窗口的大小
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) { // 未形成窗口
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) deque.removeLast();
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        for (int i = k; i < nums.length; i++) { // 形成窗口后
            if (deque.peekFirst() == nums[i - k]) deque.removeFirst();
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) deque.removeLast();
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }


    static class MaxQueue {
        Queue<Integer> queue;
        LinkedList<Integer> max;

        public MaxQueue() {
            queue = new LinkedList<Integer>();
            max = new LinkedList<Integer>();//LinkedList是双端链表
        }

        public Integer maxValue() {
            return max.isEmpty() ? -1 : max.getFirst();
        }


        public void pushBack(Integer integer) {
            queue.add(integer);
            while (!max.isEmpty() && max.getLast() < integer) max.removeLast();
            max.add(integer);
        }

        public int popFront() {
            if (!max.isEmpty() && max.getFirst().equals(queue.peek())) {
                max.removeFirst();
            }
            return queue.isEmpty() ? -1 : queue.poll();
        }

    }

}
