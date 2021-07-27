package com.cs.CodeTop;


/**
 * 排序链表
* 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
* */
public class SortList {
    //自顶向下
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode midNode = findMidNode(head);
        ListNode head1 = sortList(head);
        ListNode head2 = sortList(midNode);
        return mergeTwoList(head1,head2);
    }

    private ListNode findMidNode(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode midNode = slow.next;
        slow.next = null;
        return midNode;
    }

    public ListNode mergeTwoList(ListNode head1, ListNode head2){
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        ListNode head = null;
        if(head1.val <= head2.val){
            head = head1;
            head1 = head1.next;
        }else{
            head = head2;
            head2 = head2.next;
        }
        ListNode cur = head;
        while(head1 != null && head2 != null){
            if(head1.val <= head2.val){
                cur.next = head1;
                cur = cur.next;
                head1 = head1.next;
            }else{
                cur.next = head2;
                cur = cur.next;
                head2 = head2.next;
            }
        }
        if(head1 == null){
            cur.next = head2;
        }else{
            cur.next = head1;
        }
        return head;
    }

}
