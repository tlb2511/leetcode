package 树.N叉树的层序遍历;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)return ans;
        Deque<Node> deque = new ArrayDeque<>();
        deque.addLast(root);
        int len = 1;
        int count = 0;
        while(!deque.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < len; i ++){
                Node node = deque.getFirst();
                deque.removeFirst();
                temp.add(node.val);
                for(int j = 0; j < node.children.size(); j ++){
                    deque.addLast(node.children.get(j));
                }
            }
            ans.add(temp);
            len = count;
            count = 0;
        }
        return ans;
    }
}
