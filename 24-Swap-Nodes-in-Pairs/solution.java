/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        
        ListNode pre = head;
        ListNode next = head.next;
        
        if(next == null) return pre;
        ListNode newHead = next.next;
        next.next = pre;
        pre.next = swapPairs(newHead);
        
        return next;
    }
    
    // public ListNode helper(ListNode head) {
        
    // }
}