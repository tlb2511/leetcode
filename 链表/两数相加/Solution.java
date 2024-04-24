package 链表.两数相加;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode top = new ListNode(0);
        ListNode cur = top;
        int c = 0;
        while(l1 != null && l2 != null){
            int val = l1.val + l2.val + c;
            int v = val%10;
            ListNode node = new ListNode(v);
            cur.next = node;
            cur = cur.next;
            if(val >= 10){
                c = 1;
            }else{
                c = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            int val = l1.val + c;
            int v = val%10;
            ListNode node = new ListNode(v);
            cur.next = node;
            cur = cur.next;
            if(val >= 10){
                c = 1;
            }else{
                c = 0;
            }
            l1 = l1.next;
        }

        while(l2 != null){
            int val = l2.val + c;
            int v = val%10;
            ListNode node = new ListNode(v);
            cur.next = node;
            cur = cur.next;
            if(val >= 10){
                c = 1;
            }else{
                c = 0;
            }
            l2 = l2.next;
        }

        if(c == 1){
            ListNode node = new ListNode(1);
            cur.next = node;
            cur = cur.next;
        }
        return top.next;
    }
}
