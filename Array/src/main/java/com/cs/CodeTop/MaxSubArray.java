package com.cs.CodeTop;


import java.util.HashMap;

/**
 * 最大子序和
 *
*给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
* */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();
        int sum = 0;
        //前缀和
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            map.put(i, sum);
        }
        int minSum = 0;
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            res = Math.max(res, map.get(i) - minSum);
            minSum = Math.min(minSum, map.get(i));
        }
        return res;
    }
}
