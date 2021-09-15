package com.cs.CodeTop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//组合总和Ⅱ
public class CombinationSum2 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs1(candidates, target, 0);
        return res;
    }

    private void dfs1(int[] candidates, int target, int index) {
        if (target == 0) {
            res.add(new ArrayList(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            dfs1(candidates, target - candidates[i], i + 1);
            list.remove(list.size() - 1);
        }
    }
}
