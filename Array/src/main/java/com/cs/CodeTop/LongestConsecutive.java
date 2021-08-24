package com.cs.CodeTop;


import java.util.HashMap;
import java.util.HashSet;

/**
*最长连续序列
*
* 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。

请你设计并实现时间复杂度为O(n) 的算法解决此问题。
* */
public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : nums) {
            if (set.contains(num  - 1)) {
                continue;
            }
            int tmp = 1;
            while (set.contains(num + 1)){
                tmp++;
                num++;
            }
            res = Math.max(res,tmp);
        }
        return res;
    }
}
