package com.cs.CodeTop;


/**
* 排序奇升偶降链表
 * 给定一个奇数位升序，偶数位降序的链表，将其重新排序。
 *
 * 输入: 1->8->3->6->5->4->7->2->NULL
 * 输出: 1->2->3->4->5->6->7->8->NULL
* */
public class SortOddEvenList {
    public ListNode sortOddEvenList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode head1 = head, head2 = head.next;
        ListNode cur1 = head1, cur2 = head2, cur = head2.next;
        boolean flag = true;
        //奇偶拆分
        while(cur != null){
            if(flag){
                cur1.next = cur;
                cur1 = cur1.next;
            }else {
                cur2.next = cur;
                cur2 = cur2.next;
            }
            cur = cur.next;
            flag = !flag;
        }
        cur1.next = null;
        cur2.next = null;
        //偶数倒置
        head2 = reverseList(head2);
        //合并链表
        return mergeTwoList(head1, head2);
    }

    private ListNode mergeTwoList(ListNode head1, ListNode head2) {
        ListNode cur1 = head1.next, cur2 = head2, cur = head1;
        boolean flag = true;
        while(cur1 != null && cur2 != null){
            if(flag){
                cur.next = cur2;
                cur2 = cur2.next;
            }else {
                cur.next = cur1;
                cur1 = cur1.next;
            }
            flag = !flag;
            cur = cur.next;
        }
        if(cur1 == null){
            cur.next = cur2;
        }else {
            cur.next = cur1;
        }

        return head1;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return  head;
        }
        ListNode cur = head.next;
        head.next = null;
        while (cur.next != null){
            ListNode tmp = cur.next;
            cur.next = head;
            head = cur;
            cur = tmp;
        }
        cur.next = head;
        return cur;
    }
}
