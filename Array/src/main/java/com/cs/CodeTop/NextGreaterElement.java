package com.cs.CodeTop;

import java.util.HashMap;
import java.util.Stack;

/**
 * @program: CodeTop
 * @author: FreeThinking
 * @create: 2021-10-26 10:18
 * @description: 下一个更大元素 I
 * 给你两个 没有重复元素 的数组nums1 和nums2，其中nums1是nums2的子集。  请你找出 nums1中每个元素在nums2中的下一个比其大的值。
 * nums1中数字x的下一个更大元素是指x在nums2中对应位置的右边的第一个比x大的元素。如果不存在，对应位置输出 -1 。  来
 **/
public class NextGreaterElement {

    //暴力解法 时间复杂度O(mn) 空间复杂度O(n)
    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        int index = 0;
        for (int i = 0; i < nums1.length; i++) {
            int tmp = Integer.MAX_VALUE;
            boolean flag = true;
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] > tmp){
                    flag = false;
                    res[index++] = nums2[j];
                    break;
                }
                if (nums1[i] == nums2[j]){
                    tmp = nums1[i];
                }
            }
            if (flag){
                res[index++] = -1;
            }
        }

        return res;
    }

    //单调栈
    //首先思考暴力解法可以优化的地方 1. 每次在nums2找相同元素都需要重新遍历（这个通过哈希表可以解决） 2. 定位后找下一个更大元素也是通过遍历寻找的（单调栈）
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap();
        //先用单调栈计算出nums2的下一个更大元素
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()){
                stack.pop();
            }
            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            res[index++] = map.get(nums1[i]);
        }
        return res;
    }

}
