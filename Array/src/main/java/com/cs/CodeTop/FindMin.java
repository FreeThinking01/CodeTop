package com.cs.CodeTop;


/**
 * 寻找旋转排序数组中的最小值
 *
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
* */
public class FindMin {

    public int findMin(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j){
            int mid = i + (j - i) / 2;
            if (nums[mid] < nums[j]){
                j = mid;
            }else {
                i = mid + 1;
            }
        }
        return nums[j];
    }
}
