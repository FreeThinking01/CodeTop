package com.cs.CodeTop;

import java.util.Arrays;

/**
 * @program: CodeTop
 * @author: FreeThinking
 * @create: 2021-12-23 14:16
 * @description: 最长递增子序列
 *
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 **/
public class LengthOfLIS {

    //动态规划 时间复杂度O(n^2)
    public int lengthOfLIS(int[] nums) {
        //以i结尾的最长递增长度
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxLength = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }

    //优化方法 时间复杂度O(nlog(n))
    public int lengthOfLIS1(int[] nums){

        return 0;
    }

}
