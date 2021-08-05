package com.cs.CodeTop;


import java.util.ArrayList;
import java.util.List;

/**
* 螺旋矩阵
 *
 *给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
* */
public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList();
        int left = 0, right = matrix[0].length - 1;
        int top = 0, below = matrix.length - 1;
        while (true){
            if(top <= below){
                for(int i = left; i <= right; i++){
                    list.add(matrix[top][i]);
                }
                top++;
            }else {
                break;
            }
            if(right >= left){
                for(int i = top; i <= below; i++){
                    list.add(matrix[i][right]);
                }
                right--;
            }else {
                break;
            }
            if(below >= top){
                for(int i = right; i >= left; i--){
                    list.add(matrix[below][i]);
                }
                below--;
            }else {
                break;
            }
            if(left <= right){
                for(int i = below; i >= top; i--){
                    list.add(matrix[i][left]);
                }
                left++;
            }else {
                break;
            }
        }
        return list;
    }
}
