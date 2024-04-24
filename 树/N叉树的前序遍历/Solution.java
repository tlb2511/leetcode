package 树.N叉树的前序遍历;

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
//    public List<Integer> preorder(Node root) {
//        List<Integer> ans = new ArrayList<>();
//        func(root,ans);
//        return ans;
//    }
//    void func(Node root, List<Integer> ans){
//        if(root == null)return;
//        List<Node> ls = root.children;
//        ans.add(root.val);
//        for(Node node :ls){
//            func(node,ans);
//        }
//    }
        public static List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null)return ans;
        Deque<Node> stack = new ArrayDeque<>();
        Map<Node,Integer> map = new HashMap<>();
        Node node = root;
        while(!stack.isEmpty() || node != null){
            while(node != null){
                ans.add(node.val);
                stack.addLast(node);
                List<Node> children = node.children;
                if(children != null && children.size() >0){
                    map.put(node,0);
                    node = children.get(0);
                }else{
                    node = null;
                }
            }
            node = stack.getLast();
            int index = map.getOrDefault(node,-1) + 1;
            List<Node> children = node.children;
            if(children != null && children.size() > index){
                map.put(node,index);
                node = children.get(index);
            }else{
                stack.removeLast();
                map.remove(node);
                node = null;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        List<Node> c1 = new ArrayList<>();
        c1.add(node3);
        c1.add(node2);
        c1.add(node4);
        List<Node> c2 = new ArrayList<>();
        c2.add(node5);
        c2.add(node6);
        node1.children = c1;
        node3.children = c2;
        List<Integer> preorder = preorder(node1);
    }
}
