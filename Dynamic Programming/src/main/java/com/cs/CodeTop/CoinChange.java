package com.cs.CodeTop;

import java.util.Arrays;

/**
 * @program: CodeTop
 * @author: FreeThinking
 * @create: 2022-03-24 17:10
 * @description: 零钱兑换
 **/
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        //dp[i] 金额为i的最少硬币个数
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int i = 0; i <= amount; i++){
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }

            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

}
