package 树.二叉搜索树的范围和;

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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null)return 0;
        //if(root.val == low || root.val == high)return root.val;
        if(root.val > high){
            return rangeSumBST(root.left,low,high);
        }else if(root.val < low){
            return rangeSumBST(root.right,low,high);
        }
        return root.val + rangeSumBST(root.left,low,high) + rangeSumBST(root.right,low,high);
    }

}
