/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 // running time O(n), space O(h)
// public class Solution {
//     public TreeNode sortedArrayToBST(int[] nums) {
//         if(nums == null || nums.length == 0) return null;
//         return helper(nums, 0, nums.length - 1);
//     }
    
//     public TreeNode helper(int[] nums, int start, int end) {
//         if(start > end) return null;
        
//         //avoid integer overflow
//         int mid = start + (end - start) / 2;
        
//         TreeNode root = new TreeNode(nums[mid]);
        
//         root.left = helper(nums, start, mid - 1);
//         root.right = helper(nums, mid + 1, end);
        
//         return root;
//     }
// }

// Iteration
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        Queue<TreeNode> node = new LinkedList();
        Queue<Integer> left = new LinkedList();
        Queue<Integer> right = new LinkedList();
        
        TreeNode root = new TreeNode(0);
        node.offer(root);
        left.offer(0);
        right.offer(nums.length-1);
        
        while(!node.isEmpty()) {
            TreeNode cur = node.poll();
            int l = left.poll();
            int r = right.poll();
            
            int mid =l + (r - l) / 2;
            cur.val = nums[mid];
            
            if(l <= mid - 1) {
                cur.left = new TreeNode(0);
                node.offer(cur.left);
                left.offer(l);
                right.offer(r);
            }
            
            if(r >= mid + 1) {
                cur.right = new TreeNode(0);
                node.offer(cur.right);
                left.offer(mid + 1);
                right.offer(r);
            }
        }
        
        return root;
    }
}