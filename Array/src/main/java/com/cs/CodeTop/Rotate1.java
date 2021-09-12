package com.cs.CodeTop;

/**
 * @Auther: lishuaiyun
 * @Date: 2021/09/05/19:30
 * @Description: 旋转数组
 *
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 */
public class Rotate1 {

    //利用环状替换 (index - 1 + k) % n
    //错误解法，因为回到初始位置 0 时，有些数字可能还没有遍历到，
    // 如nums = [1, 2, 3, 4, 5, 6]，k = 2
    public void rotate1(int[] nums, int k) {
        int n = nums.length;
        int fromIndex = 0, toIndex = (fromIndex - 1 + k) % n;
        int fromIdxNum = nums[fromIndex], toIdxNum = nums[toIndex];
        do {
            toIndex = (fromIndex - 1 + k) % n;
            toIdxNum = nums[toIndex];
            nums[toIndex] = fromIdxNum;
            fromIdxNum = toIdxNum;
            fromIndex = toIndex;
        }while (toIndex != 0);
    }

    //环状替换 修复上面的问题，外面加层循环，使用count标记访问过的元素数量
    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int stratIndex = i;
            int fromIndex = stratIndex, toIndex = (fromIndex+ k) % n;
            int fromIdxNum = nums[fromIndex], toIdxNum = nums[toIndex];
            do {
                toIndex = (fromIndex+ k) % n;
                toIdxNum = nums[toIndex];
                nums[toIndex] = fromIdxNum;
                fromIdxNum = toIdxNum;
                fromIndex = toIndex;
                count++;
                if (count == n){
                    return;
                }
            }while (toIndex != stratIndex);
        }

    }

    //数组翻转
    public void rotate3(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

}
