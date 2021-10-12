package com.cs.CodeTop;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: CodeTop
 * @author: FreeThinking
 * @create: 2021-09-23 10:30
 * @description: 数组中重复的数据
 *
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 *
 * 找到所有出现两次的元素。
 *
 * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 *
 **/
public class FindDuplicates {

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        FindDuplicates findDuplicates = new FindDuplicates();
        findDuplicates.findDuplicates1(nums);
    }

    //与之前的寻找重复数不同的是这次要找到所有重复数，所以有的方法还能用有的不行 二分不能用（目标值不止一个） 快慢指针（环不止一个）

    //方法1 利用数字和下标的关系交换 O(n),O(1)
    //这种方式会导致结果出现[3,3,2]的结果，需要去重，所以不要用这种方法
    public List<Integer> findDuplicates1(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while(nums[i] > 0){
                if (nums[nums[i] - 1] < 0){
                    res.add(nums[i]);
                    break;
                }else {
                    nums[i] = -nums[i];
                    swap(nums, i, -nums[i] - 1);
                }
            }
        }
        return res;
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    //方法2 哈希表 O(n),O(n)


    //方法3 访问标记法（原地Hash）
    public List<Integer> findDuplicates3(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0){
                res.add(Math.abs(nums[i]));
            }else {
                nums[index] = -nums[index];
            }
        }
        return res;
    }


}
