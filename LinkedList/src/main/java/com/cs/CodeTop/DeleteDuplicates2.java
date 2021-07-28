package com.cs.CodeTop;


/**
 * 删除链表中的重复元素Ⅱ
* 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中没有重复出现的数字。
 *
 * 返回同样按升序排列的结果链表。
 *
* */
public class DeleteDuplicates2 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode cur = preHead;
        while(cur.next != null && cur.next.next != null){
            if(cur.next.val == cur.next.next.val){
                int num = cur.next.val;
                while(cur.next != null && cur.next.val == num){
                    cur.next = cur.next.next;
                }
            }else{
                cur = cur.next;
            }
        }

        return preHead.next;
    }
}
