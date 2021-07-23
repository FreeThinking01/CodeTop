package com.cs.CodeTop;


/**
 *  反转链表
 *  给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
* */
public class ReverseList {
    //迭代
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null){
            return  head;
        }
        ListNode cur = head.next;
        head.next = null;
        while (cur.next != null){
            ListNode tmp = cur.next;
            cur.next = head;
            head = cur;
            cur = tmp;
        }
        cur.next = head;
        return cur;
    }
    //递归
    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null){
            return  head;
        }
        ListNode last = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return  last;
    }
}
