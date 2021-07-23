package com.cs.CodeTop;


/**
 * 相交链表
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 */
public class GetIntersectionNode {
    //1. 双指针指针相遇
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        boolean flagA = false;
        boolean flagB = false;
        ListNode nodeA = headA;
        ListNode nodeB = headB;

        while (nodeA != nodeB) {
            if (nodeA.next != null) {
                nodeA = nodeA.next;
            } else {
                if (flagA) {
                    return null;
                }
                nodeA = headB;
                flagA = true;
            }
            if (nodeB.next != null) {
                nodeB = nodeB.next;
            } else {
                if (flagB) {
                    return null;
                }
                nodeB = headA;
                flagB = true;
            }
        }
        return nodeA;
    }
    //2. 双指针长度截取
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        int numsA = 0, numsB = 0;
        ListNode curA = headA, curB = headB;
        while(curA != null){
            curA = curA.next;
            numsA++;
        }
        while(curB != null){
            curB = curB.next;
            numsB++;
        }
        ListNode head1 = numsA >= numsB ? headA : headB;
        ListNode head2 = numsA < numsB ? headA : headB;
        int length = numsA >= numsB ? numsA - numsB : numsB - numsA;
        for(int i = 0;i < length; i++){
            head1 = head1.next;
        }
        while(head1 != head2){
            head1 = head1.next;
            head2 = head2.next;
            if(head1 == null || head2 == null){
                return null;
            }
        }
        return head1;
    }
}
