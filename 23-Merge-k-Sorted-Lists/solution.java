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
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });
        ListNode node = new ListNode(0);
        ListNode head = node;
        
        for(ListNode ln: lists) {
            q.offer(ln);
        }
        
        while(!q.isEmpty()) {
            ListNode cur = q.poll();
            node.next = cur;
            node = node.next;
            q.offer(cur.next);
        }
        
        return head.next;
        
    }
}