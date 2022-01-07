package com.cs.CodeTop;


/**
* 缺失第一个整数
 *
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
* */
public class FirstMissingPositive {

    /*
    * 不存在不修改原数组时间复杂度达到O(N)，空间O(1)的方法原数组未排序，
    * 所以借鉴时间复杂度O(N)，空间复杂度为O(N)的桶排序，因为借助了原数组，
    * 所以空间复杂度从O(N)降到O(1)
    * */
    //方法一 置换 将如果0<nums[i]<nums.length，将nums[i]放到对应位置nums[i] - 1
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1){
                return i + 1;
            }
        }
        return nums.length + 1;
    }
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    //方法二 标记法 将nums[i]对应位置的nums[i] - 1置为负数进行标记
    public int firstMissingPositive1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] <= 0){
                nums[i] = nums.length + 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if(num <= nums.length){
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0){
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,4,-1,1};
        FirstMissingPositive test = new FirstMissingPositive();
        int res = test.firstMissingPositive1(nums);
        System.out.println(res);
    }
}
