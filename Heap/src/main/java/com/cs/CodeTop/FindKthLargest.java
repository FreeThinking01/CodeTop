package com.cs.CodeTop;

/**
 * @program: CodeTop
 * @author: FreeThinking
 * @create: 2021-10-26 11:07
 * @description: 数组中的第K个最大元素
 *
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。  请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素
 **/
public class FindKthLargest {

    //快排
    public int findKthLargest1(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, k);
    }

    private int quickSort(int[] nums, int left, int right, int k) {
        if (left >= right){
            return -1;
        }
        int j = partition(nums, left, right);
        if (k == j){
            return k;
        }else if (k < j){
            return quickSort(nums, left, j - 1, k);
        }else if (k > j){
            return quickSort(nums, j + 1, right, k);
        }

        return -1;
    }

    private int partition(int[] nums, int left, int right){
        int i = left, j = right + 1;
        while (true){
            while (nums[++i] < nums[left]){
                if (i == right){
                    break;
                }
            }
            while (nums[--j] > nums[left]){
                if (j == left){
                    break;
                }
            }
            if (i >= j){
                break;
            }
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
        int temp = nums[j];
        nums[j] = nums[left];
        nums[left] = temp;
        return j;
    }

    //优先队列 建堆然后输出k次
    public int findKthLargest2(int[] nums, int k) {
        int n = nums.length;
        //建堆
        for (int i = n / 2 - 1; i >= 0 ; i--) {
            adjustHeap(nums, i, n);
        }
        //调整堆
        for (int j = n - 1; j > n - k ; j--) {
            swap(nums, 0, j);
            adjustHeap(nums, 0, j);
        }
        return nums[0];
    }



    private void adjustHeap(int[] nums, int i, int n) {

        for (int k = i * 2 + 1; k < n; k = 2 * k + 1) {
            if (k < n - 1 && nums[k] < nums[k + 1]){
                k = k + 1;
            }
            if (nums[k] > nums[i]){
                swap(nums, k, i);
                i = k;
            }else {
                break;
            }
        }

    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


}
