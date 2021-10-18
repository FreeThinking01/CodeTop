package com.cs.CodeTop;

/**
 * @program: CodeTop
 * @author: FreeThinking
 * @create: 2021-09-26 14:38
 * @description: 统计一个数字在排序数组中出现的次数。
 **/
public class Search2 {

    //遍历 时间复杂度 O(n)
    public int search1(int[] nums, int target) {
        int res = 0;
        for(int num : nums){
            if (num == target){
                res++;
            }
        }
        return res;
    }

    /*二分 两种方法
    1.先二分找到target，从target为起点向两边寻找边界，缺点是不稳定，最坏时间复杂度为O(n)
    2.两次二分分别找到target左边界和右边界
    */
    public int search2(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        //先找左边界
        while (i <= j){
            int mid = i + (j - i) / 2;
            if (nums[mid] < target){
                i = mid + 1;
            }else if (nums[mid] >= target){
                j = mid - 1;
            }
        }
        int left = j;

        //再找右边界
        i = 0;
        j = nums.length - 1;
        while (i <= j){
            int mid = i + (j - i) / 2;
            if (nums[mid] <= target){
                i = mid + 1;
            }else if (nums[mid] > target){
                j = mid - 1;
            }
        }
        int right = i;
        return right - left - 1;
    }
}
