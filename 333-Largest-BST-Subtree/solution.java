/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 // Time: O(n^2) Space: O(log(n) ^ 2)
public class Solution {
    public int largestBSTSubtree(TreeNode root) {
        if(root == null) return 0;
        if(isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) return countNode(root);
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }
    
    //判断以root为根的是不是BST
    public boolean isValid(TreeNode root, Integer min, Integer max) {
        if(root == null) return true;
        if(min >= root.val) return false;
        if(max <= root.val) return false;
        
        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }
    
    public int countNode(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        return 1 + countNode(root.left) + countNode(root.right);
    }
}