/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 // 把后半个list reverse之后进行比较
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode n2 = slow.next;
        slow.next = null;
        
        ListNode head2 = reverse(n2);
        
        ListNode head1 = head;
        
        return isPalindrome(head1, head2);
    }
    
    public ListNode reverse(ListNode node) {
        ListNode pre = null;
        
        while(node != null) {
            ListNode temp = node.next;
            node.next = pre;
            pre = node;
            node = temp;
        }
        
        return pre;
    }
    
    //后半个list的head作为判断条件
    public boolean isPalindrome(ListNode head1, ListNode head2) {
        while(head2 != null) {
            if(head1.val != head2.val) return false;
            head1 = head1.next;
            head2 = head2.next;
        }
        
        return true;
    }
    
}