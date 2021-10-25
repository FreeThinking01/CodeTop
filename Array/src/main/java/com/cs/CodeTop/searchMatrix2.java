package com.cs.CodeTop;

/**
 * @program: CodeTop
 * @author: FreeThinking
 * @create: 2021-10-25 11:31
 * @description: 搜索二维矩阵Ⅱ
 * 写一个高效的算法来搜索mxn矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。 每列的元素从上到下升序排列。
 **/
public class searchMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1, colomn = 0;
        while (row >= 0 && colomn < matrix[0].length){
            if (matrix[row][colomn] == target){
                return true;
            }
            if (matrix[row][colomn] < target){
                colomn++;
            }else if (matrix[row][colomn] > target){
                row--;
            }
        }
        return false;
    }
}
