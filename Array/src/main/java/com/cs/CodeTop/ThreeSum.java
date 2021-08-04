package com.cs.CodeTop;


import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * 
 *给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
* */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);
        for(int k = 0; k < nums.length - 2; k++){
            int i = k + 1, j = nums.length - 1;
            if(nums[k] > 0){
                break;
            }
            if (k > 0 && nums[k] == nums[k - 1]){
                continue;
            }
            while (i < j){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (i < j && nums[i] == nums[++i]);
                    while (i < j && nums[j] == nums[--j]);
                }else if (sum < 0){
                    while (i < j && nums[i] == nums[++i]);
                }else if (sum > 0){
                    while (i < j && nums[j] == nums[--j]);
                }
            }
        }
        return res;
    }
}
