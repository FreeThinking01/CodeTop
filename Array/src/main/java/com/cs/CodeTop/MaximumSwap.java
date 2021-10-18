package com.cs.CodeTop;


/**
*   最大交换
 *
 *   给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
* */
public class MaximumSwap {


    //暴力枚举
    //和 下一个最大数字 有点像，都是找逆序对交换
    //固定一位开始找最大逆序对交换 时间复杂度O(n^2) 空间复杂度O(1)
    public int maximumSwap1(int num) {
        String s = String.valueOf(num);
        char[] nums = s.toCharArray();

        for (int i = 0; i < nums.length - 1; i++) {
            int tmpIndex = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] > nums[i]){
                    tmpIndex = nums[j] >= nums[tmpIndex] ? j : tmpIndex;
                }
            }
            if (tmpIndex == i){
                continue;
            }else {
                swap(nums, i ,tmpIndex);
                return Integer.valueOf(String.valueOf(nums));
            }

        }

        return num;
    }

    private void swap(char[] nums, int i, int j) {
        char tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    //贪心算法
    public int maximumSwap2(int num) {
        String s = String.valueOf(num);
        char[] nums = s.toCharArray();
        //预处理
        int[] indexData = new int[10];
        for (int i = 0; i < nums.length; i++) {
            indexData[nums[i] - '0'] = i;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 9; j > nums[i] - '0' ; j--) {
                if (indexData[j] > i){
                    swap(nums, i, indexData[j]);
                    return Integer.valueOf(String.valueOf(nums));
                }
            }

        }
        return num;
    }
}
