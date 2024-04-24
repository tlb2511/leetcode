package 链表.反转链表;

public class Solution {
     public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode reverseList(ListNode head) {
        if(head == null)return null;
        ListNode pre = null;
        ListNode second = null;
        while(head != null){
            second = head.next;
            head.next = pre;
            pre = head;
            head = second;
        }
        return pre;
    }
}
