package 树.二叉搜索树最近节点查询;

import sun.reflect.generics.tree.Tree;

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
//    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
//        List<List<Integer>> ans = new ArrayList<>();
//        Deque<TreeNode> stack = new ArrayDeque<>();
//        Map<Integer,List<Integer>> map = new HashMap<>();
//        Set<Integer> set = new HashSet<>();
//        for(int v : queries){
//            set.add(v);
//        }
//        TreeNode node = root;
//        while(!stack.isEmpty() || node != null){
//            while(node != null) {
//                int val = node.val;
//                if (set.contains(val)) {
//                    List<Integer> temp = new ArrayList<>();
//                    TreeNode leftMax = getLeftMax(node.left);
//                    if(leftMax == null){
//                        if(stack.isEmpty()){
//                            temp.add(-1);
//                        }else{
//                            temp.add(stack.getLast().val);
//                        }
//                    }else{
//                        temp.add(leftMax.val);
//                    }
//                    TreeNode rightMin = getRightMin(node.right);
//                    if(rightMin == null){
//                        if(stack.isEmpty()){
//                            temp.add(-1);
//                        }else{
//                            temp.add(stack.getLast().val);
//                        }
//                    }else{
//                        temp.add(rightMin.val);
//                    }
//                    map.put(val,temp);
//                    set.remove(node.val);
//                }
//                stack.addLast(node);
//                node = node.left;
//            }
//            node = stack.removeLast();
//            node = node.right;
//        }
//
//        for(int v : queries){
//            ans.add(map.get(v));
//        }
//        return ans;
//    }
//
//    public static TreeNode getRightMin(TreeNode root){
//        if(root == null)return null;
//        while(root.left != null){
//            root = root.left;
//        }
//        return root;
//    }
//    public static TreeNode getLeftMax(TreeNode root){
//        if(root == null)return null;
//        while(root.right != null){
//            root = root.right;
//        }
//        return root;
//    }

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while(!stack.isEmpty() || node != null){
            while(node != null){
                stack.addLast(node);
                node = node.left;
            }
            node = stack.removeLast();
            arr.add(node.val);
            node = node.right;
        }
        int len = arr.size();
        for(int v : queries){
            int r = findLowerBound(arr,v);
            if(r <= len && arr.get(r) == v){
                ans.add(Arrays.asList(v,v));
                continue;
            }
            int mx = r == len ? -1 : arr.get(r);
            int mn = -1;
            if(mx - 1 < 0){
                //mn = mx - 1;
                ans.add(Arrays.asList(-1,mx));
            }else{
                mn = mx - 1;
                ans.add(Arrays.asList(arr.get(mn),mx));
            }
        }
        return ans;
    }

    public static int findLowerBound(List<Integer> arr, int v){
        int l = -1, r = arr.size();
        //if(arr.get(0) > v)return -1;
        while(l + 1 < r){
            int m = (l + r) >>> 1;
            int num = arr.get(m);
            if(num >= v){
                r = m;
            }else{
                l = m;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1,2,4,6,9,13,14,15);
        int r = findLowerBound(arr,5);
        int l = findLowerBound(arr,5);
    }
}
