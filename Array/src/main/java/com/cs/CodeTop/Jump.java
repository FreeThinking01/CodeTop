package com.cs.CodeTop;

/**
 * @program: CodeTop
 * @author: FreeThinking
 * @create: 2021-10-18 21:12
 * @description:
 *
 * 给你一个非负整数数组nums ，你最初位于数组的第一个位置。  数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 假设你总是可以到达数组的最后一个位置。
 *
 **/
public class Jump {

    //贪心算法
    //需要同时维护两个变量，一个当前可到达的最大范围，一个下一步可到达最大范围
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1){
            return 0;
        }

        int curDistance = 0, maxDistance = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            maxDistance = Math.max(maxDistance, i + nums[i]);
            if (maxDistance >= nums.length - 1){
                count++;
                break;
            }
            if (i == curDistance){
                curDistance = maxDistance;
                count++;
            }
        }
        return count;
    }
}
