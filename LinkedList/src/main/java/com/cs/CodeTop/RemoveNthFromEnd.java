package com.cs.CodeTop;


import java.util.Stack;

/**
 * 删除链表的倒数第 N 个结点
* 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
* */
public class RemoveNthFromEnd {
    //1.双指针
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if (head == null){
            return null;
        }
        //找出倒数第n+1个节点
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode slow = preHead, fast = preHead;
        for (int i = 0; i < n; i++){
            fast = fast.next;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return preHead.next;
    }
    //2.计算链表长度
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if(head == null){
            return null;
        }
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode cur = head;
        int length = 0;
        while (cur != null){
            length++;
            cur = cur.next;
        }
        cur = preHead;
        for(int i = 0; i < length - n; i++){
            cur = cur.next;
        }
        cur.next = cur.next.next;

        return preHead.next;
    }

    //3.栈
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        if(head == null){
            return null;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode cur = preHead;
        while(cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        for(int i = 0; i < n + 1; i++){
            cur = stack.pop();
        }
        cur.next = cur.next.next;
        return preHead.next;
    }
}
