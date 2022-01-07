package com.cs.CodeTop;

/**
 * @program: CodeTop
 * @author: FreeThinking
 * @create: 2022-01-04 10:21
 * @description: 从前序与中序遍历序列构造二叉树
 *
 * 给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。
 **/
public class BuildTree {

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        BuildTree test = new BuildTree();
        test.buildTree(preorder, inorder);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }
        return buildBetweenTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    //重建指定索引区间的二叉树
    public TreeNode buildBetweenTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight){
        //递归出口
        if(preLeft > preRight || inLeft > inRight){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        for(int i = inLeft; i <= inRight; i++){
            if(inorder[i] == preorder[preLeft]){
                int leftTreeSize = i - inLeft;
                root.left = buildBetweenTree(preorder, inorder, preLeft + 1, preLeft + leftTreeSize, inLeft, i - 1);
                root.right = buildBetweenTree(preorder, inorder, preLeft + leftTreeSize + 1, preRight, i + 1, inRight);
            }
        }
        return root;
    }
}
