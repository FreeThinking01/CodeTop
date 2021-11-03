package com.cs.CodeTop;

/**
 * @program: CodeTop
 * @author: FreeThinking
 * @create: 2021-11-03 14:48
 * @description: 请编写一个函数，用于 删除单链表中某个特定节点 。在设计函数时需要注意，你无法访问链表的头节点 head ，只能直接访问 要被删除的节点 。  题目数据保证需要删除的节点 不是末尾节点
 **/
public class DeleteNode2 {

    public void deleteNode(ListNode node) {
        node.next.val = node.val;
        node.next = node.next.next;
    }
}
