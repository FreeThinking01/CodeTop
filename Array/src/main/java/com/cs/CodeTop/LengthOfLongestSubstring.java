package com.cs.CodeTop;

import java.util.HashMap;

/**
 * @program: CodeTop
 * @author: FreeThinking
 * @create: 2021-12-02 16:22
 * @description: 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 **/
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        LengthOfLongestSubstring test = new LengthOfLongestSubstring();
        int pwwkew = test.lengthOfLongestSubstring("pwwkew");
        System.out.println(pwwkew);
    }

    //滑动窗口
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0, right = -1;
        int n = s.length();
        while(right < n - 1){
            right++;
            window.put(chars[right], window.getOrDefault(chars[right], 0) + 1);
            while(window.get(chars[right]) > 1){
                window.put(chars[left], window.get(chars[left]) - 1);
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

}
