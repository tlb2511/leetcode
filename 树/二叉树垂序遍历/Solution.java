package 树.二叉树垂序遍历;

import java.lang.reflect.Array;
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
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> nodes = new ArrayList<int[]>();//nodes用来保存所有节点的row、col、value信息
        List<List<Integer>> ans = new ArrayList<>();
        func(root,0,0,nodes);//递归调用所有节点，并保存在nodes中
        Collections.sort(nodes, new Comparator<int[]>() {//自定义排序。首先排序col、接着排序row、最后排序value
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]){
                    return o1[0] - o2[0];
                }else if(o1[1] != o2[1]){
                    return o1[1] - o2[1];
                }else{
                    return o1[2] - o2[2];
                }
            }
        });
        int lastcol = Integer.MAX_VALUE;
        for(int i = 0; i < nodes.size(); i ++){//nodes节点都排好序，接下来挨个遍历元素，判断他们的col是不是相同的，如果是相同的，则放在一个list
            int[] temp = nodes.get(i);
            int val = temp[2];
            int row = temp[1];
            int col = temp[0];
            List<Integer> ls = new ArrayList<>();
            ls.add(val);
            if(col == lastcol){
                ans.get(ans.size()-1).add(val);
            }else{
                ans.add(ls);
                lastcol = col;
            }
        }
        return ans;
    }
    public static void func(TreeNode root, int row, int col, List<int[]> nodes){
        if(root == null)return;
        nodes.add(new int[]{col,row,root.val});
        func(root.left,row+1,col-1,nodes);
        func(root.right,row+1,col+1,nodes);
    }



    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        root1.left = null;
        root1.right = root2;
        root2.left = root3;
        root2.right = null;
        root3.left = null;
        root3.right = null;
        List<List<Integer>> lists = verticalTraversal(root1);

    }
}
