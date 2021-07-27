package com.cs.CodeTop;


/**
 * 删除链表中的重复元素
* 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 *
 * 返回同样按升序排列的结果链表。
* */
public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode cur = preHead;
        while(cur.next != null && cur.next.next != null){
            if(cur.next.val == cur.next.next.val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return preHead.next;

    }
}
