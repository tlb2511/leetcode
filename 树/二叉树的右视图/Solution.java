package 树.二叉树的右视图;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        if(root == null)return ans;
        int len = 1;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        int count = 0;
        while(!deque.isEmpty()){
            int nodeVal = 0;
            for(int i = 0; i < len; i ++){
                TreeNode pop = deque.removeFirst();
                if(i == len - 1) {
                    nodeVal = pop.val;
                }
                if(pop.left != null){
                    count++;
                    deque.addLast(pop.left);
                }
                if(pop.right != null){
                    count++;
                    deque.addLast(pop.right);
                }
            }
            len = count;
            count = 0;
            ans.add(nodeVal);
        }
        return ans;
    }
}
