package 树.从前序与中序遍历序列构造二叉树;

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preSize = preorder.length;
        int inSize = inorder.length;
        if(preSize != inSize)return null;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i <inorder.length; i ++){
            map.put(inorder[i],i);
        }
        return func(preorder,inorder,map,0,preSize-1,0,inSize-1);
    }
    TreeNode func(int[] preorder, int[] inorder, Map<Integer,Integer> map, int prebegin, int preend, int inbegin, int inend){
        if(prebegin > preend || inbegin > inend)return null;
        int val = preorder[prebegin];
        int index = map.get(val);
        int size = index - inbegin;
        TreeNode root = new TreeNode(val);
        root.left = func(preorder,inorder,map,prebegin+1,prebegin+size,inbegin,inbegin+size-1);
        root.right = func(preorder,inorder,map,prebegin+size+1,preend,inbegin+size+1,inend);
        return root;
    }
}
