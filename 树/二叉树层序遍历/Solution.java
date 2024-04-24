package 树.二叉树层序遍历;

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
//    public static List<List<Integer>> levelOrder(TreeNode root) {
//        if(root == null)return null;
//        List<List<Integer>> ans = new ArrayList<>();
//        int len = 1;
//        Deque<TreeNode> deque = new ArrayDeque<>();
//        deque.push(root);
//        int count = 0;
//        while(!deque.isEmpty()){
//            count = 0;
//            List<Integer> temp = new ArrayList<>();
//            for(int i = 0; i < len; i ++){
//                TreeNode pop = deque.removeFirst();
//                //TreeNode pop = deque.pop();
//                temp.add(pop.val);
//                if(pop.left != null){
//                    count++;
//                    deque.addLast(pop.left);
//                }
//                if(pop.right != null){
//                    count++;
//                    deque.addLast(pop.right);
//                }
//            }
//            len = count;
//            ans.add(temp);
//        }
//        return ans;
//    }
    public static List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)return ans;
        List<int[]> nodes = new ArrayList<>();
        func(root,0,nodes);
        Collections.sort(nodes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int lastrow = Integer.MAX_VALUE;
        for(int i = 0; i < nodes.size(); i ++){
            int[] temp = nodes.get(i);
            int row = temp[0];
            int val = temp[1];
            if(lastrow == row){
                ans.get(ans.size()-1).add(val);
            }else{
                List<Integer> ls = new ArrayList<>();
                ls.add(val);
                ans.add(ls);
            }
            lastrow = row;
        }
        Collections.reverse(ans);
        return ans;
    }
    public static void func(TreeNode root, int row, List<int[]> nodes){
        if(root == null)return;
        nodes.add(new int[]{row,root.val});
        func(root.left,row+1,nodes);
        func(root.right,row+1,nodes);
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
        List<List<Integer>> lists = levelOrder(root1);
    }
}
