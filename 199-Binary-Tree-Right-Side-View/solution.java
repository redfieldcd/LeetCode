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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList();
        
        rightView(root, res, 0);
        
        return res;
    }
    
    public void rightView(TreeNode root, List<Integer> res, int level) {
        if(root == null) return;
        
        if(res.size() == level) {
            res.add(root.val);
        }
        rightView(root.right, res, level + 1);
        rightView(root.left, res, level + 1);
    }
}