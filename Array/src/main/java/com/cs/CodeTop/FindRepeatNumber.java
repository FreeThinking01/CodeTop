package com.cs.CodeTop;

/**
 * @program: CodeTop
 * @author: FreeThinking
 * @create: 2021-10-18 09:16
 * @description:
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些
 * 数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 **/
public class FindRepeatNumber {

    public static void main(String[] args) {
        FindRepeatNumber test = new FindRepeatNumber();
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        int repeatNumber = test.findRepeatNumber(nums);
        System.out.println(repeatNumber);

    }

    //其余方法略，使用交换
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (i != nums[i]){
                if (nums[i] == nums[nums[i]]){
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
        }
        return -1;
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
