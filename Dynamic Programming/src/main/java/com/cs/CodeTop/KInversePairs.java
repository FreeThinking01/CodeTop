package com.cs.CodeTop;

/**
 * @program: CodeTop
 * @author: FreeThinking
 * @create: 2021-11-11 09:40
 * @description: K个逆序对数组
 **/
public class KInversePairs {

    public static void main(String[] args) {
        KInversePairs test = new KInversePairs();
        test.kInversePairs(3, 1);
    }

    public int kInversePairs(int n, int k) {
        //dp[i][j] i个数包含的j个逆序对数组个数
        if (k == 0){
            return 1;
        }
        int[][] dp = new int[n][k];
        dp[0][0] = 1;

        //状态转移方程
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                for (int t = 0; t <= i - 1; t++) {
                    dp[i][j] += j - t >= 0 ? dp[i - 1][j - t] : 0;
                }
            }
        }


        return dp[n - 1][k - 1];
    }
}
