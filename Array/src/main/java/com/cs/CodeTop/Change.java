package com.cs.CodeTop;

/**
 * @Auther: lishuaiyun
 * @Date: 2021/09/05/19:28
 * @Description: 零钱兑换Ⅱ
 *
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 *
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 *
 * 假设每一种面额的硬币有无限个。
 *
 * 题目数据保证结果符合 32 位带符号整数。
 */
public class Change {

    public int change(int amount, int[] coins) {
        int n = coins.length;
        //金额为amount的组合数
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {//硬币循环放在外面
            for (int j = 0; j < amount + 1; j++) {
                if (j >= i){
                    dp[j] += dp[j - coins[j]];
                }
            }
        }
        return dp[amount];
    }
}
