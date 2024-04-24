package 树.从中序与后序遍历序列构造二叉树;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static class TreeNode{
        int val;
        TreeNode root;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int v){
            this.val = v;
        }
        TreeNode(int v, TreeNode l, TreeNode r){
            this.val = v;
            this.left = l;
            this.right = r;
        }
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inSize = inorder.length;
        int postSize = postorder.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < inSize; i ++){
            map.put(inorder[i],i);
        }
        if(inSize != postSize)return null;
        return func(inorder,postorder,0,inSize-1,0,postSize-1,map);
    }
    TreeNode func(int[] inorder,int [] postorder,int inbegin,int inend,int postbengin,int postend,Map<Integer,Integer> map){
        if(inbegin > inend || postbengin > postend)return null;
        int value = postorder[postend];
        TreeNode root = new TreeNode(value);
        int index = map.get(value);
        int curSize = index - inbegin;
        root.left = func(inorder,postorder,inbegin,inbegin+curSize-1,postbengin,postbengin+curSize-1,map);
        root.right = func(inorder,postorder,index+1,inend,postbengin+curSize,postend-1,map);
        return root;
    }
}
