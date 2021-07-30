package com.cs.CodeTop;




/**
* 分隔链表
 *
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在大于或等于 x 的节点之前。
 *
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 *
* */
public class Partition {

    public ListNode partition(ListNode head, int x) {
        ListNode head1 = new ListNode(-201);
        ListNode head2 = new ListNode(201);
        ListNode preCur1 = head1, preCur2 = head2;
        while(head != null){
            if(head.val < x){
                preCur1.next = head;
                preCur1 = preCur1.next;
                head = head.next;
            }else{
                preCur2.next = head;
                preCur2 = preCur2.next;
                head = head.next;
            }
        }
        preCur1.next = null;
        preCur2.next = null;
        preCur1.next = head2.next;
        return head1.next;
    }
}
