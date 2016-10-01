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

// inorder
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> s = new Stack();
        long pre = Long.MIN_VALUE;
        s.push(root);
        
        while(!s.isEmpty()) {
            while(root.left != null) {
                s.push(root.left);
                root = root.left;
            }
            
            root = s.pop();
            
            if(root.val <= pre)  return false;
            
            pre = root.val;
            
            if(root.right != null) {
                root = root.right;
            }
        }
        
        return true;
    }
    
}
