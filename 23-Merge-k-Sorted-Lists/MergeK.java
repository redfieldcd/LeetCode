/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return partion(lists, 0, lists.length-1);
    }
    
    public ListNode partion(ListNode[] lists, int i, int j) {
        if(i == j) return lists[i];
        if(i < j) {
            int mid = i + (j-i)/2;
            ListNode l1 = partion(lists, i, mid);
            ListNode l2 = partion(lists, mid + 1, j);
            return merge(l1, l2);
        } else {
            return null;
        }
    }
    
    public ListNode merge(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head;
        if(l1.val < l2.val) {
            head = l1;
            head.next = merge(l1.next, l2);
        } else {
            head = l2;
            head.next = merge(l1, l2.next);
        }
        return head;
    }
}