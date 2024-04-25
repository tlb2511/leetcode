package 树.感染二叉树需要的总时间;

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
    public static int amountOfTime(TreeNode root, int start) {
        int res = 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> visit = new HashSet<>();

        func(root,map, -1);
        Deque<Integer> queue = new ArrayDeque<>();
        Set<Integer> ls = map.get(start);
        for(int k : ls){
            queue.addLast(k);
        }
        visit.add(start);
        while(!queue.isEmpty()){
            res++;
            int count = queue.size();
            for(int i = 0; i < count; i ++){
                int f = queue.removeFirst();
                if(!visit.contains(f)){
                    for (int k : map.get(f)) {
                        if(!visit.contains(k)){
                            queue.add(k);
                        }
                    }
                    visit.add(f);
                }
            }
        }
        return res;
    }
    static void func(TreeNode root, Map<Integer, Set<Integer>> map, int last){
        if(root == null)return;
        Set<Integer> curNode = new HashSet<>();
        if(last != -1){
            curNode.add(last);
        }
        if(root.left != null){
            curNode.add(root.left.val);
        }
        if(root.right != null){
            curNode.add(root.right.val);
        }
        map.put(root.val, curNode);
        func(root.left,map, root.val);
        func(root.right,map, root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        root.left = root2;
        root.right = root3;
        root2.left = root4;
        int i = amountOfTime(root, 3);
        System.out.println(i);
    }
}
