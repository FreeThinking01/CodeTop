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

    //与之前的寻找重复数不同的是这次要找到所有重复数，所以有的方法还能用有的不行 二分不能用（目标值不止一个） 快慢指针（环不止一个）

    //方法1 利用数字和下标的关系交换 O(n),O(1)
    public List<Integer> findDuplicates1(int[] nums) {
        List<Integer> res = new ArrayList<>();

        return res;
    }

    //方法2 哈希表 O(n),O(n)

    //方法3 标记法
    public List<Integer> findDuplicates3(int[] nums) {
        List<Integer> res = new ArrayList<>();

        return res;
    }
    //方法4 原地hash
    public List<Integer> findDuplicates4(int[] nums) {
        List<Integer> res = new ArrayList<>();

        return res;
    }

    //二进制异或 数组元素可能有0所以不行

}
