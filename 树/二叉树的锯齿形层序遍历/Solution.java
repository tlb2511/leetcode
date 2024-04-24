package 树.二叉树的锯齿形层序遍历;

import java.util.*;

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
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)return ans;
        Deque<TreeNode> deque = new ArrayDeque<>();
        int len = 1;
        int count = 0;
        deque.addLast(root);
        Boolean flag = true;
        while(!deque.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < len; i ++){
                TreeNode node = deque.getFirst();
                deque.pop();
                temp.add(node.val);
                if(node.left != null){
                    count++;
                    deque.addLast(node.left);
                }
                if(node.right != null){
                    count++;
                    deque.addLast(node.right);
                }
            }
            len = count;
            count = 0;
            if(flag == false){
                Collections.reverse(temp);
            }
            ans.add(temp);
            flag = !flag;
        }
        return ans;
    }
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        root1.left = root4;
        root1.right = root2;
        root2.left = root3;
        root2.right = null;
        root3.left = null;
        root3.right = null;
        List<List<Integer>> lists = zigzagLevelOrder(root1);
    }
}
