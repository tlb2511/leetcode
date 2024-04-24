package 树.二叉树的层平均值;

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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if(root == null)return ans;
        int len = 1;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        int count = 0;
        while(!deque.isEmpty()){
            count = 0;
            Double sum = 0.0;
            for(int i = 0; i < len; i ++){
                TreeNode pop = deque.removeFirst();
                sum += pop.val;
                if(pop.left != null){
                    count++;
                    deque.addLast(pop.left);
                }
                if(pop.right != null){
                    count++;
                    deque.addLast(pop.right);
                }
            }
            Double res = sum/len;
            len = count;
            count = 0;
            ans.add(res);
        }
        return ans;
    }
}
