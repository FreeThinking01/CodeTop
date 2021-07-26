package com.cs.CodeTop;


/**
 * 反转链表Ⅱ
* 给你单链表的头指针 head 和两个整数left 和 right ，其中left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回反转后的链表 。
 *
* */
public class ReverseBetween {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode pre = preHead, leftHead = null, rightHead = null;
        for(int i = 0; i < left - 1; i++){
            pre = pre.next;
        }
        leftHead = pre.next;
        rightHead = leftHead;
        for(int i = left;i < right + 1; i++){
            rightHead = rightHead.next;
        }
        pre.next = reverseList(leftHead, rightHead);
        leftHead.next = rightHead;
        return preHead.next;
    }

    private ListNode reverseList(ListNode leftHead, ListNode rightHead) {
        if(leftHead == null || leftHead.next == rightHead){
            return leftHead;
        }
        ListNode cur = leftHead.next;
        leftHead.next = null;
        while(cur.next != rightHead){
            ListNode tmp = cur.next;
            cur.next = leftHead;
            leftHead = cur;
            cur = tmp;
        }
        cur.next = leftHead;
        return cur;

    }
}
