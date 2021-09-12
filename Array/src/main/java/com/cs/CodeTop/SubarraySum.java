package com.cs.CodeTop;

import java.util.HashMap;

/**
 * @Auther: lishuaiyun
 * @Date: 2021/09/07/12:15
 * @Description: 和为 K 的子数组
 *
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
 */
public class SubarraySum {

    public static void main(String[] args) {
        SubarraySum test=  new SubarraySum();
        int res = test.subarraySum(new int[]{1, 1, 1}, 2);
        System.out.println(res);

    }

    //前缀和
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> preSum = new HashMap();
        int sum = 0, res = 0;
        preSum.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)){
                res += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
