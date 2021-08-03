package com.cs.CodeTop;


import java.util.HashMap;

/**
 * 从链表中删去总和值为零的连续节点（**）
 * 前缀和
 *
* 给你一个链表的头节点head，请你编写代码，反复删去链表中由 总和值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
 *
 * 删除完毕后，请你返回最终结果链表的头节点。
 *
 * 你可以返回任何满足题目要求的答案。
 *
 * （注意，下面示例中的所有序列，都是对ListNode对象序列化的表示。）
 *
* */
public class RemoveZeroSumSublists {

    public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer, ListNode> map = new HashMap();
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode cur = preHead;
        int sum = 0;
        while (cur != null){
            sum += cur.val;
            map.put(sum, cur);
            cur = cur.next;
        }
        sum = 0;
        cur = preHead;
        while (cur != null){
            sum += cur.val;
            cur.next = map.get(sum).next;
            cur = cur.next;
        }
        return preHead.next;
    }
}
