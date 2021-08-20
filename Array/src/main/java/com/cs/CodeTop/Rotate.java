package com.cs.CodeTop;


/**
 * 旋转图像
 *
 * 给定一个 n×n 的二维矩阵matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 * 来
* */
public class Rotate {

    public static void main(String[] args) {
        Rotate test = new Rotate();
        test.rotate2(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }

    //旋转
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i++){
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = tmp;
            }
        }
    }

    //翻转 观察旋转方法内的matrix[i][j] = matrix[n - j - 1][i]方法可以拆解为两步
    //1.matrix[i][j] = matrix[i][n - j - 1] 2.matrix[i][n - j - 1] = matrix[n - j - 1][i]
    //先上下翻转再对角线翻转
    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        //上下翻转
        for(int i = 0; i < n / 2; i++){
            for (int j = 0; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = tmp;
            }
        }
        //对角线翻转
        for(int i = 0; i < n; i++){
            for (int j = 0; j <i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
