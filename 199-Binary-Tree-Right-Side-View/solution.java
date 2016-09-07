/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 //Recursion
 // Running time: O(n), space: O(h)
// public class Solution {
//     public List<Integer> rightSideView(TreeNode root) {
//         List<Integer> res = new LinkedList();
        
//         rightView(root, res, 0);
        
//         return res;
//     }
    
//     public void rightView(TreeNode root, List<Integer> res, int level) {
//         if(root == null) return;
        
//         if(res.size() == level) {
//             res.add(root.val);
//         }
//         rightView(root.right, res, level + 1);
//         rightView(root.left, res, level + 1);
//     }
// }

//Iteration Based on level order traversal
//running time: O(n) space: O(n)
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        List<Integer> res = new LinkedList();
        
        if(root == null) return res;
        q.offer(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                
                if(size - 1 == i) {
                    res.add(node.val);
                }
                
                if(node.left != null) {
                    q.offer(node.left);
                }
                
                if(node.right != null) {
                    q.offer(node.right);
                }
            }
        }
        return res;
    }
}



