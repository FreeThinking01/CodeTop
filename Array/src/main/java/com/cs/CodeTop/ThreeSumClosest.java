package com.cs.CodeTop;

import java.util.Arrays;

/**
 * @author FreeThinking
 * @title: ThreeSumClosest
 * @projectName CodeTop
 * @date 2021/10/13 11:27
 * @description: 给定一个包括n 个整数的数组nums和 一个目标值target。找出nums中的三个整数，使得它们的和与target最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 */
public class ThreeSumClosest {


    //借鉴三数之和的算法
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        for (int k = 0; k < nums.length - 2; k++) {
            if (k > 0 && nums[k] == nums[k - 1]){
                continue;
            }
            int i = k + 1, j = nums.length - 1;
            while (i < j){
                int tmp = nums[k] + nums[i] + nums[j];
                if (tmp == target){
                    return target;
                }
                if (Math.abs(tmp - target) < Math.abs(closestSum - target)){
                    closestSum = tmp;
                }
                if (tmp > target){
                    while (i < j && (nums[j] == nums[--j]));
                }else if (tmp < target){
                    while (i < j && (nums[i] == nums[++i]));
                }
            }
        }

        return closestSum;
    }
}
