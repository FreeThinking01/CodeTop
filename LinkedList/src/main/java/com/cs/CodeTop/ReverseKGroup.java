package com.cs.CodeTop;


/**
*  k个一组翻转链表
 * 给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 进阶：
 *
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
* */
public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head,last = head;
        for (int i = 0; i < k; i++){
            if (last == null){
                return  head;
            }
            last = last.next;

        }
        ListNode newHead = reverseList(start,last);
        start.next = reverseKGroup(last, k);
        return newHead;
    }


    //反转链表[a,b）
    public ListNode reverseList(ListNode head, ListNode last) {
        if (head == null || head.next == last){
            return  head;
        }
        ListNode cur = head.next;
        head.next = null;
        while (cur.next != last){
            ListNode tmp = cur.next;
            cur.next = head;
            head = cur;
            cur = tmp;
        }
        cur.next = head;
        return cur;
    }

}
