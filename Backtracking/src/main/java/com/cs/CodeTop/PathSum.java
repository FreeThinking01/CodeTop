package com.cs.CodeTop;

import java.util.HashMap;

/**
 * @program: CodeTop
 * @author: FreeThinking
 * @create: 2022-01-09 17:26
 * @description: 路径总和3
 *
 * 给定一个二叉树的根节点 root，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 *
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 **/
public class PathSum {

    int sum = 0;
    //设置一个track作为前缀和
    HashMap<Integer, Integer> track = new HashMap<>();
    int preSum = 0;
    public int pathSum(TreeNode root, int targetSum) {
        track.put(0, 1);
        dfs(root, targetSum);
        return sum;
    }
    public void dfs(TreeNode root, int targetSum){
        if(root == null){
            return;
        }
        preSum += root.val;
        if(track.containsKey(preSum - targetSum)){
            sum += track.get(preSum - targetSum);
        }
        track.put(preSum, track.getOrDefault(preSum, 0) + 1);
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        track.put(preSum, track.get(preSum) - 1);
        preSum -= root.val;
    }
}
