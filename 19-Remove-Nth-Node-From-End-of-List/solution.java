/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode slow = start;
        ListNode fast = start;
        slow.next = head;
        
        while(fast != null && n >= 0) {
            fast = fast.next;
            n--;
        }
        
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        } 
        
        slow.next = slow.next.next;
        
        return start.next;
    }
}