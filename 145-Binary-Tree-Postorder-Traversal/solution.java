/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        traversal(root, list);
        return list;
    }
    
    public void traversal(TreeNode root, List<Integer> list) {
        if(root == null) return;
        traversal(root.left, list);
        traversal(root.right, list);
        list.add(root.val);
    }
}