package 系统设计.在受污染的二叉树中查找元素;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

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
    class FindElements {
        //TreeNode root = new TreeNode();
        Set<Integer> ans = new HashSet<>();

        public FindElements(TreeNode root) {
            Deque<TreeNode> queue = new ArrayDeque<>();

            queue.addLast(root);
            //this.root.val = root.val;
            //TreeNode node = root;
            ans.add(root.val);
            while(!queue.isEmpty()){
                TreeNode temp = queue.removeFirst();
                if(temp.left != null){
                    queue.add(temp.left);
                    ans.add(2*temp.val+1);
                }
                if(temp.right != null){
                    queue.add(temp.left);
                    ans.add(2*temp.val+1);
                }
                //TreeNode node = new TreeNode(temp.val);
            }
        }

        public boolean find(int target) {
            return ans.contains(target);
        }
    }
}
