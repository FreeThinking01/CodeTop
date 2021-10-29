package com.cs.CodeTop;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @program: CodeTop
 * @author: FreeThinking
 * @create: 2021-10-28 09:56
 * @description: 重新排序得到 2 的幂
 *  给定正整数 N，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
 *  如果我们可以通过上述方式得到2 的幂，返回 true；否则，返回 false。
 **/
public class ReorderedPowerOf2 {

    //1. 搜索回溯+位运算

    //用于记录当前位置数字是否已经被访问
    boolean[] isVisited;

    public boolean reorderedPowerOf2(int n) {
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        this.isVisited = new boolean[chars.length];

        return backtrack(chars, 0, 0);
    }

    //前面已经确定，从index长度的数可否是2的幂 num是track
    private boolean backtrack(char[] chars, int index, int num) {
        //递归出口
        if (index == chars.length){
            return isPowerOfTwo(num);
        }


        for (int i = 0; i < chars.length; i++) {
            if (num == 0 && chars[i] == '0' || isVisited[i] || (i > 0 && isVisited[i - 1] && chars[i] == chars[i - 1])){
                continue;
            }
            //做选择
            isVisited[i] = true;
            //递归
            if (backtrack(chars, index + 1, num * 10 + (chars[i] - '0'))){
                return true;
            }
            //撤销选择
            isVisited[i] = false;
        }
        return false;
    }

    private boolean isPowerOfTwo(int num) {
        return (num & (num - 1)) == 0;
    }



    //2. 预处理+哈希表

    HashSet<String> set = new HashSet();

    public boolean reorderedPowerOf22(int n) {
        init();
        return set.contains(powerOf2Num(n));
    }

    private void init() {
        for (int i = 1; i <= 1e9; i <<= 1) {
            set.add(powerOf2Num(i));
        }
    }

    private String powerOf2Num(int n) {
        char[] count = new char[10];
        while (n != 0){
            count[n % 10]++;
            n /= 10;
        }

        return new String(count);
    }


}
