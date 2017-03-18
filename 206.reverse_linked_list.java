/*
 * 关联题目：linked list
 * 相同：
        
 * 不同：  
        
 * 疑问：
        
 * 时间复杂度：
 */

public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        ListNode tmp = null;
        ListNode cur = head;
        ListNode prev = null;
        while(cur.next != null){
            tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        cur.next = prev;
        return cur;
    }
}