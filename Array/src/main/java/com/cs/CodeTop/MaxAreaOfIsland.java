package com.cs.CodeTop;

/**
 * @Auther: lishuaiyun
 * @Date: 2021/09/01/11:37
 * @Description: 岛屿的最大面积
 * <p>
 * 给定一个包含了一些 0 和 1 的非空二维数组grid 。
 * <p>
 * 一个岛屿是由一些相邻的1(代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设grid 的四个边缘都被 0（代表水）包围着。
 * <p>
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
 */
public class MaxAreaOfIsland {

    int list = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                list = 0;
                dfs(grid, i, j);
                maxArea = Math.max(maxArea, list);
            }
        }
        return maxArea;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return;
        }
        list++;
        grid[i][j] = -1;
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);

    }
}
