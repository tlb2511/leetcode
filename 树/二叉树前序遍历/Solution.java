package 树.二叉树前序遍历;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;



public class Solution {
    public static class TreeNode{
        int val;
        Solution.TreeNode root;
        Solution.TreeNode left;
        Solution.TreeNode right;
        TreeNode(){}
        TreeNode(int v){
            this.val = v;

        }
        TreeNode(int v, Solution.TreeNode l, Solution.TreeNode r){
            this.val = v;
            this.left = l;
            this.right = r;
        }
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> sk = new Stack<>();
        TreeNode temp = root;
        while(!sk.empty() || temp != null){
            while(temp != null){
                sk.push(temp);
                res.add(temp.val);
                temp = temp.left;
            }
            temp = sk.peek();
            sk.pop();
            temp = temp.right;
        }
        return res;
    }

//    public static void main(String[] args) {
//        TreeNode root1 = new TreeNode(1);
//        TreeNode root2 = new TreeNode(2);
//        TreeNode root3 = new TreeNode(3);
//        root1.left = null;
//        root1.right = root2;
//        root2.left = root3;
//        root2.right = null;
//        root3.left = null;
//        root3.right = null;
//        List<Integer> integers = preorderTraversal(root1);
//    }
}

