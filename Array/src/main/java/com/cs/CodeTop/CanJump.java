package com.cs.CodeTop;

/**
 * @program: CodeTop
 * @author: FreeThinking
 * @create: 2021-09-16 20:13
 * @description: 跳跃游戏
 *
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标。
 **/
public class CanJump {

    public boolean canJump(int[] nums) {
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxLength >= i){
                maxLength = Math.max(maxLength, i + nums[i]);
            }
        }
        return maxLength >= nums.length - 1 ? true : false;
    }
}
