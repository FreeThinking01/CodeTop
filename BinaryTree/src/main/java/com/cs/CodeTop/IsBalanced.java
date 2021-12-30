package com.cs.CodeTop;



/**
 * @program: CodeTop
 * @author: FreeThinking
 * @create: 2021-12-30 16:53
 * @description: 平衡二叉树
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 **/
public class IsBalanced {

    //前序递归
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    //返回指定节点深度
    public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    //优化方法 方法一中计算绝对值和子树isBalanced出现重复调用height
    //改为后序遍历
    public boolean isBalanced2(TreeNode root) {
        int height = height2(root);
        return height == -1 ? false : true;

    }

    //平衡返回深度，不平衡返回-1
    public int height2(TreeNode root){
        if(root == null){
            return 0;
        }
        int res = -1;
        int left = height2(root.left);
        int right = height2(root.right);
        if(left != -1 && right != -1 && Math.abs(left - right) <= 1){
            return Math.max(left, right) + 1;
        }
        return res;
    }

}
