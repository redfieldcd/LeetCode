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
 
 // 先分别算出两个list的长度，然后把长的移到和短的一样的位置，开始比较，
 //如果剩下的部分相同就返回
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        
        ListNode heada = headA;
        ListNode headb = headB;
        while(heada != null) {
            heada = heada.next;
            lenA++;
        }
        
        while(headb != null) {
            headb = headb.next;
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