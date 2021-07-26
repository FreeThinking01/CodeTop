package com.cs.CodeTop;

/**
 * 两数相加
* 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
* */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l = l1;
        int add = 0;
        while(l1.next != null || l2.next != null){
            if(l1.next == null){
                l1.next = new ListNode(0);
            }
            if(l2.next == null){
                l2.next = new ListNode(0);
            }
            int sum = l1.val + l2.val + add;
            int num = sum % 10;
            add = sum / 10;
            l1.val = num;
            l1 = l1.next;
            l2 = l2.next;
        }
        int sum = l1.val + l2.val + add;
        int num = sum % 10;
        add = sum / 10;
        l1.val = num;
        if (add != 0){
            l1.next = new ListNode(add);
        }
        return l;
    }
}
