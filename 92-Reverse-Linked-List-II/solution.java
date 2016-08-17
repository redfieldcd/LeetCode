/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 //reverse linkedlist 记住三个点，||记住五个点
 // 一共三个步骤，找初始点，reverse, 连接
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        for(int i = 1 ; i < m; i++){
            head = head.next;
        }
        ListNode headOfSubList = head.next;
        ListNode nodeBeforeHead = head;
        ListNode nextNode = head.next.next;
        ListNode currNode = head.next;
        for(int i = m; i < n ; i++){
            ListNode tmp = nextNode.next;
            nextNode.next = currNode;
            currNode = nextNode;
            nextNode = tmp;
        }
        headOfSubList.next = nextNode;
        nodeBeforeHead.next = currNode;
        return dummy.next;
    }
}