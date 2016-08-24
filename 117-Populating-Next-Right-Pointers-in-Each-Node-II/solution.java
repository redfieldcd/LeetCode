/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
 public class Solution {
    //based on level order traversal
    public void connect(TreeLinkNode root) {
        TreeLinkNode head = null;
        TreeLinkNode pre = null;
        TreeLinkNode cur = root;
        
        while(cur != null) {
            while(cur != null) {
                if(cur.left != null) {
                    if(pre != null) {
                        pre.next = cur.left;
                    } else {
                        head = cur.left;
                    }
                    pre = cur.left;
                }
                
                if(cur.right != null) {
                    if(pre != null) {
                        pre.next = cur.right;
                    } else {
                        head = cur.right;
                    }
                    pre =cur.right;
                }
                
                cur = cur.next;
            }
            
            cur = head;
            pre = null;
            head = null;
        }
        
    }
}
