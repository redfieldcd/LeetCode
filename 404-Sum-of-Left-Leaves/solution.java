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
//     public int sumOfLeftLeaves(TreeNode root) {
//         int sum = 0;
//         if(root == null) return 0;
        
//         if(root.left != null) {
//             if(root.left.left == null && root.left.right == null) sum += root.left.val;
//             else sum += sumOfLeftLeaves(root.left);
//         }
        
//         if(root.right != null) {
//             sum += sumOfLeftLeaves(root.right);
//         }
        
//         return sum;
//     }
// }


//BSF
// public class Solution {
//     public int sumOfLeftLeaves(TreeNode root) {
//         int sum = 0;
//         Queue<TreeNode> q = new LinkedList();
        
//         q.offer(root);
        
//         while(!q.isEmpty()) {
//             TreeNode node = q.poll();
            
//             if(node.left != null) {
//                 if(node.left.left == null && node.left.right == null) sum += node.left.val;
//                 q.offer(node.left);
//             } 
            
//             if(node.right != null) {
//                 q.offer(node.right);
//             }
//         }
        
//         return sum;
//     }
// }

//dfs iteration
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        Stack<TreeNode> s = new Stack();
        
        s.push(root);
        
        while(!s.isEmpty()) {
            TreeNode node = s.pop();
            
            if(node.right != null) s.push(node.right);
            
            if(node.left != null) {
                if(node.left.left == null && node.left.right == null) sum += node.left.val;
                s.push(node.left);
            }
        }
        
        return sum;
    }
}