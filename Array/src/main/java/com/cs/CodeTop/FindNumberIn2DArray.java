package com.cs.CodeTop;

/**
 * @program: CodeTop
 * @author: FreeThinking
 * @create: 2021-09-22 10:22
 * @description: 二维数组中的查找
 *
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 **/
public class FindNumberIn2DArray {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int row = matrix.length - 1, column = 0;
        while (row >= 0 && column < matrix[0].length){
            if (matrix[row][column] == target){
                return true;
            }else if (matrix[row][column] < target){
                column++;
            }else {
                row--;
            }
        }
        return false;
    }
}
