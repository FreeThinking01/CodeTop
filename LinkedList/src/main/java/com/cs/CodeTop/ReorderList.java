package com.cs.CodeTop;


/**
 * 重排链表
 *
* 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 *
 * L0→ L1→ … → Ln-1→ Ln
 * 请将其重新排列后变为：
 *
 * L0→Ln→L1→Ln-1→L2→Ln-2→ …
 *
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
* */
public class ReorderList {

    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode midHead = slow.next;
        slow.next = null;
        ListNode head2 = reverseList(midHead);
        ListNode head1 = head.next;
        ListNode cur = head;
        boolean flag = true;
        while(head1 != null && head2 != null){
            if(flag){
                cur.next = head2;
                cur = cur.next;
                head2 = head2.next;
            }else{
                cur.next = head1;
                cur = cur.next;
                head1 = head1.next;
            }
            flag = !flag;
        }
        if(head1 == null){
            cur.next = head2;
        }else{
            cur.next = head1;
        }

    }

    private ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode cur = head.next;
        head.next = null;
        while(cur.next != null){
            ListNode tmp = cur.next;
            cur.next = head;
            head = cur;
            cur = tmp;
        }
        cur.next = head;
        return cur;
    }

}
