package com.cs.CodeTop;


/**
 *在排序数组中查找元素的第一个和最后一个位置
 * 
 * 
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 *
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为O(log n)的算法解决此问题吗？
 *
* */
public class SearchRange {
    //二分
    public int[] searchRange(int[] nums, int target) {
        int left = getBinary(nums,target,true);
        int right = getBinary(nums,target,false);
        if (left >= nums.length || right < 0 || nums[left] != target){
            return new int[]{-1,-1};
        }
        return new int[]{left, right};
    }

    private int getBinary(int[] nums, int target, boolean flag) {
        int i = 0, j = nums.length - 1;
        while (i <= j){
            int mid = i + (j - i) / 2;
            if (nums[mid] == target){
                if (flag){
                    j = mid - 1;
                }else {
                    i = mid + 1;
                }
            }else if (nums[mid] < target){
                i = mid + 1;
            }else if (nums[mid] > target){
                j = mid - 1;
            }
        }

        return flag ? i : j;
    }

}
