package com.cs.CodeTop;


/**
 * 回文链表
* 请判断一个链表是否为回文链表。
* */
public class IsPalindrome {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        IsPalindrome test = new IsPalindrome();
        test.isPalindrome(node1);
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode midNode = reverseList(slow.next);
        slow.next = null;
        while(midNode != null){
            if(head.val != midNode.val){
                return false;
            }
            head = head.next;
            midNode = midNode.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode cur = head.next;
        head.next = null;
        while(cur.next != null){
            ListNode tmp = cur.next;
            cur.next = head;
            head = cur;
            cur = tmp;
        }
        cur.next = head;
        return cur;
    }
}
