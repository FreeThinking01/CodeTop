package com.cs.CodeTop;

import java.util.Arrays;

/**
 * @program: CodeTop
 * @author: FreeThinking
 * @create: 2021-10-18 20:58
 * @description: 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 **/
public class TriangleNumber {

    //暴力解法 时间复杂度O(n^3) 空间复杂度log(n)
    public int triangleNumber(int[] nums) {
        if (nums.length < 3){
            return 0;
        }
        int count = 0;
        //这里排序需要log(n)空间
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] < nums[k]){
                        count++;
                    }
                }
            }
        }

        return count;
    }


    //排序 + 二分 时间复杂度O(n^2O(log(n))) 空间复杂度log(n)
    public int triangleNumber1(int[] nums) {
        if (nums.length < 3){
            return 0;
        }
        int count = 0;
        //这里排序需要log(n)空间
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int left = j + 1, right = nums.length - 1;
                while (left <= right){
                    int mid = left + (right - left) / 2;
                    if (nums[i] + nums[j] > nums[mid]){
                        left = mid + 1;
                    }else {
                        right = mid - 1;
                    }
                }
                count += (left - j - 1);
            }
        }

        return count;
    }

    //排序 + 双指针 时间复杂度O(n^2)) 空间复杂度log(n)
    public int triangleNumber2(int[] nums) {
        if (nums.length < 3){
            return 0;
        }
        int count = 0;
        //这里排序需要log(n)空间
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int k = i;
            for (int j = i + 1; j < nums.length - 1; j++) {
                //注意k在j内没有重置 所以总体时间复杂度O（n^3）
                while (k <= nums.length - 1 && nums[i] + nums[j] > nums[k]){
                    k++;
                }
                count += Math.max(k - j - 1, 0);
            }
        }


        return count;
    }
}
