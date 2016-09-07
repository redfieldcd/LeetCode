/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // Recursion time: O(n) space: O(h) 
// public class Solution {
//     int max = 0;
//     public int longestConsecutive(TreeNode root) {
//         helper(root, 0, root.val);
        
//         return max;
//     }
    
//     public void helper(TreeNode root, int num, int target) {
//         if(root == null) return;
//         if(root.val  == target) num++; 
//         else num = 1;
//         max = Math.max(num, max);
        
//         helper(root.left, num, target+1);
//         helper(root.right, num, target+1);
//     }
// }


public class Solution {
    int max = 1;
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        helper(root, 1);
        return max;
    }
    
    public void helper(TreeNode root, int num) {
        if(root == null) return;
        
        if(root.left != null) {
            if(root.left.val == root.val + 1) {
                max = num+1 > max ? num+1 : max;
                helper(root.left, num+1);
            } else {
                helper(root.left, 1);
            }
        }
        
        if(root.right != null) {
            if(root.right.val == root.val + 1) {
                 max = num+1 > max ? num+1 : max;
                helper(root.right, num + 1);
            } else {
                helper(root.right, 1);
            }
        }
    }
}