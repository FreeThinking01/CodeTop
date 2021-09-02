package com.cs.CodeTop;

/**
 * @Auther: lishuaiyun
 * @Date: 2021/09/02/15:56
 * @Description: 长度最小的子数组
 *
 * 给定一个含有n个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 */
public class MinSubArrayLen {
    //连续子数组，滑动窗口
    public int minSubArrayLen(int target, int[] nums) {
        //使用双指针作为动态窗口
        int left = 0, right = -1;
        //使用一个变量记录当前窗口和
        int sum = 0, res = Integer.MAX_VALUE;
        while (right < nums.length - 1){
            //扩大窗口
            right++;
            sum += nums[right];

            //缩小窗口
            while (sum >= target){
                res = Math.min(right - left + 1, res);
                sum -= nums[left];
                left++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
