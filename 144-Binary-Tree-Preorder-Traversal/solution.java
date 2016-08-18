/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
// Divide & Conquer
// public class Solution {
//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> res = new LinkedList<Integer>();
//         if(root == null) return res;
        
//         List<Integer> left = preorderTraversal(root.left);
//         List<Integer> right = preorderTraversal(root.right);
        
//         res.add(root.val);
//         res.addAll(left);
//         res.addAll(right);
        
//         return res;
//     }
// }

// iteration
// public class Solution {
//     public List<Integer> preorderTraversal(TreeNode root) {
//         Stack<TreeNode> s = new Stack<TreeNode>();
//         List<Integer> list = new LinkedList<Integer>();
//         if(root == null) return list;
//         s.push(root);
        
//         while(!s.isEmpty()) {
//             TreeNode node = s.pop();
//             if(node.right != null) {
//                 s.push(node.right);
//             }
            
//             if(node.left != null) {
//                 s.push(node.left);
//             }
            
//             list.add(node.val);
//         }
//         return list;
//     }
// }


//recursion
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        if(root == null) return list;
        traversal(root, list);
        return list;
    }
    
    public void traversal(TreeNode root, List<Integer> list) {
        list.add(root.val);
        traversal(root.left, list);
        traversal(root.right, right);
    }
}