/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // 分为四种情况，左右子树都不为空，左子树为空，右子树为空，左右子树都为空(depth == 1)
public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int depth = 0;
        
        if(root.left != null && root.right != null) {
            depth = Math.min(minDepth(root.left), minDepth(root.right));
        } else if(root.left != null) {
            depth = minDepth(root.left);
        } else if(root.right != null) {
            depth = minDepth(root.right);
        }
        
        return depth+1;
    }
}