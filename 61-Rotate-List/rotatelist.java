/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode slow = dummy;
        ListNode fast = dummy;
        
        dummy.next = head;
        int len = 0;
        while(fast.next != null) {
            len++;
            fast = fast.next;
        }
        
        int n = len - k % len;
        
        for(int i = 0; i < n; i++) {
            slow = slow.next;
        }
        
        fast.next=dummy.next; //Do the rotation
        dummy.next=slow.next;
        slow.next=null;
    
        return dummy.next;
    }
}