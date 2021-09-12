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
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp_i20 = 0,dp_i10 = 0;
        int dp_i21 = -prices[0],dp_i11 = -prices[0];
        for (int i = 1; i < n; i++) {
            for (int k = 2; k >= 1 ; k--) {

            }
        }
        return 0;
    }
}
