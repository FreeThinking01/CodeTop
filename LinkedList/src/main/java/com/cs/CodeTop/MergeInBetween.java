package com.cs.CodeTop;


/**
* 合并两个链表
 * 
 * 给你两个链表list1 和list2，它们包含的元素分别为n 个和m 个。
 *
 * 请你将list1中第a个节点到第b个节点删除，并将list2接在被删除节点的位置。
 *
 * (节点索引从0计数，不会删除第一个节点)
* */
public class MergeInBetween {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode preNodeA = list1;
        for(int i = 0; i < a - 1; i++){
            preNodeA = preNodeA.next;
        }
        ListNode lastNodeB = preNodeA;
        for(int i = 0; i < b - a + 2;i++){
            lastNodeB = lastNodeB.next;
        }
        preNodeA.next = list2;
        ListNode cur = list2;
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = lastNodeB;
        return list1;
    }
}
