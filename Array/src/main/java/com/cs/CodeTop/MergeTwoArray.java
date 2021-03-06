package com.cs.CodeTop;

/**
* 合并两个有序数组
 *
* 给你两个有序整数数组nums1 和 nums2，请你将 nums2 合并到nums1中，使 nums1 成为一个有序数组。
 *
 * 初始化nums1 和 nums2 的元素数量分别为m 和 n 。你可以假设nums1 的空间大小等于m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 *
* */
public class MergeTwoArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        for (int k = m + n - 1; k >= 0; k--){
            if(i < 0){
                while (j >= 0){
                    nums1[k--] = nums2[j--];
                }
                break;
            }
            if (j < 0){
                break;
            }
            nums1[k] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
    }
}
