package com.cyb.test.mytest.suanfa;

import java.util.Stack;

/**
 * 两个栈实现一个队列
 *
 * @param <T>
 */
class Queue<T> {
    private Stack<T> stack1 = new Stack<>();
    private Stack<T> stack2 = new Stack<>();

    /**
     * 入队列
     *
     * @param ob
     */
    public void pushHead(T ob) {
        stack1.push(ob);
    }

    /**
     * 出队列
     *
     * @return
     * @throws Exception
     */
    public T popHead() throws Exception {

        if (stack2.size() <= 0) {
            while (stack1.size() > 0) {
                stack2.push(stack1.pop());
            }
        }

        if (stack2.size() <= 0) {
            throw new Exception("empty!");
        }

        return stack2.pop();
    }
}

public class Question7 {
    public static void main(String[] args) throws Exception {
        Queue<Integer> queue = new Queue<Integer>();
        queue.pushHead(1);
        queue.pushHead(2);
        queue.pushHead(3);

        System.err.println(queue.popHead());
        System.err.println(queue.popHead());

        queue.pushHead(4);
        System.err.println(queue.popHead());
    }
}
