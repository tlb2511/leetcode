package 链表.环形链表;

public class Solution {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val = x;
            this.next = null;
        }

    }

    public Boolean hasCycle(ListNode head) {
        if(head == null)return false;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast.val == slow.val)return true;
        }
        return false;
    }
}
