package com.cs.CodeTop;


/**
 * 排序链表（**）
* 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
* */
public class SortList {
    //自顶向下
    public ListNode sortList1(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode midNode = findMidNode(head);
        ListNode head1 = sortList1(head);
        ListNode head2 = sortList1(midNode);
        return mergeTwoList(head1,head2);
    }

    private ListNode findMidNode(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode midNode = slow.next;
        slow.next = null;
        return midNode;
    }

    public ListNode mergeTwoList(ListNode head1, ListNode head2){
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        ListNode head = null;
        if(head1.val <= head2.val){
            head = head1;
            head1 = head1.next;
        }else{
            head = head2;
            head2 = head2.next;
        }
        ListNode cur = head;
        while(head1 != null && head2 != null){
            if(head1.val <= head2.val){
                cur.next = head1;
                cur = cur.next;
                head1 = head1.next;
            }else{
                cur.next = head2;
                cur = cur.next;
                head2 = head2.next;
            }
        }
        if(head1 == null){
            cur.next = head2;
        }else{
            cur.next = head1;
        }
        return head;
    }
    //2. 迭代
    public ListNode sortList2(ListNode head) {
        //初始化变量
        ListNode h,h1,h2,res,pre;
        h = head;
        int length = 0,step = 1;
        res = new ListNode(0);
        res.next = head;
        while(h != null){
            length++;
            h = h.next;
        }

        //迭代合并
        while (step < length) {
            pre = res;
            h = res.next;
            while(h != null){
                h1 = h;
                int i = step;
                while(i > 0 && h != null){
                    h = h.next;
                    i--;
                }
                if(i > 0){
                    //此时不足one step
                    break;
                }
                h2 = h;
                i = step;
                while(i > 0 && h != null){
                    h = h.next;
                    i--;
                }
                //合并两组中前一组长度step，后一组step-i
                int len1 = step,len2 = step - i;
                //开始合并,有序链表合并
                while(len1 > 0 && len2 > 0){
                    if(h1.val <= h2.val){
                        len1--;
                        pre.next = h1;
                        h1 = h1.next;
                    }else{
                        len2--;
                        pre.next = h2;
                        h2 = h2.next;
                    }
                    pre = pre.next;
                }
                pre.next = len1 == 0 ? h2 : h1;
                while(len1 > 0 || len2 > 0){
                    pre = pre.next;
                    len1--;
                    len2--;
                }
                //把当前合并链表尾节点和下一个待合并链表头节点连接
                pre.next = h;

            }
            step *= 2;
        }
        return res.next;
    }
}
