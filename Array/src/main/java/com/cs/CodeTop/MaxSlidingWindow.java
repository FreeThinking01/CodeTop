package com.cs.CodeTop;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @program: CodeTop
 * @author: FreeThinking
 * @create: 2022-01-08 15:28
 * @description: 滑动窗口最大值
 *
 * 给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 **/
public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int index = 0;
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        //快速填充形成第一个窗口
        for(int i = 0; i < k; i++){
            while(!deque.isEmpty() && deque.peekLast() < nums[i]){
                deque.pollLast();
            }
            deque.offerLast(nums[i]);
        }
        res[index++] = deque.peekFirst();
        for(int i = k; i < n; i++){
            //先判断窗口移动删除的元素
            if(nums[i - k] == deque.peekFirst()){
                deque.pollFirst();
            }
            while(!deque.isEmpty() && deque.peekLast() < nums[i]){
                deque.pollLast();
            }
            deque.offerLast(nums[i]);
            res[index++] = deque.peekFirst();
        }
        return res;
    }
}
