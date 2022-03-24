package com.cs.CodeTop;

import java.util.Arrays;

/**
 * @program: CodeTop
 * @author: FreeThinking
 * @create: 2022-03-24 17:25
 * @description:零钱兑换 II
 **/
public class CoinChange2 {

    public int change(int amount, int[] coins) {
        //使用前i种金币能凑出j的方案数
        int[][] dp = new int[coins.length + 1][amount + 1];
        //base case
        for(int i = 0; i <= coins.length; i++){
            dp[i][0] = 1;
        }
        for (int i = 1; i <= coins.length; i++) {
            for(int j = 1; j < amount + 1; j++){
                if (j - coins[i - 1] >= 0){
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }

        return dp[coins.length][amount];
    }

}
