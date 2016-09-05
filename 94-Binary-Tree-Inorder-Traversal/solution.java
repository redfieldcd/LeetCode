/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// recursion
// public class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> list = new LinkedList();
        
//         if(root == null) return list;
        
//         list.addAll(inorderTraversal(root.left));
//         list.add(root.val);
//         list.addAll(inorderTraversal(root.right));
        
//         return list;
//     }
// }


// Iteration
// 先把左右的left都入栈
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList();
        Stack<TreeNode> s = new Stack();
        
        while(root != null || !s.isEmpty()) {
            while(root != null) {
                s.push(root);
                root = root.left;
            }
            
            root = s.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }
}








