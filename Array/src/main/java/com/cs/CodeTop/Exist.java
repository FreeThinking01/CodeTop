package com.cs.CodeTop;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: lishuaiyun
 * @Date: 2021/09/02/15:34
 * @Description: 单词搜索
 * 
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 */
public class Exist {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        //递归出口
        if (index == word.length()){
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)){
            return false;
        }
        //做选择
        char tmp = board[i][j];
        board[i][j] = '/';
        //递归
        if (dfs(board, word, i + 1, j, index + 1) || dfs(board, word, i, j + 1, index + 1)
        || dfs(board, word, i - 1, j, index + 1) || dfs(board, word, i, j - 1, index + 1)){
            return true;
        }
        //撤销选择
        board[i][j] = tmp;
        return false;
    }
}
