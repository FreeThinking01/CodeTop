package com.cs.CodeTop;


/**
* 旋转链表
 *
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
* */
public class RotateRight {
    //1. 快慢指针
    public ListNode rotateRight1(ListNode head, int k) {
        if (head == null || head.next == null){
            return head;
        }
        int length = computeList(head);
        return cycleList(head, k % length);
    }

    private int computeList(ListNode head){
        int nums = 0;
        while (head != null){
            head = head.next;
            nums++;
        }
        return nums;
    }

    private ListNode cycleList(ListNode head, int k){
        //找到倒数第k+1个节点 把尾部的k个节点拿下来放到头部
        if (k == 0){
            return head;
        }
        ListNode slow = head, fast = head;
        for(int i = 0; i < k; i++){
            fast = fast.next;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }

    //2. 闭合为环（leetcode）
    public ListNode rotateRight2(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }
        ListNode cur = head;
        int nums = 1;
        while(cur.next != null){
            cur = cur.next;
            nums++;
        }
        k = k % nums;
        if(k == 0){
            return head;
        }
        cur.next = head;
        cur = head;
        //找到第nums - k - 1个节点断链
        for(int i = 0; i < nums - k - 1; i++){
            cur = cur.next;
        }
        ListNode res = cur.next;
        cur.next = null;
        return res;
    }

}
