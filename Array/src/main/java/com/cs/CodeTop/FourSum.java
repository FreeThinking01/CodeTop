package com.cs.CodeTop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: CodeTop
 * @author: FreeThinking
 * @create: 2021-10-18 18:52
 * @description: 给你一个由 n 个整数组成的数组nums ，和一个目标值 target 。请你找出
 * 并返回满足下述全部条件且不重复的四元组[nums[a], nums[b], nums[c], nums[d]] ：
 * 0 <= a, b, c, d< n a、b、c 和 d 互不相同 nums[a] + nums[b] + nums[c] + nums[d] == target 你可以按 任意顺序 返回答案 。
 **/
public class FourSum {

    public static void main(String[] args) {
        FourSum test = new FourSum();
        int[] nums = {1,1,1,1};
        test.fourSum(nums, 4);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {

        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4){
            return res;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {

            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target){
                break;
            }
            if (nums[i] + nums[n - 1] + nums[n - 2]+ nums[n - 3] < target){
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target){
                    break;
                }
                if (nums[i] + nums[j] + nums[n - 1]+ nums[n - 2] < target){
                    continue;
                }

                int left = j + 1, right = nums.length - 1;
                while (left < right){
                    int tmp = nums[i] + nums[j] + nums[left] + nums[right];
                    if (tmp == target){
                        res.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while (left < right && nums[left] == nums[++left])
                        while (left < right && nums[right] == nums[--right]);
                    }else if (tmp < target){
                        left++;
                    }else if (tmp > target){
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
