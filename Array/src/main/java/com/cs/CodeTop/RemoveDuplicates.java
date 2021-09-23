package com.cs.CodeTop;

/**
 * @program: CodeTop
 * @author: FreeThinking
 * @create: 2021-09-22 10:06
 * @description: 删除有序数组中的重复项
 *
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * [0,0,1,1,1,2,2,3,3,4]
 *
 **/
public class RemoveDuplicates {


    //根据原地修改考虑使用交换的方法

    //使用填充
    public int removeDuplicates(int[] nums) {
        //两个指针，一个指针指向待填充，一个指向待扫描
        int index1 = 1, index2 = 1;
        //tmp为临时重复变量
        int tmp = nums[0];
        while (index2 < nums.length){
            while (index2 < nums.length && nums[index2] == tmp){
                index2++;
            }
            if (index2 != nums.length){
                nums[index1++] = nums[index2];
                tmp = nums[index2];
            }
        }
        return index1;
    }
}
