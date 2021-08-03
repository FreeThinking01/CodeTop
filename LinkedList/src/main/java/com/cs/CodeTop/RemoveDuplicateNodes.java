package com.cs.CodeTop;


import java.util.HashSet;

/**
 * 移除重复节点
 * <p>
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 */
public class RemoveDuplicateNodes {

    //使用临时缓冲区 O(N) O(N)
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode pre = preHead;
        while (pre.next != null) {
            if (set.contains(pre.next.val)) {
                pre.next = pre.next.next;
            } else {
                set.add(pre.next.val);
                pre = pre.next;
            }
        }
        return preHead.next;
    }

    //不使用临时缓冲区 O(N^2) O(1)
    public ListNode removeDuplicateNodes2(ListNode head) {
        ListNode ob = head;
        while (ob != null) {
            ListNode oc = ob;
            while (oc.next != null) {
                if (oc.next.val == ob.val) {
                    oc.next = oc.next.next;
                } else {
                    oc = oc.next;
                }
            }
            ob = ob.next;
        }
        return head;
    }


}
