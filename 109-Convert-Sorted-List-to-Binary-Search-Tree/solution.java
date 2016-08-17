/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    ListNode curr;
    public TreeNode sortedListToBST(ListNode head) {
        curr = head;
        int len = 0;
        while(head != null) {
            head = head.next;
            len++;
        }
        return buildTree(0, len-1);
    }
    
    public TreeNode buildTree(int start, int end) {
        if(start > end) {
            return null;
        }
        //find middle
        int mid = start + (end - start)/2;
        
        TreeNode left = buildTree(start, mid-1);
        
        TreeNode root = new TreeNode(curr.val);
        curr = curr.next;
        
        TreeNode right = buildTree(mid+1, end);
        
        root.left = left;
        root.right = right;
        return root;
    }
}