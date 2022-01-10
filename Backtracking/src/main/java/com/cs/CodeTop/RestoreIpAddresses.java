package com.cs.CodeTop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: CodeTop
 * @author: FreeThinking
 * @create: 2022-01-07 15:59
 * @description: 复原IP地址
 *
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入'.' 来形成。你不能重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 *
 *
 */
public class RestoreIpAddresses {

    ArrayList<String> res = new ArrayList<>();
    LinkedList<String> track = new LinkedList<>();
    int length;
    public List<String> restoreIpAddresses(String s) {
        this.length = s.length();
        if(length < 4 || length > 12){
            return res;
        }
        dfs(s, 0, 0);
        return res;
    }

    private void dfs(String s, int segment, int index) {
        //递归出口
        //1. 剩余数字超出范围
        if(length - index < 4 - segment || length - index > 3 * (4 - segment)){
            return;
        }
        //2. 符合条件
        if(index == length && segment == 4){
            res.add(String.join(".", track));
        }
        for(int i = 0; i < 3; i++){
            if(isValid(s, index, index + i)){
                track.add(s.substring(index, index + i + 1));
                dfs(s, segment + 1, index + i);
                track.removeLast();
            }
        }
    }

    private boolean isValid(String s, int left, int right) {
        if (right > length){
            return false;
        }
        String str = s.substring(left, right + 1);
        if(left < right && str.startsWith("0")){
            return false;
        }
        if(Integer.valueOf(str) > 255){
            return  false;
        }
        return true;
    }
}
