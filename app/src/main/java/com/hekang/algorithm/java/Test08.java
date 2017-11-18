package com.hekang.algorithm.java;

/**
 * Created by HE KANG  on 2017\11\17 0017.
 * 算法题目：判断两个链表是否相交并找出两个链表的相交点。
 * 解法一：采用双循环遍历两个链表的节点的hash值进行比较。
 * 解法二：采用双循环遍历两个编表，比较节点是否相同。
 * 解法三：《编程之美》方法，先遍历一个链表到尾部然后将该尾部节点指向第二个链表的头部，这两就会形成一个新的链表，
 *         最终验证该链表是否环就可以反推出原来连个链表是否相交了。
 *         问题：如何判断一个链表是否存在环？
 *         解法：使用追赶的方法，设定两个指针slow、fast，从头指针开始，每次分别前进1步、2步。如存在环，则两者相遇；
 *               如不存在环，fast遇到NULL退出
 * 解法四（见如下代码）：如果两个链表相交那么他们的尾节点肯定相同的，那就分别找出两个尾节点比较。
 *         问题：如何找到相交点，假设链表1的长度是len1链表2的长度是len2,将长的链表向后移动|len1-len2|(绝对值)，
 *               然后同时移动两个链表，直到第一次出现相同的节点即就是两个链表的相交点。
 */

public class Test08 {

    public static void main(String[] args) {

        typedef struct node_t
        {
            int data;//data
            struct node_t *next; //next
        }node;

        node* find_node(node *head1, node *head2)
        {
            if(null == head1 || null == head2)
            {
                return null;//如果有为空的链表，肯定是不相交的
            }
            node *p1, *p2;
            p1 = head1;
            p2 = head2;
            int len1 = 0;
            int len2 =0;
            int diff = 0;
            while(NULL != p1->next)
            {
                p1 = p1->next;
                len1++;
            }
            while(NULL != p2->next)
            {
                p2 = p2->next;
                len2++;
            }
            if(p1 != p2) //如果最后一个节点不相同,返回NULL
            {
                return NULL;
            }
            diff = abs(len1 - len2);
            if(len1 > len2)
            {
                p1 = head1;
                p2 = head2;
            }
            else
            {
                p1 = head2;
                p2 = head1;
            }
            for(int i=0; i<diff; i++)
            {
                p1 = p1->next;
            }
            while(p1 != p2)
            {
                p1 = p1->next;
                p2 = p2->next;
            }
            return p1;
        }
    }
}
