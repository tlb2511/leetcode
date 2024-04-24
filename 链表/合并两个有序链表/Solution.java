package 链表.合并两个有序链表;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next;
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode top = new ListNode(-1);
        ListNode cur = top;
        while(l1 != null && l2 != null){
            ListNode node = new ListNode();
            if(l1.val <= l2.val){
                node.val = l1.val;
                cur.next = node;
                cur = cur.next;
                l1 = l1.next;
            }else{
                node.val = l2.val;
                cur.next = node;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        while(l1 != null){
            ListNode node = new ListNode(l1.val);
            cur.next = node;
            cur = cur.next;
            l1 = l1.next;
        }
        while(l2 != null){
            ListNode node = new ListNode(l2.val);
            cur.next = node;
            cur = cur.next;
            l2 = l2.next;
        }
        return top.next;
    }
}
