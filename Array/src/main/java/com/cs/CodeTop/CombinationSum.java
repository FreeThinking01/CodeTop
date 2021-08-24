package com.cs.CodeTop;


import java.util.ArrayList;
import java.util.List;

/**
 * 组合总和
 *
* 给定一个无重复元素的正整数数组candidates和一个正整数target，找出candidates中所有可以使数字和为目标数target的唯一组合。
 *
 * candidates中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。
 *
 * 对于给定的输入，保证和为target 的唯一组合数少于 150 个。
 *
* */
public class CombinationSum {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, 0);
        return res;
    }

    public void dfs(int[] candidates, int target, int index){
        //递归出口
        if (target < 0){
            return;
        }else if (target == 0){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            dfs(candidates, target - candidates[i], i);
            list.remove(list.size() - 1);
        }
    }
}
