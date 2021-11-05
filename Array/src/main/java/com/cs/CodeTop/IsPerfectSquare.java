package com.cs.CodeTop;

/**
 * @program: CodeTop
 * @author: FreeThinking
 * @create: 2021-11-04 10:27
 * @description: 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。  进阶：不要 使用任何内置的库函数，如 sqrt **/
public class IsPerfectSquare {

    public static void main(String[] args) {
        IsPerfectSquare test = new IsPerfectSquare();
        boolean perfectSquare = test.isPerfectSquare(808201);
        System.out.println(perfectSquare);
    }

    public boolean isPerfectSquare(int num) {
        if(num == 1){
            return true;
        }
        int left = 1, right = num / 2;
        while(left <= right){
            int mid = left + (right - left) / 2;
            long tmp = (long)mid * mid;
            if(tmp == num){
                return true;
            }else if(tmp < num){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return false;
    }
}
