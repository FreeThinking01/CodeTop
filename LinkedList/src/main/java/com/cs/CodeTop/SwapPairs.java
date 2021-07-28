package com.cs.CodeTop;


/**
 * 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换
 */
public class SwapPairs {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        SwapPairs test = new SwapPairs();
        test.swapPairs2(node1);
    }

    //递归
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node1 = head, node2 = head.next;
        ListNode tmp = node2.next;
        node2.next = node1;
        node1.next = swapPairs(tmp);
        return node2;
    }


    //迭代
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode pre = preHead;
        while(pre.next != null && pre.next.next != null){
            ListNode node1 = pre.next;
            ListNode node2 = pre.next.next;
            pre.next = node2;
            ListNode tmp = node2.next;
            node2.next = node1;
            node1.next = tmp;
            pre = node1;
        }
        return preHead.next;
    }
}
