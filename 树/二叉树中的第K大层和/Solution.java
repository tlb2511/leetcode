package 树.二叉树中的第K大层和;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

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
    public long kthLargestLevelSum(TreeNode root, int k) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        queue.addLast(root);
        while(!queue.isEmpty()){
            long ans = 0;
            int len = queue.size();
            for(int i = 0; i < len; i ++){
                TreeNode node = queue.removeFirst();
                ans += node.val;
                if(node.left != null){
                    queue.addLast(node.left);
                }
                if(node.right != null){
                    queue.addLast(node.right);
                }
            }
            priorityQueue.add(ans);
            if(priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }
        return priorityQueue.size() < k ? -1 : priorityQueue.peek();
    }
}
