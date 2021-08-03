package com.cs.CodeTop;


/**
 * 删除链表节点
 *
* 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 *
 * 注意：此题对比原题有改动
* */
public class DeleteNode {

    public ListNode deleteNode(ListNode head, int val) {
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode pre = preHead;
        while (pre.next != null){
            if(pre.next.val == val){
                pre.next = pre.next.next;
            }else {
                pre = pre.next;
            }

        }
        return preHead.next;
    }
}
