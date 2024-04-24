package 链表.删除排序链表中的重复元素II;

public class Solution82 {

     public class ListNode {
         int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
     }

    /**
     * 需要额外创建空间，不是最优解
     * @param head
     * @return
     */
    /**
    public ListNode deleteDuplicates(ListNode head) {
        ListNode top = head;
        ListNode hail = head;
        ListNode res = new ListNode(-1);
        ListNode temp = new ListNode(-1);
        res.next = temp;
        int count = 0;
        while(head != null){
            count = 0;
            hail = head.next;
            while(hail != null && hail.val == head.val){
                count++;
                hail = hail.next;
            }
            if(count == 0){
                temp.next = new ListNode();
                temp.next.val = head.val;
                temp = temp.next;
            }
            head = hail;

        }
        return res.next.next;
    }
     **/

    /**
     * 最优解 O（N）
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head){
        if(head == null)return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while(cur.next != null && cur.next.next != null){
            if(cur.next.val == cur.next.next.val){
                int x = cur.next.val;
                while(cur.next.val == x){
                    cur.next = cur.next.next;
                }
            }else{
                cur = cur.next;
            }
        }
        return  dummy.next;
    }
}
