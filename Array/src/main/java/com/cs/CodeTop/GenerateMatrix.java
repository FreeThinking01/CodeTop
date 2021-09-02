package com.cs.CodeTop;

/**
 * @Auther: lishuaiyun
 * @Date: 2021/09/02/16:11
 * @Description: 螺旋矩阵II
 *
 * 给你一个正整数 n ，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 */
public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        int left = 0, right = n - 1, top = 0, below = n - 1;
        while (true){
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            top++;
            if (top >= n){
                break;
            }
            for (int i = top; i <= below; i++) {
                matrix[i][right] = num++;
            }
            right--;
            if (right < 0){
                break;
            }
            for (int i = right; i >= left; i--) {
                matrix[below][i] = num++;
            }
            below--;
            if (below < 0){
                break;
            }
            for (int i = below; i >= top; i--) {
                matrix[i][left] = num++;
            }
            left++;
            if(left >= n){
                break;
            }
        }
        return matrix;
    }
}
