/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode mid = findMid(head);
        ListNode n2 = sortList(mid.next);
        mid.next = null;
        ListNode n1 = sortList(head);
        
        return merge(n1,n2);
    }
    
    public ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head; 
        
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
    
    public ListNode merge(ListNode n1, ListNode n2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (n1 != null && n2 != null) {
            if (n1.val < n2.val) {
                head.next = n1;
                n1 = n1.next;
            }
            else {
                head.next = n2;
                n2 = n2.next;
            }
            head = head.next;
        }
        if (n1 != null) head.next = n1;
        else head.next = n2;
        return dummy.next;
    }
    
}