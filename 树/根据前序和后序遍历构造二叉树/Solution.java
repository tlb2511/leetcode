package 树.根据前序和后序遍历构造二叉树;

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
    public static TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int preSize = preorder.length;
        int postSize = postorder.length;
        if(preSize != postSize)return null;
        Map<Integer,Integer> map =new HashMap<>();
        for(int i = 0; i < postSize; i++){
            map.put(postorder[i],i);
        }
        return func(preorder,postorder,map,0,preSize-1,0,postSize-1);
    }
    static TreeNode func(int[] preorder, int[] postorder, Map<Integer,Integer> map, int prebegin, int preend, int postbegin, int postend){
        if(prebegin > preend || postbegin > postend)return null;
        TreeNode node = new TreeNode(preorder[prebegin]);
        if(preend - prebegin == 0)return node;
        int len = map.get(preorder[prebegin+1]) - postbegin;
        node.left = func(preorder,postorder,map,prebegin+1,prebegin+len+1,postbegin,postbegin+len);
        node.right = func(preorder,postorder,map,prebegin+len+2,preend,postbegin+len+1,postend-1);
        return node;
    }

    public static void main(String[] args) {
        int preorder[] = {1,2,4,5,3,6,7};
        int postorder[] = {4,5,2,6,7,3,1};
        TreeNode treeNode = constructFromPrePost(preorder, postorder);
    }
}
