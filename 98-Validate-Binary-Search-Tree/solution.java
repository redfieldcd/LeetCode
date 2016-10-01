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
    public boolean isValidBST(TreeNode root) {
        if(root.left == null || root.right == null) return true;
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    // check whether root.val is smaller than max and larger than min
    // check whetehr tree with root is a valid bst
    public boolean helper(TreeNode root, int min, int max) {
        if(root == null) return true;
        
        if(root.val <= min || root.val >= max) {
            return false;
        }
        
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}
