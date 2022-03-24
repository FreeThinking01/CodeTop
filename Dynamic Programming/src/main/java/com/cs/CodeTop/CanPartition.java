package com.cs.CodeTop;

/**
 * @program: CodeTop
 * @author: FreeThinking
 * @create: 2022-03-24 16:24
 * @description: 分割等和子集
 **/
public class CanPartition {


    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        //如果可以划分，sum一定是偶数
        if(sum % 2 == 1){
            return false;
        }
        //0-1背包问题，背包容量为sum / 2
        sum = sum / 2;
        //dp数组 dp[i][j]为使用前i个数是否能凑成j
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        //base case
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= sum ; j++) {
                if(j - nums[i - 1] >= 0){
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }

        return dp[nums.length][sum];
    }


}
