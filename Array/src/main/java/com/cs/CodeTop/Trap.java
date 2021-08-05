package com.cs.CodeTop;


/**
* 接雨水
 *[0,1,0,2,1,0,1,3,2,1,2,1]
* 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
* */
public class Trap {

    public int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int n = height.length;
        int res = 0;
        int[] left_max = new int[n];
        int[] right_max = new int[n];
        left_max[0] = height[0];
        //两个数组记录左侧最大值和右侧最大值
        for(int i = 1; i < n; i++){
            left_max[i] = Math.max(left_max[i - 1], height[i]);
        }
        right_max[n - 1] = height[n - 1];
        for(int j = n - 2; j >= 0; j--){
            right_max[j] = Math.max(right_max[j + 1], height[j]);
        }
        //计算结果
        for(int k = 1; k < n - 1; k++){
            res += Math.min(left_max[k], right_max[k]) - height[k];
        }
        return res;
    }

}
