package com.cs.CodeTop;


/**
* 不同路径
*
* 一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
*  机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
*  问总共有多少条不同的路径？
*
* */
public class UniquePaths {

    public static void main(String[] args) {
        UniquePaths test = new UniquePaths();
        int res = test.uniquePaths3(3,2);
        System.out.println(res);
    }

    //动态规划
    public int uniquePaths1(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    //组合数学 long也会溢出
    public int uniquePaths2(int m, int n) {
        int bigNum = m + n - 2;
        int smallNum = m - 1;
        long partation = 1;
        int tmp = bigNum;
        for (int i = 0; i < smallNum; i++){
            partation *= tmp;
            tmp--;
        }
        long partationM = 1;
        for (int i = smallNum; i >= 1; i--){
            partationM *= i;
        }
        return (int) (partation / partationM);
    }

    //组合数学 ** 大数溢出问题，通过每步都做除法解决
    public int uniquePaths3(int m, int n) {
        //int ans = 1; 这里不能使用int 因为ans * x可能会大数溢出
        long ans = 1;
        for (int x = n, y = 1; y < m; x++, y++) {
            //ans *= x / y; 这里不能使用复合表达式，因为这样会先算x/y，3/2 = 1
            ans = ans * x / y;
        }
        return (int) ans;
    }
}
