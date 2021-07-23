package com.cs.CodeTop;

/**
 * 合并有序链表
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * */
public class MergeTwoLists {

    //迭代
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2){
        //选头节点
        ListNode head = null;
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val <= l2.val){
            head = l1;
            l1 = l1.next;
        }else {
            head = l2;
            l2 = l2.next;
        }
        ListNode cur = head;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }
        if(l1 == null){
            cur.next = l2;
        }else {
            cur.next = l1;
        }

        return head;
    }

    //递归
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2){
        if(l1 == null){
            return  l2;
        }
        if(l2 == null){
            return  l1;
        }
        ListNode head = null;
        if(l1.val <= l2.val){
            head = l1;
            l1 = l1.next;
        }else{
            head = l2;
            l2 = l2.next;
        }
        head.next = mergeTwoLists2(l1,l2);
        return  head;
    }
}
