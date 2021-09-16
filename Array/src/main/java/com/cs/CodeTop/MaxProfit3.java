package com.cs.CodeTop;

/**
 * @Auther: lishuaiyun
 * @Date: 2021/09/09/16:05
 * @Description: 买卖股票的最佳时机 III
 *
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成两笔交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 */
public class MaxProfit3 {

    public static void main(String[] args) {
        MaxProfit3 test = new MaxProfit3();
        int res = test.maxProfit(new int[]{1, 2, 3, 4, 5});
        System.out.println(res);
    }

    //动态规划
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max_k = 2;
        //dp[i][k][flag]第i天已经使用k次交易机会持有/不持有的最大利润
        int[][][] dp = new int[n][max_k + 1][2];
        int res = 0;
        //base case 0是持有，1是不持有
        for (int k = 0; k < 3; k++) {
            dp[0][k][0] = -prices[0];
            dp[0][k][1] = 0;
        }
        for (int i = 1; i < n; i++) {
            for (int k = 1; k <= max_k; k++) {
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k - 1][1] - prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k][0] + prices[i]);
            }
        }
        return dp[n - 1][2][1];
    }

    //滚动数组 优化空间
    public int maxProfit2(int[] prices) {
        int dp_i10 = 0, dp_i11 = Integer.MIN_VALUE;
        int dp_i20 = 0, dp_i21 = Integer.MIN_VALUE;
        for (int price : prices) {
            dp_i20 = Math.max(dp_i20, dp_i21 + price);
            dp_i21 = Math.max(dp_i21, dp_i10 - price);
            dp_i10 = Math.max(dp_i10, dp_i11 + price);
            dp_i11 = Math.max(dp_i11, -price);
        }
        return dp_i20;
    }

}
