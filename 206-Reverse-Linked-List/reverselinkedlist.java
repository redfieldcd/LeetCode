/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
//  pre 到最后一个的时候循环结束
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
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