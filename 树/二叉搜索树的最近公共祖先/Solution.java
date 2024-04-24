package 树.二叉搜索树的最近公共祖先;

import java.util.ArrayList;
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
    //方法1 记录每个节点到P，Q节点的距离，找到最小值即为结果
//    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if(root == null)return null;
//        TreeNode ans = new TreeNode(root.val);
//        dfs(root,p,q,ans,Integer.MAX_VALUE);
//        return ans;
//    }
//    public static void dfs(TreeNode root, TreeNode p, TreeNode q, TreeNode ans, int len){
//        if(root == null)return;
//        //int lp = -1, lq = -1;
//        int lp = func(root,p.val,-1);
//        int lq = func(root,q.val,-1);
//        if(lp != -1 && lq != -1){
//            int templen = lp + lq;
//            if(templen < len)ans.val = root.val;
//            dfs(root.left,p,q,ans,len);
//            dfs(root.right,p,q,ans,len);
//        }
//        return;
//    }
//
//    public static int func(TreeNode root, int key, int len){
//        if(root == null)return -1;
//        len++;
//        if(root.val == key)return len;
//        if(root.val > key){
//            return func(root.left,key,len);
//        }else if(root.val < key){
//            return func(root.right,key,len);
//        }
//        return -1;
//    }

    //方法2   记录从根节点到PQ节点的路径，遍历路径找到第一个“分叉点”
//    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
//        List<TreeNode> pathP = new ArrayList<>();
//        List<TreeNode> pathQ = new ArrayList<>();
//        getPath(root,p.val,pathP);
//        getPath(root,q.val,pathQ);
//        TreeNode ans = root;
//        for(int i = 0; i < pathP.size() && i < pathQ.size(); i ++){
//            if(pathP.get(i).val == pathQ.get(i).val){
//                ans = pathP.get(i);
//            }else{
//                break;
//            }
//        }
//        return ans;
//    }
//    public static void getPath(TreeNode root, int key, List<TreeNode> path){
//        if(root == null)return;
//        path.add(root);
//        if(root.val > key){
//            getPath(root.left,key,path);
//        }else if(root.val < key){
//            getPath(root.right,key,path);
//        }
//    }
    //方法3
    //如果P Q节点都比root节点小，说明结果一定在root节点的左边
    //如果P Q节点都比root节点大，说明结果一定在root节点的右边
    //除此之外，P Q节点分别在root节点的两端或者root节点就是P Q节点中的一个，结果就是root节点
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        //int为4个字节，每个字节占8位，一共是32为
        //long为8个字节，一共是64位
        while((long)(root.val - p.val) * (long)(root.val - q.val) > 0){
            root = root.val < p.val ? root.right : root.left;
        }
        return root;
    }
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(-1000000000);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(1000000000);
        node2.left = node1;
        node2.right = node3;
        TreeNode treeNode = lowestCommonAncestor(node2, node1, node3);
    }
}
