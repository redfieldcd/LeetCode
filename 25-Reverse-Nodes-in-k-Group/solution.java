/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
public class Solution {
       
   public  ListNode reverse(ListNode head, ListNode end){
	       if(head==null || head.next==null || head==end || head.next==end) return head;
	       ListNode sec = head.next;
	       ListNode rem = reverse(sec,end);
	       sec.next =head; head.next=null;
	       return rem;
	   }
	    public  ListNode reverseKGroup(ListNode head, int k) {
	        ListNode curr = head; int count = 0;
	        while (curr != null && count != k) {
	            curr = curr.next;count++;
	        }
	        if (count == k) {
	            ListNode temp = reverseKGroup(curr, k);
	            ListNode t = reverse(head,curr);
	            head.next = temp;
	            return t;
	        }
	        return head;
	    }
}

// public class Solution {
//     public ListNode reverseKGroup(ListNode head, int k) {
//         if(head == null) return head;
        
//         ListNode last = check(head, k);
        
//         if(last != null) {
//             ListNode next = last.next;
//             ListNode cur = reverse(head, last);
//             cur.next = reverseKGroup(next, k);
//             return last;
//         } else {
//             return head;
//         }
//     }
    
//     // 1 -> 2 -> 3  -----> 1 <- 2 <- 3
//     public ListNode reverse(ListNode head, ListNode tail) {
//         ListNode node = head;
//         ListNode pre = head;
//         head = head.next;
//         while(head != tail) {
//             ListNode temp = head.next;
//             head.next = pre;
//             pre = head;
//             head = temp;
//         }
        
//         return node;
//     }
    
//     public ListNode check(ListNode head, int k) {
//         int count = 1;
//         while(head.next != null && count != k) {
//             head = head.next;
//             count++;
//         }
        
//         if(count == k) return head;
//         else return null;
//     }
// }