package com.hekang.algorithm.java;

/**
 * Created by HE KANG  on 2017\11\16 0016.
 * 算法题目：单链表删除倒数第N个节点
 * 题目变化：给定一个链表，删除链表中倒数第n个节点，返回链表的头节点，注意事项：链表中的节点个数大于等于n
 * ---样例---
 * 给出链表1->2->3->4->5->null和 n = 2.
 * 删除倒数第二个节点之后，这个链表将变成1->2->3->5->null.
 * <p>
 * 思路很简单，只有两种出现的情况：
 * 1、链表的长度刚刚好等于n，也就是说删除表头节点。
 * 2、链表长度大于n，那么我们先定义两个表头，一个后移n位，然后两个链表同时后移，这时当后面的节点到达尾部时，前面的节点就是
 * 删除的节点的前一个节点。
 * 解法二：知道链表总长度l，如果l>n，遍历链表删除第（l-n个节点）
 */

public class Test04 {

    public static void main(String[] args) {

    }

    /**
     * 定义链表ListNode
     */
    public class ListNode {

        public int val;  // 存放数据值
        public ListNode next; // 存放下一节点引用默认为null,头结点

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    /**
     * 删除倒数第n个节点并返回操作后的链表
     * 参数一：第一个节点
     * 参数2：倒数的位置
     */
    private static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode p = head;
        ListNode q = head;
        for (int i = 0; i < n; i++) {
            p = p.next;
        }
        // 此时链表长度等于n,直接返回原头结点
        if (p == null) {
            head = head.next;
            return head;
        }
        // 链表长度大于n
        // 在第44行先将p头后移n位
        // 再将两个头结点同时后移，直到到达尾部
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;  // 删除前一个节点
        return head;
    }
}
