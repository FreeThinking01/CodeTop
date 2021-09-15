package com.cs.CodeTop;


/**
 * @program: CodeTop
 * @author: FreeThinking
 * @create: 2021-09-15 11:16
 * @description: 给定一个包含n + 1 个整数的数组nums ，其数字都在 1 到 n之间（包括 1 和 n），可知至少存在一个重复的整数。
 *
 * 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
 *
 * 你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。
 **/
public class FindDuplicate {

    public static void main(String[] args) {
        FindDuplicate test = new FindDuplicate();
        test.findDuplicate1(new int[]{2,3,3,4,3});
    }

    //原地置换
    public int findDuplicate1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            //必须是while不能是if
            while (nums[i] - 1 != i){
                if (nums[i] == nums[nums[i] - 1]){
                    return nums[i];
                }else {
                    int tmp = nums[nums[i] - 1];
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = tmp;
                }

            }
        }
        return -1;
    }

    //二分法
    public int findDuplicate2(int[] nums) {
        return 0;
    }

    //二进制

    //快慢指针
}
