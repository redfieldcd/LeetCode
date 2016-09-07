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


// public class Solution {
//     int max = 1;
//     public int longestConsecutive(TreeNode root) {
//         if(root == null) return 0;
//         helper(root, 1);
//         return max;
//     }
    
//     public void helper(TreeNode root, int num) {
//         if(root == null) return;
        
//         if(root.left != null) {
//             if(root.left.val == root.val + 1) {
//                 max = num+1 > max ? num+1 : max;
//                 helper(root.left, num+1);
//             } else {
//                 helper(root.left, 1);
//             }
//         }
        
//         if(root.right != null) {
//             if(root.right.val == root.val + 1) {
//                  max = num+1 > max ? num+1 : max;
//                 helper(root.right, num + 1);
//             } else {
//                 helper(root.right, 1);
//             }
//         }
//     }
// }

//BFS
public class Solution {
    public int longestConsecutive(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        Queue<Integer> num = new LinkedList();
        if(root == null) return 0;
        int max = 1;
        q.offer(root);
        num.offer(1);
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0 ; i < size; i++) {
                TreeNode node = q.poll();
                int count = num.poll();
                
                if(node.left != null) {
                    q.offer(node.left);
                    if(node.left.val == node.val + 1) {
                        num.offer(count + 1);
                        max = Math.max(max, count + 1);
                    } else {
                        num.offer(1);
                    }
                }
                
                if(node.right != null) {
                    q.offer(node.right);
                    if(node.right.val == node.val + 1) {
                        num.offer(count + 1);
                        max = Math.max(max, count + 1);
                    } else {
                        num.offer(1);
                    }
                }
            }
        }
        
        return max;
    }
}