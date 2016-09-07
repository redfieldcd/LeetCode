/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // Recursion
 //Time O(n), Space O(h)
// public class Solution {
//     public boolean isSameTree(TreeNode p, TreeNode q) {
//         if(p == null && q == null) return true;
//         if(p == null || q == null) return false;
        
//         if(p.val != q.val) return false;
       
//         return isSameTree(p.left, q.left) && isSameTree(p.right, q.right); 
//     }
// }

//Iteration based on inorder traversal
// public class Solution {
//     public boolean isSameTree(TreeNode p, TreeNode q) {
//         Stack<TreeNode> stackP = new Stack();
//         Stack<TreeNode> stackQ = new Stack();
        
//         while((p != null || !stackP.isEmpty()) && (q != null || !stackQ.isEmpty())) {
//             while(p != null && q != null) {
//                 stackP.push(p);
//                 p = p.left;
//                 stackQ.push(q);
//                 q = q.left;
//             }
            
//             TreeNode nodeP = stackP.pop();
//             TreeNode nodeQ = stackQ.pop();
            
//             if(nodeP.val != nodeQ.val) return false;
//             p = p.right;
//             q = q.right;
//         }
        
//         return stackP.size() == stackQ.size();
//      }
// }

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> stackP = new Stack();
        Stack<TreeNode> stackQ = new Stack();
        
        if(p != null) stackP.push(p);
        if(q != null) stackQ.push(q);
        
        while(!stackP.isEmpty() && !stackQ.isEmpty()) {
            TreeNode nodeP = stackP.pop();
            TreeNode nodeQ = stackQ.pop();
            
            if(nodeP.val != nodeQ.val) return false;
            
            if(nodeP.right != null) stackP.push(nodeP.right);
            if(nodeQ.right != null) stackQ.push(nodeQ.right);
            if(stackP.size() != stackQ.size()) return false;
            
            if(nodeP.left != null) stackP.push(nodeP.left);
            if(nodeQ.left != null) stackQ.push(nodeQ.left);
            if(stackP.size() != stackQ.size()) return false;
        }
        
        return stackP.size() == stackQ.size();
    }
}