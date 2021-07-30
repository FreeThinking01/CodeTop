package com.cs.CodeTop;


import java.util.Stack;

/**
* 两数相加Ⅱ
 *
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 如果输入链表不能修改该如何处理？换句话说，不能对列表中的节点进行翻转。
* */
public class AddTwoNumbers2 {

    //可以转变成正常的逆序两数相加，但题目说不要反转链表
    //使用栈
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<ListNode>();
        Stack<ListNode> stack2 = new Stack<ListNode>();
        while (l1 != null){
            stack1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null){
            stack2.push(l2);
            l2 = l2.next;
        }
        int add = 0;
        ListNode cur = null, pre = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()){
            int num1 = stack1.isEmpty() ? 0 : stack1.pop().val;
            int num2 = stack2.isEmpty() ? 0 : stack2.pop().val;
            int sum = num1 + num2 + add;
            add = sum / 10;
            cur = new ListNode(sum % 10);
            cur.next = pre;
            pre = cur;
        }
        if(add != 0){
            cur = new ListNode(add);
            cur.next = pre;
        }
        return cur;
    }

}
