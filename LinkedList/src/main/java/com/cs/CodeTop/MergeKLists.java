package com.cs.CodeTop;

/**
 *合并k个升序链表
 *给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
* */
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        return sortKList(lists, 0, lists.length - 1);
    }

    private ListNode sortKList(ListNode[] lists, int left, int right) {
        if(left < right){
            int mid = left + (right - left) / 2;
            ListNode list1 = sortKList(lists, left, mid);
            ListNode list2 = sortKList(lists, mid + 1, right);
            return mergeTwoLists(list1, list2);
        }
        return lists[left];
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        //选头节点
        ListNode head = null;
        if(list1.val <= list2.val){
            head = list1;
            list1 = list1.next;
        }else{
            head = list2;
            list2 = list2.next;
        }
        ListNode cur = head;
        while (list1 != null && list2 != null){
            if(list1.val <= list2.val){
                cur.next = list1;
                cur = cur.next;
                list1 = list1.next;
            }else{
                cur.next = list2;
                cur = cur.next;
                list2 = list2.next;
            }
        }
        if(list1 == null){
            cur.next = list2;
        }else{
            cur.next = list1;
        }
        return head;
    }

}
