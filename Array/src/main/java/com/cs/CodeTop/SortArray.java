package com.cs.CodeTop;

/**
 * @program: CodeTop
 * @author: FreeThinking
 * @create: 2021-12-03 10:51
 * @description: 将数组按照升序排列
 **/
public class SortArray {

    public static void main(String[] args) {
        SortArray test = new SortArray();
        int[] nums = {5,2,3,1};
        test.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    //归并排序
    int[] aux = null;
    public void sort(int[] nums){
        aux = new int[nums.length];
        sortArray(nums, 0, nums.length - 1);
    }

    private void sortArray(int[] nums, int left, int right) {
        if (left < right){
            int mid = left + (right - left) / 2;
            sortArray(nums, left, mid);
            sortArray(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int i = left, j = mid + 1;
        //复制数组
        for (int k = left; k <= right; k++) {
            aux[k] = nums[k];
        }
        for (int k = left; k <= right; k++) {
            if (i > mid){
                nums[k] = aux[j++];
            }else if (j > right){
                nums[k] = aux[i++];
            }else if (nums[i] <= nums[j]){
                nums[k] = nums[i++];
            }else {
                nums[k] = nums[j++];
            }
        }
    }


}
