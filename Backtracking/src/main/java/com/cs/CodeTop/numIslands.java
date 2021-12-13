package com.cs.CodeTop;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: CodeTop
 * @author: FreeThinking
 * @create: 2021-12-13 11:12
 * @description: 岛屿数量
 * 给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。  此外，你可以假设该网格的四条边均被水包围。
 **/
public class numIslands {

    //深度优先搜索
    public int numIslands(char[][] grid) {
        int landsNums = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(dfs(grid, i, j)){
                    landsNums++;
                }
            }
        }
        return landsNums;
    }
    public boolean dfs(char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1'){
            return false;
        }
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        return true;
    }

    //广度优先搜索
    public int numIslands1(char[][] grid) {
        int landsNums = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(bfs(grid, i, j)){
                    landsNums++;
                }
            }
        }
        return landsNums;
    }

    private boolean bfs(char[][] grid, int i, int j) {
        if(grid[i][j] != '1'){
            return false;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int a = temp[0], b = temp[1];
            if(a >= 0 && a < grid.length && b >= 0 && b < grid[0].length && grid[a][b] == '1'){
                grid[a][b] = '0';
                queue.add(new int[]{a + 1, b});
                queue.add(new int[]{a - 1, b});
                queue.add(new int[]{a, b + 1});
                queue.add(new int[]{a, b - 1});
            }
        }

        return true;
    }


}
