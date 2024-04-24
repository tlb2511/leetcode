package 链表.随机链表的复制;

public class Solution {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        Node temp = head;
        Node top = new Node(-1);
        Node cur = top;
        while(temp != null){
            Node node = new Node(temp.val);
            cur.next = node;
            cur = cur.next;
            temp = temp.next;
        }
        return temp;
    }
}
