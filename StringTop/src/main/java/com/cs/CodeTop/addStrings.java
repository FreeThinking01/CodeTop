package com.cs.CodeTop;

/**
 * @program: CodeTop
 * @author: FreeThinking
 * @create: 2021-12-13 10:31
 * @description: 字符串相加
 * 给定两个字符串形式的非负整数num1 和num2，计算它们的和并同样以字符串形式返回。
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger），也不能直接将输入的字符串转换为整数形式。
 **/
public class addStrings {

    public static void main(String[] args) {
        addStrings test = new addStrings();
        test.addStrings("11", "123");
    }

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int add = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        int n = Math.max(i, j);
        int num = 0;
        for(int k = n; k >= 0; k--){
            if(i == -1){
                num = (int)num2.charAt(j--) + add;
            }else if(j == -1){
                num = (int)num1.charAt(i--) + add;
            }else{
                System.out.println((int)num1.charAt(i));
                num = (int)num1.charAt(i--) + (int)num2.charAt(j--) + add;
            }
            add = num / 10;
            int temp = num % 10;
            sb.append(temp);
        }
        if(add != 0){
            sb.append(add);
        }
        return sb.reverse().toString();
    }
}
