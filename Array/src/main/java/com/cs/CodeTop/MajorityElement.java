package com.cs.CodeTop;


/**
 * 多数元素
 *
* 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
* */
public class MajorityElement {

    //摩尔投票
    public int majorityElement(int[] nums) {
        int res = Integer.MAX_VALUE;
        int votes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (votes == 0){
                res = nums[i];
            }
            if (nums[i] == res){
                votes++;
            }else {
                votes--;
            }
        }
        return res;
    }
}
