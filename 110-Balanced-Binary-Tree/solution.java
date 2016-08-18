/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //两种解法，一种设置一个-1 mark,一种用全局变量
public class Solution {
    // public boolean isBalanced(TreeNode root) {
    //     if(root == null) return true;
    //     int ldepth = depth(root.left);
    //     int rdepth = depth(root.right);
    //     return ldepth != -1 && rdepth != -1 && Math.abs(ldepth - rdepth) <= 1;
    // }
    
    // public int depth(TreeNode root) {
    //     if(root == null) return 0;
    //     int left = depth(root.left);
    //     int right = depth(root.right);
    //     if(left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;
        
    //     return Math.max(left, right) + 1;
    // }
    
    boolean result = true;
    public boolean isBalanced(TreeNode root) {
        depth(root);
        return result;
    }
    
    public int depth(TreeNode root) {
        if(root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        
        if(Math.abs(left - right) > 1) {
            result = false;
        }
        
        return Math.max(left, right) + 1;
    }
}