package com.cs.CodeTop;

/**
 * @program: CodeTop
 * @author: FreeThinking
 * @create: 2021-12-07 11:14
 * @description: 边界着色
 *
 * 给你一个大小为 m x n 的整数矩阵 grid ，表示一个网格。另给你三个整数row、col 和 color 。网格中的每个值表示该位置处的网格块的颜色。
 * 当两个网格块的颜色相同，而且在四个方向中任意一个方向上相邻时，它们属于同一 连通分量 。
 * 连通分量的边界 是指连通分量中的所有与不在分量中的网格块相邻（四个方向上）的所有网格块，或者在网格的边界上（第一行/列或最后一行/列）的所有网格块。
 * 请你使用指定颜色color 为所有包含网格块grid[row][col] 的 连通分量的边界 进行着色，并返回最终的网格grid 。
 * */

public class ColorBorder {

    //1.深度优先搜索

    /*
        与岛屿数量相似，但岛屿数量将访问过的置为‘0’标识访问过，但在此处不可行，因为访问过的元素需要具备两个信息：
        1. 需要着色的元素
        2. 访问过的元素
        所以不能使用一个标记表示两种信息，需要设置一个访问数组标识
    */
    boolean[][] visited = null;
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int target = grid[row][col];
        visited = new boolean[grid.length][grid[0].length];
        dfs(grid, row, col, color, target);
        return grid;
    }

    public boolean dfs(int[][] grid, int i, int j, int color, int target){

        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return true;
        }else if(visited[i][j]){
            return false;
        }else if(grid[i][j] != target){
            return true;
        }
        visited[i][j] = true;
        if(dfs(grid, i + 1, j, color, target) | dfs(grid, i - 1, j, color, target)
                | dfs(grid, i, j + 1, color, target) | dfs(grid, i, j - 1, color, target)){
            grid[i][j] = color;
        }
        return false;
    }

    //2.广度优先搜索





}