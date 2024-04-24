package 树.二叉树后序遍历;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public static class TreeNode{
        int val;
        TreeNode root;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int v){
            this.val = v;
        }
        TreeNode(int v,TreeNode l,TreeNode r){
            this.val = v;
            this.left = l;
            this.right = r;
        }
    }
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res_temp = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while(!stack.isEmpty() || root != null){
            while(root != null){
                res_temp.add(root.val);
                stack.push(root);
                root = root.right;
            }
            root = stack.pop();
            root = root.left;
        }
        for(int i = res_temp.size() - 1;  i >= 0; i --){
            res.add(res_temp.get(i));
        }
        return res;
    }
//    public void func(TreeNode root, List<Integer> res){
//        if(root == null)return;
//        func(root.left,res);
//        func(root.right,res);
//        res.add(root.val);
//    }
    public static void main(String[] args) {
        Solution.TreeNode root1 = new Solution.TreeNode(1);
        Solution.TreeNode root2 = new Solution.TreeNode(2);
        Solution.TreeNode root3 = new Solution.TreeNode(3);
        root1.left = null;
        root1.right = root2;
        root2.left = root3;
        root2.right = null;
        root3.left = null;
        root3.right = null;
        List<Integer> integers = Solution.postorderTraversal(root1);
    }
}
