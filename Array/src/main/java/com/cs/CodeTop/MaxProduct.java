package com.cs.CodeTop;

/**
 * @Auther: lishuaiyun
 * @Date: 2021/09/03/11:48
 * @Description: 乘积最大子数组
 *
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 */
public class MaxProduct {


    public int maxProduct1(int[] nums) {
        int n = nums.length;
        //因为有负数的存在，所以以i结尾的最大子数组乘积可能由最大值乘来，也可能由最小值得来
        //维护最大值和最小值
        int[] dpMax = new int[n];
        int[] dpMin = new int[n];
        int res = nums[0];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];

        for (int i = 1; i < n; i++) {
            //与nums[i]比较是防止前面的dpMax[i - 1]和dpMin[i - 1]为0
            dpMax[i] = Math.max(Math.max(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]), nums[i]);
            dpMin[i] = Math.min(Math.min(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]), nums[i]);
            res = Math.max(dpMax[i], res);
        }
        return res;
    }

    //优化下空间,数组改为滚动数组
    public int maxProduct2(int[] nums) {
        //以i位置的最大乘积
        int n = nums.length;
        //因为有负数的存在，所以以i结尾的最大子数组乘积可能由最大值乘来，也可能由最小值得来
        //维护最大值和最小值
        int preMax = nums[0];
        int preMin = nums[0];
        int res = nums[0];

        for (int i = 1; i < n; i++) {
            //与nums[i]比较是防止前面的dpMax[i - 1]和dpMin[i - 1]为0
            int dpMax = Math.max(Math.max(preMax * nums[i], preMin * nums[i]), nums[i]);
            int dpMin = Math.min(Math.min(preMax * nums[i], preMin * nums[i]), nums[i]);
            res = Math.max(dpMax, res);
            preMax = dpMax;
            preMin = dpMin;
        }
        return res;
    }
}
