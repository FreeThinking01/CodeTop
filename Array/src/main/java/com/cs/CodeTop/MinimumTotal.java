package com.cs.CodeTop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: CodeTop
 * @author: FreeThinking
 * @create: 2021-09-22 20:10
 * @description: 三角形最小路径和
 *
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 **/
public class MinimumTotal {

    public static void main(String[] args) {
        MinimumTotal test = new MinimumTotal();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(Arrays.asList(2)));
        triangle.add(new ArrayList<>(Arrays.asList(3,4)));
        triangle.add(new ArrayList<>(Arrays.asList(6,5,7)));
        triangle.add(new ArrayList<>(Arrays.asList(4,1,8,3)));
        test.minimumTotal2(triangle);
        System.out.println(test.minSum);
    }

    //DFS 可行 但会超时 无法通过全部测试用例 用反射可以得到提供triangle实现是arraylist，可以随机访问（triangle。getClass().getName()）
    int minSum = Integer.MAX_VALUE;
    int track = 0;
    public int minimumTotal1(List<List<Integer>> triangle) {
        dfs(triangle, 0, 0);
        return minSum;
    }

    private void dfs(List<List<Integer>> triangle, int i, int j) {
        //递归出口
        if (i == triangle.size()){
            if (track < minSum){
                minSum = track;
            }
            return;
        }
        int num = triangle.get(i).get(j);
        //选择
        track += num;
        //递归
        dfs(triangle, i + 1, j);
        dfs(triangle, i + 1, j + 1);
        //撤销
        track -= num;

    }

    
    //优化DFS，添加记忆化搜索
    Integer[][] memo;
    public int minimumTotal2(List<List<Integer>> triangle){
        memo = new Integer[triangle.size()][triangle.size()];
        return dfs2(triangle, 0, 0);
        
    }

    //（i,j）到底边最小和
    private int dfs2(List<List<Integer>> triangle, int i, int j) {
        //递归出口
        if (i == triangle.size()){
            return 0;
        }
        return Math.min(dfs2(triangle, i + 1, j + 1), dfs2(triangle, i + 1, j)) + triangle.get(i).get(j);
    }

    //动态规划 自顶向下 时间复杂度o(n^2) 空间复杂度o(n^2)
    public int minimumTotal3(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }

        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minSum = Math.min(dp[n - 1][i], minSum);
        }

        return minSum;
    }

    //动态规划 自底向上 时间复杂度o(n^2) 空间复杂度o(n^2) 最后不用遍历获得最小数,还能优化边界条件
    public int minimumTotal4(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) +  triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    ///动态规划 空间优化 时间复杂度o(n^2) 空间复杂度o(n) 因为dp只跟一层有关，滚动数组
    public int minimumTotal5(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) +  triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}
