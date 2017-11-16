package com.hekang.algorithm.java;

/**
 * Created by HE KANG  on 2017\11\16 0016.
 */

public class StackTest {

    public static void main(String[] args) {
        MyStack myStack = new MyStack(20);
        // 入栈数据
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        System.out.println("栈的大小为" + myStack.size());
        // 出栈
        for (int i = myStack.myTop; i >= 0; i++) {
            if (!myStack.isEmpty()) {
                int get = myStack.peek();
                myStack.pop();
                System.out.println(get);
            }
        }

    }

    static class MyStack {

        int myTop;   // 栈第一个元素位置
        int stack[];  // 使用数组实现

        /**
         * 构造方法
         */
        public MyStack(int num) {
            myTop = -1;  // -1代表为空栈
            stack = new int[num];
        }

        /**
         * 出栈
         */
        private void pop() {
            myTop--;
        }

        /**
         * 入栈
         */
        private void push(int x) {
            myTop++;
            stack[myTop] = x;
        }

        /**
         * 判空
         */
        private Boolean isEmpty() {
            if (myTop == -1) {
                return true; // 空栈
            } else {
                return false;
            }
        }

        /**
         * 区栈顶元素
         */
        private int peek() {
            int pe = stack[myTop];
            return pe;
        }

        /**
         * 栈大小
         */
        private int size() {
            return myTop + 1;
        }
    }
}
