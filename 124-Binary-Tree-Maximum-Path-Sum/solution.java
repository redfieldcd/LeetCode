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
    int max = 0;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
    
    public int dfs(TreeNode root) {
        if(root == null) return 0;
        
        int l = Math.max(0, root.left.val);
        int r = Math.max(0, root.right.val);
        
        max = Math.max(max, l + r + root.val);
        
        return Math.max(l, r) + root.val;
    }
}