/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode dummy = head;
        int add = 0;
        while(l1 != null && l2 != null) {
            head.next = new ListNode((l1.val + l2.val+add)%10);
            add = (l1.val + l2.val + add)/10;
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while(l1 != null) {
           head.next = new ListNode((l1.val+add)%10);
           add = (l1.val + add)/10; 
           head = head.next;
           l1 = l1.next;
        } 
        
        while(l2 != null) {
           head.next = new ListNode((l2.val + add)%10);
           add = (l2.val + add)/10; 
           head = head.next;
           l2 = l2.next;
        } 
        
        if(add != 0) head.next = new ListNode(add);
        
        return dummy.next;
    }
}