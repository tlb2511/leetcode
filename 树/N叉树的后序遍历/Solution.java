package 树.N叉树的后序遍历;

import java.util.*;

public class Solution {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
//    public List<Integer> postorder(Node root) {
//        List<Integer> ans = new ArrayList<>();
//        dfs(root,ans);
//        return ans;
//    }
//    void dfs(Node root, List<Integer> ans){
//        if(root == null)return;
//        List<Node> children = root.children;
//        for(Node node :children){
//            dfs(node,ans);
//        }
//        ans.add(root.val);
//
//    }
    public List<Integer> postorder(Node root){
        List<Integer> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Deque<Integer> temp = new ArrayDeque<>();
        Deque<Node> stack = new ArrayDeque<>();
        Map<Node,Integer> map = new HashMap<>();
        Node node = root;
        while(!stack.isEmpty() || node != null){
            while(node != null){
                ans.add(node.val);
                temp.addLast(node.val);
                stack.addLast(node);
                List<Node> children = node.children;
                if(children != null && children.size() > 0){
                    map.put(node,children.size()-1);
                    node = children.get(children.size()-1);
                }else {
                    node = null;
                }
            }
            node = stack.getLast();
            int index = map.getOrDefault(node,0) - 1;
            if(index >= 0 && node.children != null){
                map.put(node,index);
                node = node.children.get(index);
            }else{
                map.remove(node);
                stack.removeLast();
                node = null;
            }
        }
        while(!temp.isEmpty()){
            res.add(temp.removeLast());
        }
        return res;
    }
}
