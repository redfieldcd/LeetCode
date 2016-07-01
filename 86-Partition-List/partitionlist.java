/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummynode1 = new ListNode(0);
        ListNode dummynode2 = new ListNode(0);
        
        ListNode node1 = dummynode1;
        ListNode node2 = dummynode2;
        
        while(head!= null) {
            if (head.val < x) {
                node1.next = head;
                node1 = node1.next;
            } else {
                node2.next = head;
                node2 = node2.next;
            }
            head = head.next;
        }

        node2.next = null;
        node1.next = dummynode2.next;
        return dummynode1.next;
        
    }
}