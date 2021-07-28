package com.cs.CodeTop;


/**
* 奇偶链表
 *
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
* */
public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {
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
            flag = !flag;
            cur = cur.next;
        }
        cur1.next = head2;
        cur2.next = null;

        return head;
    }
}
