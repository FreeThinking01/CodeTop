package com.cs.CodeTop;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: CodeTop
 * @author: FreeThinking
 * @create: 2021-10-27 09:45
 * @description: 删除无效括号
 *
 * 给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。  返回所有可能的结果。答案可以按 任意顺序 返回。
 *
 * 输入：s = "()())()"
 * 输出：["(())()","()()()"]
 **/
public class removeInvalidParentheses {

    public static void main(String[] args) {
        String s = new String();
        s = "()())()";
        removeInvalidParentheses test = new removeInvalidParentheses();
        List<String> strings = test.removeInvalidParentheses(s);
        System.out.println(strings);
    }


    private int len;
    private char[] charArrays;
    Set<String> set = new HashSet<>();
    StringBuilder track = new StringBuilder();

    //什么是无效括号？
    //右括号左边没有多余的左括号
    public List<String> removeInvalidParentheses(String s) {
        this.len = s.length();
        this.charArrays = s.toCharArray();
        //先计算需要删除的括号
        int leftRemove = 0, rightRemove = 0;
        for (int i = 0; i < len; i++) {
            if (charArrays[i] == '('){
                leftRemove++;
            }else if (charArrays[i] == ')'){
                if (leftRemove == 0){
                    rightRemove++;
                }else {
                    leftRemove--;
                }
            }
        }

        dfs(0,0,0,leftRemove,rightRemove);

        return new ArrayList<>(set);
    }

    private void dfs(int index, int leftCount, int rightCount, int leftRemove, int rightRemove) {
        if (index == len){
            if (leftRemove == 0 && rightRemove == 0){
                set.add(track.toString());
            }
            return;
        }
        char character = charArrays[index];
        //剪枝
        if (character == '(' && leftRemove > 0){
            dfs(index + 1, leftCount, rightCount, leftRemove - 1, rightRemove);
        }else if (character == ')' && rightRemove > 0){
            dfs(index + 1, leftCount, rightCount, leftRemove, rightRemove - 1);
        }
        
        //递归
        //做选择
        track.append(character);
        //递归
        if(character != '(' && character != ')'){
            dfs(index + 1, leftCount, rightCount, leftRemove, rightRemove);
        }else if (character == '('){
            dfs(index + 1, leftCount + 1, rightCount, leftRemove, rightRemove);
        }else if (character == ')' && leftCount > rightCount){
            dfs(index + 1, leftCount, rightCount + 1, leftRemove, rightRemove);
        }
            //撤销
        track.deleteCharAt(track.length() - 1);
    }
}
