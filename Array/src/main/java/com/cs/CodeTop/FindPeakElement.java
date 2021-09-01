package com.cs.CodeTop;

/**
 * @Auther: lishuaiyun
 * @Date: 2021/09/01/9:44
 * @Description: 寻找峰值
 *
 * 峰值元素是指其值大于左右相邻值的元素。
 * 给你一个输入数组nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * 你可以假设nums[-1] = nums[n] = -∞ 。
 * 对于所有有效的 i 都有 nums[i] != nums[i + 1]
 *
 * 你可以实现时间复杂度为 O(logN) 的解决方案吗？
 */
public class FindPeakElement {
    //线性扫描 时间复杂度o(n)，空间复杂度o(1) 遍历的优点是找到升序对即可，因为找到的第一个升序对一定有nums[i] > nums[i - 1]
    public int findPeakElement1(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]){
                return i;
            }
        }
        return nums.length - 1;
    }

    //递归二分
    public int findPeakElement2(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    private int search(int[] nums, int i, int j) {
        if (i == j){
            return i;
        }
        int mid = i + (j - i) / 2;
        if (nums[mid] > nums[mid + 1]){
            return search(nums, i, mid);
        }
        return search(nums, mid + 1, j);
    }

    //迭代二分
    public int findPeakElement3(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j){
            int mid = i + (j - i) / 2;
            if (nums[mid] < nums[mid + 1]){
                i = mid + 1;
            }else if (nums[mid] > nums[mid + 1]){
                j = mid;
            }
        }
        return i;
    }
}
















