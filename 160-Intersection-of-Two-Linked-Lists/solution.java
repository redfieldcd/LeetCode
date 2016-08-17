/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        while(headA != null) {
            headA = headA.next;
            lenA++;
        }
        
        while(headB != null) {
            headB = headB.next;
            lenB++;
        }
        
        for(int i = 0; i < Math.abs(lenA - lenB); i++) {
            if(lenA > lenB) {
                headA = headA.next;
            } else {
                headB = headB.next;
            }
        }
        
        
        while(headA != null) {
            if(headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        
        return null;
    }
}