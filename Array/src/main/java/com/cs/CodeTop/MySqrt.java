package com.cs.CodeTop;

/**
 * @program: CodeTop
 * @author: FreeThinking
 * @create: 2021-12-24 15:09
 * @description: Sqrt(x)
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。  由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 **/
public class MySqrt {

    public static void main(String[] args) {
        MySqrt test = new MySqrt();
        int x = test.mySqrt(2147395599);
        System.out.println(x);
    }

    public int mySqrt(int x) {
        int left = 0, right = x, res = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            long num1 = (long)mid * mid;
            long num2 = (long)(mid + 1) * (mid + 1);
            if(x >= num1 && x < num2){
                res = mid;
            }else if(x >= num1){
                left = mid + 1;
            }else if(x < num2){
                right = mid - 1;
            }
        }

        return res;
    }
}
