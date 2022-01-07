package com.cs.CodeTop;


import java.util.Arrays;

/**
*下一个排序
*
* 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须 原地 修改，只允许使用额外常数空间。

* */
public class NextPermutation {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2};
//        Arrays.sort(nums, 0, nums.length);

        NextPermutation test = new NextPermutation();
        test.nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    //使用了库函数
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        for(int i = n - 2; i >= 0; i--){
            if (nums[i] < nums[i + 1]){
                Arrays.sort(nums, i + 1, n);
                for (int k = i + 1; k < n; k++){
                    if(nums[k] > nums[i]){
                        swap(nums, i, k);
                        return;
                    }
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }

    //不使用库函数
    public void nextPermutation1(int[] nums) {
        int n = nums.length;
        for(int i = n - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                for (int j = n - 1; j > i ; j--) {
                    if(nums[j] > nums[i]){
                        swap(nums, i, j);
                        reverse(nums, i + 1, n - 1);
                        return;
                    }
                }
            }
        }
        //没找到，整体逆序，反转数组
        reverse(nums, 0, n - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while(left < right){
            swap(nums, left++, right--);
        }
    }
}
