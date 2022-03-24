package com.cs.CodeTop;

import java.util.Stack;

/**
 * @program: CodeTop
 * @author: FreeThinking
 * @create: 2022-03-13 16:39
 * @description:
 **/
public class decodeString {


    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c != ']'){
                stack.push(c);
            }else{
                StringBuilder sb = new StringBuilder();
                while(stack.peek() != '['){
                    sb.append(stack.pop());
                }
                stack.pop();
                StringBuilder tmp = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    tmp.insert(0 ,stack.pop());
                }
                int count = Integer.valueOf(tmp.toString());
                for(int k = 0; k < count; k++){
                    for(int j = sb.length() - 1; j >= 0; j--){
                        stack.push(sb.charAt(j));
                    }
                }
            }

        }
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }

}
