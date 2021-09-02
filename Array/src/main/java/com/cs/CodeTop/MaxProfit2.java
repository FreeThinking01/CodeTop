package com.cs.CodeTop;

/**
 * @Auther: lishuaiyun
 * @Date: 2021/09/02/11:17
 * @Description: 买卖股票的最佳时机
 * 给定一个数组 prices ，其中prices[i] 是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class MaxProfit2 {

    public int maxProfit(int[] prices) {
        //0是买入，1是卖出
        int dpi_0 = -prices[0];
        int dpi_1 = 0;
        for (int i = 1; i < prices.length; i++) {
            dpi_0 = Math.max(dpi_1 - prices[i], dpi_0);
            dpi_1 = Math.max(dpi_0 + prices[i], dpi_1);
        }
        return dpi_1;
    }
}
