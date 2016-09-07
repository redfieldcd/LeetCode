/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 // Recursion
// public class Solution {
//     public TreeNode upsideDownBinaryTree(TreeNode root) {
//         if(root == null || (root.left == null && root.right == null)) return root;
        
//         TreeNode newNode = upsideDownBinaryTree(root.left);
        
//         root.left.left = root.right;
//         root.left.right = root;
        
//         root.left = null;
//         root.right = null;
        
//         return newNode;
//     }
// }

// Iteration
public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode curr = root;
        TreeNode prev = null;
        TreeNode next = null;
        TreeNode temp = null;
        
        while (curr != null) {
            next = curr.left;
            curr.left = temp;
            temp = curr.right;
            curr.right = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}