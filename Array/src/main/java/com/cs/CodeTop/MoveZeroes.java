package com.cs.CodeTop;

/**
 * @Auther: lishuaiyun
 * @Date: 2021/09/01/11:21
 * @Description: 移动零
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                nums[index++] = nums[i];
            }
        }
        while (index != nums.length){
            nums[index++] = 0;
        }
    }
}
