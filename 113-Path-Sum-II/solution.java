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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList();
        
        if(root == null) return res;
        
        List<Integer> temp = new LinkedList();
        helper(res, root, sum, temp);
        
        return res;
    }
    
    public void helper(List<List<Integer>> res, TreeNode root, int sum, List<Integer> temp) {
        if(root.val == sum && root.left == null && root.right == null) {
            temp.add(root.val);
            List<Integer> list = new LinkedList(temp);
            res.add(list);
            temp.remove(temp.size()-1);
        } else {
            temp.add(root.val);
            if(root.left != null) helper(res, root.left, sum - root.val, temp);
            if(root.right != null) helper(res, root.right, sum - root.val, temp);
            temp.remove(temp.size() - 1);
        }
    }
}