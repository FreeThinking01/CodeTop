package com.cs.CodeTop;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @program: CodeTop
 * @author: FreeThinking
 * @create: 2021-11-05 10:00
 * @description: 最长定差子序列长度
 *
 * 给你一个整数数组arr和一个整数difference，请你找出并返回 arr中最长等差子序列的长度，该子序列中相邻元素之间的差等于 difference 。
 * 子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。
 **/
public class LongestSubsequence {

    public static void main(String[] args) {
        LongestSubsequence test = new LongestSubsequence();
        int[] nums = {1,5,7,8,5,3,4,2,1};
        int res = test.longestSubsequence2(nums, -2);
        System.out.println(res);
    }

    //dp定义为以i结尾的最长定差子序列长度
    public int longestSubsequence1(int[] arr, int difference) {
        int n = arr.length;
        int res = 0;
        //hashmap快速索引元素位置
        HashMap<Integer, Integer> map = new HashMap<>();

        //dp[i]以i结尾的最长定差子序列长度
        int[] dp = new int[n];
        //base case
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i] - difference)){
                dp[i] = dp[map.get(arr[i] - difference)] + 1;
            }
            map.put(arr[i], i);
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    //优化 dp 定位为以arr[i]结尾的最长定差子序列长度
    public int longestSubsequence2(int[] arr, int difference) {
        int n = arr.length;
        int res = 0;
        //hashmap<arr[i],以arr[i]结尾的最长定差子序列长度>
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            System.out.println(map.get(arr[i] - difference));
            map.put(arr[i], map.getOrDefault(arr[i] - difference, 0) + 1);
            res = Math.max(res, map.get(arr[i]));
        }

        return res;
    }


}
