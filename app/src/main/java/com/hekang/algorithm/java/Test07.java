package com.hekang.algorithm.java;

/**
 * Created by HE KANG  on 2017\11\17 0017.
 * 算法题目：用数组实现在一个队列，大小固定，时间复杂度为n,我写的是有length的情况，然后他让在不使用length的情况下，实现。
 */

public class Test07 {

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(10);
        System.out.println("队列是否为空：" + queue.isEmpty());
        for (int i = 0; i < 10; i++) {
            queue.insert(i);
        }
        System.out.println("队列是否已满：" + queue.isFull());
        System.out.println("获取队列头元素：" + queue.peekFront());
        System.out.println("获取队列尾元素：" + queue.peekRear());
        while (!queue.isEmpty()) {
            System.out.println("移除队列元素：" + queue.removeData());
        }
    }

    private static class ArrayQueue {
        private int[] arrInt; // 内置数组
        private int front; // 头指针
        private int rear; // 尾指针

        public ArrayQueue(int size) {
            this.arrInt = new int[size];
            front = 0;
            rear = -1;
        }

        /**
         * 判断队列是否为空
         */
        public boolean isEmpty() {
            return front == arrInt.length;  // 头指针等于内置数组的长度
        }

        /**
         * 判读队列是的已满
         */
        public boolean isFull() {
            return arrInt.length - 1 == rear;  // 内置数组的长度等于尾指针+1
        }

        /**
         * 向队列的尾部插入一个元素
         */
        public void insert(int data) {
            if (isFull()) {
                throw new RuntimeException("队列已满");
            } else {
                arrInt[++rear] = data;  // 插入数据，尾指针++
            }
        }

        /**
         * 获取队列头的数据元素
         */
        public int peekFront() {
            return arrInt[front];
        }

        /**
         * 获取队列尾的数据元素
         */
        public int peekRear() {
            return arrInt[rear];
        }

        /**
         * 从队列头移除一个元素
         */
        public int removeData() {
            if (isEmpty()) {
                throw new RuntimeException("队列为空");
            } else {
                return arrInt[front++];  // 此处取完头元素后，头结点要++
            }
        }
    }
}
