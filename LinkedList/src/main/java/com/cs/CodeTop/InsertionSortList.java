package com.cs.CodeTop;


/**
 * 对链表进行插入排序
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *
* */
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        return null;
    }
}
