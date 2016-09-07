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
    public int countUnivalSubtrees(TreeNode root) {
        int[] count = new int[1];
        isValid(root, count);
        return count[0];
    }
    
    public boolean isValid(TreeNode root, int[] count) {
        if(root == null) return true;
        
        boolean left = isValid(root.left, count);
        boolean right = isValid(root.right, count);
        
        if(left && right) {
          if(root.left != null && root.left.val != root.val) {
                return false;
            }
            
            if(root.right != null && root.right.val != root.val) {
                return false;
            } 
            count[0]++;
            return true;
        }
        return false;
    } 
}
