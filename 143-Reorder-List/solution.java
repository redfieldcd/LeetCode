/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        //find middle
        if(head == null) return;
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        // reverse second half
        ListNode head2 = reverse(slow.next);
        
        slow.next = null;
        
        ListNode dummy = new ListNode(0);
        
        ListNode curr = dummy;
        
        ListNode head1 = head;
        
        // merge two lists
        // 一定要一个一个的移动curr node,不然会出错
        while(head1 != null && head2 != null) {
            curr.next = head1;
            head1 = head1.next;
            curr = curr.next;
            curr.next = head2;
            head2 = head2.next;
            curr = curr.next;
        }
        
        if(head1 != null) {
            curr.next = head1;
        } else if (head2 != null) {
            curr.next = head2;
        }
        
        head = dummy.next;
    }
    
    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        
        while(head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        
        return pre;
    }
}