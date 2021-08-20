package com.cs.CodeTop;


/**
* 寻找两个有序数组的中位数
 *
* 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 进阶要求时间复杂度O(log(m+n))
* */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        FindMedianSortedArrays test = new FindMedianSortedArrays();
        double res = test.findMedianSortedArrays2(nums1, nums2);
        System.out.println(res);

    }

    //归并 时间复杂度O(m+n)，空间复杂度O(m+n)
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int[] nums = new int[n1 + n2];
        int i = 0, j = 0,k = 0;
        while (i < n1 && j < n2){
            if (nums1[i] < nums2[j]){
                nums[k++] = nums1[i++];
            }else {
                nums[k++] = nums2[j++];
            }
        }
        if (i == n1){
            while (j != n2)
            nums[k++] = nums2[j++];
        }
        if (j == n2){
            while (i != n1)
            nums[k++] = nums1[i++];
        }
        return nums.length % 2 == 0 ? (nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2.0 : nums[nums.length / 2];
    }


    /*
    * 找到中位数位置 时间复杂度O(m+n)，空间复杂度O(1)
    *
    * 不需要合并两个有序数组，只要找到中位数的位置即可。由于两个数组的长度已知，因此中位数对应的两个数组的下标之和也是已知的。
    * 维护两个指针，初始时分别指向两个数组的下标 0 的位置，每次将指向较小值的指针后移一位（如果一个指针已经到达数组末尾，则
    * 只需要移动另一个数组的指针），直到到达中位数的位置。
    * */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int i = -1, j = -1, n = n1 + n2;
        int midNumIdx = n / 2;
        int res = 0, preRes = 0;
        for (int k = 0; k <= midNumIdx; k++){
            if (j == n2 - 1 || (i < n1 - 1 && nums1[i + 1] < nums2[j + 1])){
                i++;
                preRes = res;
                res = nums1[i];
            }else {
                j++;
                preRes = res;
                res = nums2[j];
            }
        }
        return n % 2 == 0 ? (res + preRes) / 2.0 : res;
    }

    /*
     * 进阶要求是时间复杂度O(log(m+n)),涉及到log考虑二分查找
     * 二分查找 O(log(m+n)),空间复杂度O(1)
     * */
    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        return 0;
    }

    /*
     * 划分数组
     * */
    public double findMedianSortedArrays4(int[] nums1, int[] nums2) {
        return 0;
    }
}
