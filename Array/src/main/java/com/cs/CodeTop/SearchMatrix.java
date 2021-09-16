package com.cs.CodeTop;

/**
 * @Auther: lishuaiyun
 * @Date: 2021/09/10/15:56
 * @Description: 搜索二维矩阵
 *
 * 编写一个高效的算法来判断m x n矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 */
public class SearchMatrix {

    //移动坐标轴 时间复杂度 O(m+n)
    public boolean searchMatrix1(int[][] matrix, int target) {
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

    //二分解法 先用二分找到所在行，再在该列二分找数 时间复杂度O(log(m + n))
    public boolean searchMatrix2(int[][] matrix, int target) {
        int top = 0, below = matrix.length - 1;
        while (top < below){
            int mid = top + (below - top + 1) / 2;
            if (matrix[mid][0] <= target){
                top = mid;
            }else if (matrix[mid][0] > target){
                below = mid - 1;
            }
        }
        int left = 0, right = matrix[0].length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (target  ==  matrix[top][mid]){
                return true;
            }else if (target > matrix[top][mid]){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return false;
    }

    //一次二分
    public boolean searchMatrix3(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (matrix[mid / n][mid % n] == target){
                return true;
            }else if (matrix[mid / n][mid % n] < target){
                left++;
            }else {
                right--;
            }
        }
        return false;
    }

}
