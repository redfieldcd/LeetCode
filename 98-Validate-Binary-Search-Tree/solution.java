/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// public class Solution {
//     public boolean isValidBST(TreeNode root) {
//         return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
//     }
    
//     // check whether root.val is smaller than max and larger than min
//     // check whetehr tree with root is a valid bst
//     public boolean helper(TreeNode root, long min, long max) {
//         if(root == null) return true;
        
//         if(root.val <= min || root.val >= max) {
//             return false;
//         }
        
//         return helper(root.left, min, root.val) && helper(root.right, root.val, max);
//     }
// }

// BFS
public class Solution {
    public boolean isValidBST(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        
        q.offer(root);
        
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node.left != null) {
                if(node.left.val >= node.val) return false;
                q.offer(node.left);
            }
            
            if(node.right != null) {
                if(node.right.val <= node.val) return false;
                q.offer(node.right);
            }
        }
        
        return true;
    }
    
}
