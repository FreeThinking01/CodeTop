package com.cs.CodeTop;


/**
 * 返回倒数第 k 个节点
 *
* 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
* */
public class KthToLast {

    public int kthToLast(ListNode head, int k) {
        ListNode slow = head, fast = head;
        for(int i = 0; i < k; i++){
            fast = fast.next;
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }
}
