package com.cs.CodeTop;

/**
 * @Auther: lishuaiyun
 * @Date: 2021/09/07/21:07
 * @Description: 剪绳子Ⅰ
 *
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的
 * 最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时
 * 得到的最大乘积是18。
 *
 */
public class CuttingRope {

    public static void main(String[] args) {
        CuttingRope test = new CuttingRope();
        int res = test.cuttingRope(10);
        System.out.println(res);
    }

    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n;i++){
            for(int j = 1; j < i; j++){
                dp[i] = Math.max(dp[i - j] * j, Math.max(j * (i - j), dp[i]));
            }
        }
        return dp[n];
    }
}
