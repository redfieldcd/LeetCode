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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new LinkedList();
        height(res, root);
        return res;
    }
    
    public int height(List<List<Integer>> res, TreeNode root) {
        if(root == null) return -1;
        int level = 1 + Math.max(height(res, root.left), height(res, root.right));
        if(res.size() < level + 1) {
            res.add(new LinkedList());
        }
        res.get(level).add(root.val);
        return level;
        
    }
}